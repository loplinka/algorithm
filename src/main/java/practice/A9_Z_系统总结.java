/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

/**
 *
 * @author Baojiang Yang
 * @version : A9_Z_系统总结.java, v 0.1 2023年12月06日 08:55  Baojiang Yang Exp $
 */
public class A9_Z_系统总结 {
    /**
     *
     * 一.实时规则引擎
     *
     * 背景?
     * 老的模型系统是一个第三方依赖的方式集成在决策系统中,决策本身出了规则计算还承担了其他诸如咨询、记账等职能,经过大促和业务的长期发展后,
     * 逐渐暴露出以下弊端:
     * 1.系统职能不清晰,隔离性差,系统启动慢,不支持灰度发布,包括本地测试用例慢等
     * 2.双十一大促下系统资源得不到充分利用,(因为一味地扩容,资源没有得到最大化的利用,而规则引擎本身的逻辑并不复杂)
     *
     * 目标?
     * 为解决上述目标问题,就进行规则引擎系统的抽离并重建,达到以下的目的:
     * 1.解决原有痛点问题: 职能清晰,隔离性强,系统启动慢无法改变但是不拖慢原决策系统,支持灰度切流(原应用发布支持机房,机器,逻辑单元等灰度发布,
     *      此处的灰度切流是指模型上线后,老版本模型切换到新版本模型的灰度,因为是动态加载,不存在规则应用本身的发布嘛)
     * 2.承担离线到实时的数据同步职能,通过离线数据同步+调度任务+SPI的方式,实现离线数据同步到业务系统的基础能力;
     *      举例:给系统中参与了双十一活动的的指定用户,发一条营销短信,告诉他们的双十二的活动情况?
     * 3.集成新版本的风控大脑平台,进行规则的开发和管理,这个是探索性的
     * 基于以上3点,新模型系统就开始建设
     *
     *
     * 怎么做?
     * (一)规则引擎业务:
     * 1.开发语言:
     *      就选择普遍使用的java
     * 2.领域分析和指标管理:
     *      (1)输出:经过分析发现,规则引擎计算出来的可是准入额度利率等标准的授信要素,也可以黑白名单等非授信要素,那么规则引擎的输出就无法枚举,所以我们采用Map数据结构
     *      作为模型的标准输出,KV由业务自己进行定义
     *      (2)输入:指标管理:指标就是模型的各种输入数据,这些指标管理要求全局唯一和命名有可读性以达到高度的复用的目的,试用大领域+指标含义+具体业务+版本号进行命名,加上中文注释,然后系统自动生成即可
     * 3.动态发布:
     *      (1)采用Java动态代理机制实现动态发布,也就是用classLoader生成Proxy,然后method.invoke (已知相关技术有OSGi、Java插件机制、动态类加载、动态代理、类的动态生成等)
     *      (2)每个规则包,大业务相同的使用一个Git工程,里边不同字业务的采用bundle进行区分; 比如:淘系列就是一个git工程,套系的下天猫就是一个bundle,淘宝是另一个bundle,1688就是另一个bundle
     * 4.版本管理:
     *      规则引擎下的一个规则包,是一个不断升级的过程,我们采用AB机制,引擎中实时在跑两个版本的规则包,一本版本生效,一个版本升级备用
     *      具体来说:新规则包上线,规则引擎会自动发布1.0和1.1两个版本,并且以高版本为生产结果; 但我们升级规则包时候,低版本的1.0升级到1.2-beta,经过现在测试符合预期后,正式升级到1.2.原1.1版本失效,但仍然存在于内存中,准备下一个版本升级
     * 5.数据一致性:
     *      每个规则包对应唯一Id,设计一张配置表,同一个id存一高一低两个版本的配置数据,在同一个张表,AB切换的时候采用本地事务,保证升级切换过程中的数据一致性,也就是只会有有一个版本的生效,同时具备回滚能力
     * 6.灰度切流:
     *      AB版本切换过程中,不是一把切的,是会根据每个版本包的配置的灰度规则进行灰度的,我们有按照时间的百分比和用户进行灰度两种策略
     *      具体来说就是: 淘宝商家信用贷款,这个政策模型,1.1版本切换到1.2版本过程中,配置灰度规则[1小时11%,第二小时10%,第三小时30%],跑规则时候,会根据当前时间和模型发布时间做计算,看命中那个贵规则阶梯
     *                  再根据当前用用户id倒数二三位,进行百分比匹配,决定采用哪一个版本的规则包,再去跑规则; (实际两个规则包一起跑,后续讲为什么)
     *
     * 挑战点或者难点?
     * A:如何保证规则包的动态发布要求?
     *      技术上采用JavaJava动态代理机制实现动态发布
     * B.如何保证规则上线的准确性?
     *      测试角度分析:
     *          保证单元测试覆盖率100%(开发人员)
     *          使用生产流量验证线下测试规则,A版本在跑,B版本升级发布,试用A版本的流量同时输入B版本,让验证结果落地成日志然后回流到离线,政策整体验证整体结果是否符合预期(政策人员)
     *          这就是上述所说的,实际高低两个版本规则包是一起跑的,因为另一个一般用于测试验证下一个版本规则
     * C:如何保证规则包发布的安全性?
     *      AB两个版本包,同时存在于内存中,切换采用本地事务,保证数据一致性,业务的安全性
     * D:如何保证规则引擎的计算高效性?
     *      对于单个规则包来说,
     *      1.所需要的输入的数据先加工,后使用,按照人维度进行加工或者采集,落到本地库去(单次DAO 就是3-5ms)
     *      2.计算规则加载到内存中,仅输入数据,然后内存if else的路由,内存非IO操作计划没有成本
     *      3.减少多次DAO,避免出现RPC,跨库,跨机房等耗时或者不稳定的操作
     *
     * (二)离线反向实时调度系统:
     * 背景?
     *  各个业务系统经常有从离线按照规则清洗数据,然后同步到实时库,再使用调度任务批量捞起,实现具体的业务等诉求或者场景,这个任务可能是定期的,也可能是一次性的
     *  比如离线清洗名单,清洗结束后实时发短信; 离线计算客户的应还账款,逾期金额每天发送等;
     *  包括我们规则引擎系统本身,也逐渐发展了很多这样的业务,每次都是离线清洗,实时任务捞取,硬编码的成分偏多,没有规范化抽象化流程
     *
     * 目标?
     *  抽象化一个离线反向调度系统,让(1)离线数据清洗->(2)数据同步到实时库->(3)批量调度->(4)调度后实现具体业务,这个四大步骤,业务仅关注业务两端,不关注中间过程,降本增效
     *
     * 怎么做?
     *  规范领域模型:
     *      (1)进过分析总结,离线数据反向调度系统,其实就是围绕着业务数据流转展开的,那么我们定义一个叫做SYNC_DOMAIN的数据模型,
     *      (2)它由BIZ_ID,BIZ_TYPE,STATUS,SCHEDULE_RATE,BIZ_DATA这几个核心领域对象组成,分别代表了XXX,在ER关系上,我们使用主任务和子任务1对多的模型,即一个业务ID,对应100张表存子任务,保证并发性,数据维度一般是用户维度
     *      (3)其中最重要的是业务ID和业务数据,一个用于区分业务类型,一个是业务驱动所需要的内部数据,也就是实时做具体业务所需要离线加工出来的数据,数据结构使用MAP
     *  流程抽象和统一:
     *      固定步骤: (1)离线数据清洗->(2)数据同步到实时库->(3)批量调度->(4)调度后实现具体业务
     *
     *      用户侧 A:用户固定实现步骤(1)数据离线清洗,然后同步到我们的系统的固定表中,其实就是同步到上述数据模型下的BIZ_DATA字段下成为一个JSON
     *              其中我们实现了一个离线依赖包,用于对用户屏蔽掉数据库连接,插入等操作,让业务专注于写自己的清洗SQL,加工成JSON即可,当然,业务还要办法一个全局唯一的BIZ_ID进行区分
     *            B:用户再固定实现步骤(4),即在业务末端继承实现我们的通用接口,然后获取离线加工的数据,用于做自己的业务,完成后就等着离线加工任务完成,就会哟调度任务RPC进行业务驱动
     *      平台侧:
     *            C:具体技术是SPI,他是一种服务发现机制,针对接口和实现进行解耦,原理是基于查找和装载机制的动态加载方式,当然,业务系统在JVM启动的时候就要上述分配的全局唯一BIZ_ID进行付业务SPI注册
     *            D:批量调度任务的实现,我们和借呗进行了共建
     *             相比传统的调度任务,在任务拉起的时候可能出现CPU尖刺,导致服务器资源没有得到最大化的利用而且有宕机的风险
     *
     * 挑战点或者难点?
     *  离线数据清洗和同步不是难点,这是阿里云提供的基础设施
     *  A:SPI技术的使用
     *  B:调度任务实时和高效(并发和低延迟)
     *     分布式:
     *     服务资源的最大化利用:
     *     策略问题:
     *
     *
     * 二.产品工厂方案
     *
     *
     *
     */
}