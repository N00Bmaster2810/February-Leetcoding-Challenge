class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] hash = new int[26];
        
        int m = p.length();
        int n = s.length();
        
        if(m>n)return new ArrayList<>();
        
        for(int i=0;i<m;i++){
            hash[p.charAt(i)-'a']++;
        }
        
        int[] vis = new int[26];
        
        for(int i=0;i<m;i++){
            vis[s.charAt(i)-'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if(check(vis, hash))res.add(0);
        
        for(int i=1,j=m;j<n;i++,j++){
            vis[s.charAt(i-1)-'a']--;
            vis[s.charAt(j)-'a']++;
            if(check(vis, hash))res.add(i);
        }
        return res;
        
    }
    public boolean check(int[] vis, int[] hash){
        for(int i=0;i<26;i++)if(vis[i]!=hash[i])return false;
        return true;
    }
}