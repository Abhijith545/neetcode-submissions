class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            groups.computeIfAbsent(str, key -> new ArrayList<>()).add(strs[i]);
        }

        return new ArrayList<>(groups.values());
    }
}
