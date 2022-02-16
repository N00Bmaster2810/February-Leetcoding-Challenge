class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i=1;i<n;i++){
            pre[i] = nums[i] + pre[i-1];
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        hm.put(0, 1);
        for(int i=0;i<n;i++){
            if(hm.containsKey(pre[i]-k))count+=hm.get(pre[i]-k);
            hm.put(pre[i], hm.getOrDefault(pre[i], 0)+1);
        }
        return count;
    }
}