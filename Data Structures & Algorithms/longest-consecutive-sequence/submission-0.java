class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> visit = new HashSet<>();
        int max = 1;
        for (int num: nums) visit.add(num);
        for (Integer num : visit) {
            if (!visit.contains(num - 1)) {
                int curr = num;
                int count = 1;
                while (visit.contains(curr + 1)) {
                    count++;
                    curr++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
