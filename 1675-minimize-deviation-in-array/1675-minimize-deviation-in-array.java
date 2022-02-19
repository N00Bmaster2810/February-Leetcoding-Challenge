class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int min = Integer.MAX_VALUE, minDev = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n % 2 == 1)
                n *= 2;
            queue.add(-n);
            min = Math.min(min, n);
        }
        while (true) {
            int n = -queue.poll();
            minDev = Math.min(minDev, n - min);
            if (n % 2 == 1)
                break;
            min = Math.min(min, n / 2);
            queue.add(-n / 2);
        }
        return minDev;
    }
}