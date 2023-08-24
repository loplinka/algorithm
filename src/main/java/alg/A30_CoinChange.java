package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

import java.util.Arrays;

/**
 *
 *
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247493719&idx=1&sn=edfeed0628a26fd665a105fa003bfaa2&chksm=9bd4165faca39f49946dcbe3f2b98f3a2eb5fa0efe980ebf904d2dce6841f5f6241c149ef80f&scene=178&cur_album_id=2165170016067944448#rd
 *
 * ����һ����������coins����ʾ��ͬ����Ӳ�ң��Լ�һ������amount����ʾ�ܽ�
 *
 * ���㲢���ؿ��Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ����� -1���������Ϊÿ��Ӳ�ҵ����������޵ģ���
 *
 * ʾ�� 1��
 *
 * ���룺coins = [1, 2, 5], amount = 11
 * �����3
 * ���ͣ�11 = 5 + 5 + 1
 *
 *
 * @author baojiang
 * @version ��Ǯ�һ�: alg.A30_CoinChange.java, v 0.1 2022��10��23�� ����5:23 baojiang Exp $
 */
public class A30_CoinChange {

    class Solution {
        int[] memo;

        public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            // dp ����ȫ����ʼ��Ϊ����ֵ
            Arrays.fill(memo, -666);
            return dp(coins, amount);
        }

        int dp(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            // �鱸��¼����ֹ�ظ�����
            if (memo[amount] != -666) {
                return memo[amount];
            }

            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                // ����������Ľ��
                int subProblem = dp(coins, amount - coin);
                // �������޽�������
                if (subProblem == -1) continue;
                // ����������ѡ�����Ž⣬Ȼ���һ
                res = Math.min(res, subProblem + 1);
            }
            // �Ѽ��������뱸��¼
            memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
            return memo[amount];
        }
    }

}