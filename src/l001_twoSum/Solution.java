package l001_twoSum;

import java.util.Arrays;

public class Solution {

	/**
	 * 辅助类
	 */
	private static class Node implements Comparable<Node> {
		int val; // 值
		int idx; // 值对应的数组下标


		public Node(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}

		// 比较方法
		@Override
		public int compareTo(Node o) {
			if (o == null) {
				return -1;
			}
			return this.val - o.val;
		}
	}

	/**
	 * 001-Two Sum（求两个数的和）
	 * 
	 * @param nums
	 *            输入数组
	 * @param target
	 *            两个数相加的和
	 * @return 两个数对应的下标
	 */
	public int[] twoSum(int[] nums, int target) {
		// 用于保存返回结果
		int[] result = { 0, 0 };

		
		// 创建辅助数组
		Node[] tmp = new Node[nums.length];
		for (int i = 0; i < nums.length; i++) {
			tmp[i] = new Node(nums[i], i);
		}

		// 对辅助数组进行排序
		Arrays.sort(tmp);

		// 记录辅助数组中左边一个值的下标
		int lo = 0;
		// 记录辅助数组中右边一个值的下标
		int hi = nums.length - 1;

		// 从两边向中间靠陇进行求解
		while (lo < hi) {
			// 如果找到结果就设置返回结果，并且退出循环
			if (tmp[lo].val + tmp[hi].val == target) {

				if (tmp[lo].idx > tmp[hi].idx) {
					result[0] = tmp[hi].idx + 1;
					result[1] = tmp[lo].idx + 1;
				} else {
					result[0] = tmp[lo].idx + 1;
					result[1] = tmp[hi].idx + 1;
				}
				break;
			}
			// 如果大于目标值，右边的下标向左移动
			else if (tmp[lo].val + tmp[hi].val > target) {
				hi--;
			}
			// 如果小于目标值，左边的下标向右移动
			else {
				lo++;
			}
		}
		return result;
	}
}
