class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        int[] freqs = new int[26];
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(freqs, 0);
            char[] str = strs[i].toCharArray();
            for (int j = 0; j < str.length; j++) {
                freqs[str[j] - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sb.append('#').append(freqs[j]);
            }
            String finalStr = sb.toString();
            groups.computeIfAbsent(finalStr, key -> new ArrayList<>()).add(strs[i]);
        }

        return new ArrayList<>(groups.values());
    }
}
