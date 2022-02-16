class Solution {
   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList), vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        for (int len = 1; !q.isEmpty(); len++) {
            for (int i = q.size(); i > 0; i--) {
                String child = q.poll();
                if (child.equals(endWord)) return len;

                for (int j = 0; j < child.length(); j++) {
                    char[] ch = child.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == child.charAt(j)) continue;
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (dict.contains(nb) && vis.add(nb)) q.offer(nb);
                    }
                }
            }
        }
        return 0;
	}
}