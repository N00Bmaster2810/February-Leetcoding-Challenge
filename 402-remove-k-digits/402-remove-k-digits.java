class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k >= len) return "0";
        Stack<Character> mono = new Stack<>();
        for(int i=0;i<len;i++){
            while(k>0&&mono.size()>0&&mono.peek()>num.charAt(i)){
                mono.pop();
                k--;
            }
            mono.push(num.charAt(i));
        }
        while(k > 0){
            mono.pop();
            k--;
        }
        StringBuffer ans = new StringBuffer();
        while(mono.size()>0){
            ans.append(mono.pop());
        }
        ans.reverse();
        
        while(ans.length()>1 && ans.charAt(0)=='0')
            ans.deleteCharAt(0);
        return ans.toString();
    }
}