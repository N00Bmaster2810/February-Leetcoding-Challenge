class Solution {
    int power(int a, int b) {
        if (b == 0)
            return 1;
        if (b % 2 == 1)
            return (a * power((a * a), b / 2));
        return power((a * a), b / 2);
    }

    public int titleToNumber(String columnTitle) {
        int res = 0, n = columnTitle.length();
        for (int i = 0; i < n; i++) {
            res += (columnTitle.charAt(i) - 'A' + 1)*power(26, n-1-i);
        }
        return res;
    }
}