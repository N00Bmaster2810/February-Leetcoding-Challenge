class Solution {
    public int compareVersion(String version1, String version2) {
        String[] one = version1.split("\\.");
        String[] two = version2.split("\\.");
        int[] v1 = new int[one.length];
        int[] v2 = new int[two.length];
        for (int i = 0; i < one.length; i++) {
            v1[i] = Integer.parseInt(one[i]);
        }
        for (int i = 0; i < two.length; i++) {
            v2[i] = Integer.parseInt(two[i]);
        }
        for (int a : v1) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (int b : v2) {
            System.out.print(b + " ");
        }
        System.out.println();
        int i = 0, j = 0;
        while (i < v1.length && j < v2.length) {
            if (v1[i] > v2[j])
                return 1;
            else if (v1[i] < v2[j])
                return -1;
            i++;
            j++;
        }
        while (i < v1.length) {
            if (v1[i] > 0)
                return 1;
            i++;
        }
        while (j < v2.length) {
            if (v2[j] > 0)
                return -1;
            j++;
        }
        return 0;
    }
}