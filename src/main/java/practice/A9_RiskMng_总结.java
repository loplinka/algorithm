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
     *
     * 二.贷中:交易
     *
     * 三.贷后
     *  催收
     *  资金、资产
     *  对账、核销、上报等
     *
     * 风控贯穿整个生命周期,贷前贷中贷后(催收预警)都有风控
     *
     * 什么是风控(Risk Management): 银行宏观的风控有信用风险管理、市场风险管理、流动性风险管理、操作风险管理以及合规性风险管理等,我们信贷系统的风控主要是信用风险管理
     *
     * 如何风控:
     * 1.人员: 政策风控人员,技术实现人员
     * 2.政策出规则,技术来实现
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
     */
}