class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0)nums[i] = -1;
        }
        HashMap<Integer, List<Integer>> prefixMap = new HashMap<>();
        int sum = 0;
        List<Integer> index = prefixMap.getOrDefault(sum, new ArrayList<>());
        index.add(-1);
        prefixMap.put(sum, index);
        for(int i=0;i<n;i++){
            sum += nums[i];
            index = prefixMap.getOrDefault(sum, new ArrayList<>());
            index.add(i);
            prefixMap.put(sum, index);
        }
        int max = 0;
        for(Map.Entry<Integer, List<Integer>> entry: prefixMap.entrySet()){
            if(entry.getValue().size()>1){
                max = Math.max(max, entry.getValue().get(entry.getValue().size()-1) - entry.getValue().get(0));
            }
        }
        return max;
    }
}