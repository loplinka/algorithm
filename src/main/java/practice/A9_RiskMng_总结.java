/**
 * Hailiang.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package practice;

/**
 * @author Baojiang Yang
 * @version : A9_RiskMng_总结.java, v 0.1 2023年11月19日 13:25  Baojiang Yang Exp $
 */
public class A9_RiskMng_总结 {

    /**
     * 贷款的要素: 准入,额度,利率/费率,期限(支用期限和授信有效期),还款方式 等
     *
     * 生命周期:
     * 一.贷前:审批
     * 二.贷中:交易
     * 三.贷后
     *  催收
     *  资金、资产
     *  对账、核销、征信上报等
     *
     * 风控贯穿整个生命周期,贷前贷中贷后(催收预警)都有风控
     * 什么是风控(Risk Management): 银行宏观的风控有信用风险管理、市场风险管理、流动性风险管理、操作风险管理以及合规性风险管理等,我们信贷系统的风控主要是信用风险管理
     *
     * 如何风控:
     * 1.人员: 政策风控人员,技术实现人员
     * 2.政策出规则,技术来实现
     *
     *
     *
     * 做的事情:
     * 一.40%技术翻译政策规则(实时用Java,Drools,离线用SQL),以实时模型的方式输出给上游
     *      特点:快速,准确,高效
     *     A:如何保证实施模型的计算高效?
     *      1.数据先加工,后使用,按照人维度进行加工或者采集,落到本地库去(DAO 就是3-5ms)
     *      2.计算规则加载到内存中,仅输入数据,然后内存if else
     *      3.减少多次DAO,数据按照维度实现加工好,避免出现RPC等耗时或者不稳定的操作
     *     B:在美团做得事情
     *     1.没有数据加工,没有模型规则开发,只有实时业务系统接手到授信申请请求(进件)跑模型,得到结果向交易系统提供
     *     2.原因:一个企业文化不一样,按照传统银行来算的,模型对我们风控团队来说是黑盒; 离线大数据能力非常薄弱,因为没有数据源来作为授信依据,所以只能实时跑模型,严重依赖征信; 风控等基础非常薄弱,起码20年时候还非常薄弱
     *     3.我曾经试图想了解我们研发进行规则开发的可能,但是最后确定没有可能性,最终可能因为他们风控觉得政策规则是风控核心机密不让政策以外的接触,或者触及某些人的利益最终未能成行
     *       最后的贡献也是设计了的生意贷风控系统模型,然后进行落地,把部分业务进行了迁移
     *       核心:使用领域驱动设计,总结了核心领域模型,就是订单,围绕订单模型(此处的模型区别上述说的模型,上边的jar,这个里是领域domain),有数据加工模型,和落地了新的风控系统,
     *           去除原来的责任链的模型,采用简单策略模式,简单易读(可读性也是金融系统的非常重要的指标,因为稳定大于一切,宁可不做也不做错)
     *
     *
     * 二.30%产品的业务迭代: 上线一款房抵贷产品等
     *      综合能力,头狼落地能力
     *      代表项目: 房抵贷
     *      特点就是理解业务,和北京贷前团队配合,我从渠道,到交易,到决策,到底层风控模型,全链路开发,最终交付上线
     *
     *
     * 三.30%系统的稳定性建设(高可用,高并发,高性能,容灾等),比如一键熔断,一键降级,一键切副本库等
     *      数据库集群挂了,如何确保业务不跌零,可用率大于50%?
     *          把数据写入源分为实时和离线两部分
     *          实时(业务系统写入的):10库100表在一个OB集群,现在分散到10个集群上,每个集群仅存一个库,这个样集群怪最毒影响10%
     *          离线(离线SQL同步的):离线同步到实时库时候同步两份到两个集群,流量50%均分到这两个集群,一个集群挂了,预警出来,分钟级切换手动切换到另一个集群
     *          难点:思路很清晰也很简单,难点在于如何在日均4wQPS一秒不停服的前提下把所有数据挪动到别的集群上去?
     *          作法: 双写,灰度,回滚
     *                 1.初始化同步数据单向,A集群到B集群之间有延迟,流量打到A集群上
     *                 2.选择夜晚1点业务低峰期,QPS降低上千级别,开启双向同步且强一致,此时要求主副本和备副本都同步完成,业务才返回,此时会有牺牲一定的耗时,但是可以接受
     *                 3.流量灰度切换过去,1%,3%,5%,10%,以后隔天切10%过去,次日观察业务是否正常,有问题就回切,没问题就继续切,直到100%,前后耗时2个月
     *
     * 技术:
     * 一.离线
     *  1.数据加工
     *
     * 二.实时
     *  1.数据导入
     *  2.模型计算
     *  3.Beta
     *
     * 三.具体实现
     *  1.模型: Drools和Java
     *  2.Beta, ABTest
     *  3.离线加工导实时
     *  4.离线到实时导入
     *
     * 四.系统设计
     *  1.使用领域驱动设计DDD
     *  2.设计/总结核心领域模型
     *  3.围绕领域模型,服务业务
     *
     *
     */


    /**
     *
     * 问题咨询:
     * 1.目前的风控业务的客户量级,年度越规模多少,不良率,QPS量级
     * 2.目前业务上遇到的普遍难点是什么,怎么解决的
     * 3.目前增长遇到的最大难点是什么,怎么解决的
     * 4.目前风控团队的规模如何,主要由哪些人员构成
     * 5.目前是否有业务架构师这个角色存在,他的主要职能是什么
     * 6.你们如何做系统高可用的基本逻辑是什么?
     */
}