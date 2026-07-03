class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, maxLen = 0;
        char[] str = s.toCharArray();
        Set<Character> chars = new HashSet<>();
        while (start <= end && end < str.length) {
            if (!chars.contains(str[end])) {
                chars.add(str[end]);
                end++;
            } else {
                maxLen = Math.max(maxLen, end - start);
                while (chars.contains(str[end])) {
                    chars.remove(str[start]);
                    start++;
                }
            }
        }
        maxLen = Math.max(maxLen, end - start);
        return maxLen;
    }
}
