class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2001];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i] + 1000]++;
        }
        List<Integer>[] buckets = new List[10001];
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                if (buckets[freq[i]] == null) buckets[freq[i]] = new ArrayList<>();
                buckets[freq[i]].add(i - 1000);
            }
        }
        int[] result = new int[k];
        List<Integer> temp = null;
        int i = 10000;
        while (i >= 0  && k > 0) {
            if (buckets[i] != null) {
                temp = buckets[i];
                int j = 0;
                while (j < temp.size() && k > 0) {
                    result[--k] = temp.get(j);
                    j++;
                }
            }
            i--;
        }
        return result;
    }
}
