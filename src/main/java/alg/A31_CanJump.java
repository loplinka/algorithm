package alg; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */

/**

 * @author baojiang
 * @version 跳跃游戏: alg.A31_CanJump.java, v 0.1 2022年10月24日 下午4:20 baojiang Exp $
 */
public class A31_CanJump {

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 1, 0, 4 };
        System.out.println(canJump1(nums));
    }

    /**
     *  *
     *  * 给定一个非负整数数组 nums，你最初位于数组的第一个下标，数组中的每个元素代表你在该位置可以跳跃的最大长度，判断你是否能够到达最后一个下标。
     *  *
     *  * 示例 1：
     *  *
     *  * 输入：nums = [2,3,1,1,4]
     *  * 输出：true
     *  * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     *  * 示例 2：
     *  *
     *  * 输入：nums = [3,2,1,0,4]
     *  * 输出：false
     *  * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0，所以永远不可能到达最后一个下标。
     *  *
     *  *
     *  *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247493680&idx=1&sn=5e5a9fac421ca026ec3487a2b8b4520c&chksm=9bd41638aca39f2ee76190ff7f19fe87316060798bd27d40554a415eee64613a7c5ad3e4f55c&scene=178&cur_album_id=2165170016067944448#rd
     *  *
     *
     *
     * 最多能跳多远？其实就是看是否能够越过最后一格
     * @param nums
     * @return
     */
    public static boolean canJump1(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // 贪心算法,不断的计算最远距离, 跳跃距离=指针位置i + 当前元素值
            farthest = Math.max(farthest, i + nums[i]);
            // 可能碰到了0，卡住跳不动了,碰到0就是i的值追上了farthest
            if (farthest <= i) {
                return false;
            }

        }
        return farthest >= n - 1;

    }

    /**
     * 给你一个非负整数数组 nums，你最初位于数组的第一个位置，数组中的每个元素代表你在该位置可以跳跃的最大长度，请你使用最少的跳跃次数到达数组的最后一个位置（假设你总是可以到达数组的最后一个位置）。
     *
     * 示例 1:
     *
     * 输入：nums = [2,3,1,1,4]
     * 输出：2
     * 解释：跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
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