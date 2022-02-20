class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]));
        int n = intervals.length;
        int count = 1;
        int[] prev = intervals[0];
        for (int i = 1; i < n; i++) {
            if(intervals[i][0] >= prev[0] && intervals[i][1] <= prev[1]) {
                continue;
            } else {
                count++;
                prev = intervals[i];
            }
        }
        return count;
    }
}