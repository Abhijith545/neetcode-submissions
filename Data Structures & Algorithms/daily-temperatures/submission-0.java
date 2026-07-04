class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> next = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!next.isEmpty() && temperatures[i] >= temperatures[next.peek()]) next.pop();
            result[i] = next.isEmpty() ? 0 : next.peek() - i;
            next.push(i);
        }
        return result;
    }
}
