class Solution {
    public String foreignDictionary(String[] words) {
      StringBuilder res = new StringBuilder();
      HashSet<Character> contains = new HashSet<>();
HashSet<Integer>[] sets = (HashSet<Integer>[]) new HashSet[26];
for(int i=0; i< 26; i++)
        {
            sets[i] = new HashSet<Integer>();
        }
        int[] indegree = new int[26];
        for(String word : words)
{
    for(char c : word.toCharArray())
    {
        contains.add(c);
    }
}
        for(int i=0; i< words.length - 1; i++)
        {
            String s1 = words[i];
            String s2 = words[i+1];
              if(s1.length() > s2.length() && s1.startsWith(s2)) {
        return "";
    }
            int min = Math.min(s1.length(), s2.length());
            for(int j=0; j< min; j++)
            {
                if(s1.charAt(j) == s2.charAt(j)) continue;
                if(!sets[s1.charAt(j)-'a'].contains(s2.charAt(j)-'a')) {
    sets[s1.charAt(j)-'a'].add(s2.charAt(j)-'a');
    indegree[s2.charAt(j)-'a']++;
    }
                break;
            }
            
        }

       
        
        Queue<Integer> bfs = new LinkedList<>();
        for(int i=0; i< indegree.length; i++)
        {
            if(indegree[i] == 0) bfs.offer(i);
        }
        
        while(!bfs.isEmpty())
        {
            int curr = bfs.poll();
            char currC = (char)(curr + 'a');
            if(contains.contains(currC)) res.append(currC);
            HashSet<Integer> next = sets[curr];
            
            for(Integer n : next)
            {
                indegree[n]--;
                if(indegree[n] == 0)
                {
                    bfs.offer(n);
                }
            }
        }
        
        for(int x: indegree)
        {
            if( x> 0) return "";
        }
        
        return res.toString();
    }
}
