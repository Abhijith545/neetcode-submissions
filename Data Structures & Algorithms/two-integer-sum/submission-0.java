class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> toSum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int req = target - nums[i];
            if (toSum.containsKey(req))
                return new int[] { toSum.get(req), i };
            toSum.put(nums[i], i);
        }
        return null;
    }
}
