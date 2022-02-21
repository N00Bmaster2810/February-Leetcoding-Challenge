class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int req = (nums.length+1)/2;
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue()>=req)return e.getKey();
        }
        return -1;
    }
}