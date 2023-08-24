package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**

 * @author baojiang
 * @version ��Ծ��Ϸ: alg.A31_CanJump.java, v 0.1 2022��10��24�� ����4:20 baojiang Exp $
 */
public class A31_CanJump {

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 1, 0, 4 };
        System.out.println(canJump1(nums));
    }

    /**
     *  *
     *  * ����һ���Ǹ��������� nums�������λ������ĵ�һ���±꣬�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȣ��ж����Ƿ��ܹ��������һ���±ꡣ
     *  *
     *  * ʾ�� 1��
     *  *
     *  * ���룺nums = [2,3,1,1,4]
     *  * �����true
     *  * ���ͣ��������� 1 �������±� 0 �����±� 1, Ȼ���ٴ��±� 1 �� 3 ���������һ���±ꡣ
     *  * ʾ�� 2��
     *  *
     *  * ���룺nums = [3,2,1,0,4]
     *  * �����false
     *  * ���ͣ������������ܻᵽ���±�Ϊ 3 ��λ�á������±�������Ծ������ 0��������Զ�����ܵ������һ���±ꡣ
     *  *
     *  *
     *  *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247493680&idx=1&sn=5e5a9fac421ca026ec3487a2b8b4520c&chksm=9bd41638aca39f2ee76190ff7f19fe87316060798bd27d40554a415eee64613a7c5ad3e4f55c&scene=178&cur_album_id=2165170016067944448#rd
     *  *
     *
     *
     * ���������Զ����ʵ���ǿ��Ƿ��ܹ�Խ�����һ��
     * @param nums
     * @return
     */
    public static boolean canJump1(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // ̰���㷨,���ϵļ�����Զ����, ��Ծ����=ָ��λ��i + ��ǰԪ��ֵ
            farthest = Math.max(farthest, i + nums[i]);
            // ����������0����ס��������,����0����i��ֵ׷����farthest
            if (farthest <= i) {
                return false;
            }

        }
        return farthest >= n - 1;

    }

    /**
     * ����һ���Ǹ��������� nums�������λ������ĵ�һ��λ�ã������е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȣ�����ʹ�����ٵ���Ծ����������������һ��λ�ã����������ǿ��Ե�����������һ��λ�ã���
     *
     * ʾ�� 1:
     *
     * ���룺nums = [2,3,1,1,4]
     * �����2
     * ���ͣ��������һ��λ�õ���С��Ծ���� 2��
     *      ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
     *
     *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247493675&idx=1&sn=c3c1b01b40b64ad63d473666c263d280&chksm=9bd41623aca39f359a3a4b87139b539dc1c6157c1291300ec7756b1ff95f1edad27e6c12e557&scene=178&cur_album_id=2165170016067944448#rd
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}