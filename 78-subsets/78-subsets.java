class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int limit = (int)Math.pow(2,nums.length);
        for(int i=0;i<limit;i++){
            List<Integer> temp = new ArrayList<>();
            String binary = Integer.toBinaryString(i);
            for(int j=binary.length()-1, k=0;j>=0;j--, k++){
                if(binary.charAt(j)=='1')temp.add(nums[k]);
            }
            result.add(temp);
        }
        return result;
    }
}