class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        solve(candidates, target, l, res, 0);
        return res;
    }

    private void solve(int[] candidates, int target, List<Integer> l, List<List<Integer>> res, int start) {
        if(target<0)return;
        if(target==0){
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            l.add(candidates[i]);
            solve(candidates, target - candidates[i], l, res, i);
            l.remove(l.size()-1);
        }
    }
}