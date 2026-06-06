class Solution {
    public String foreignDictionary(String[] words) {
      HashMap<Character, HashSet<Character>> map = new HashMap<>();
      HashMap<Character, Integer> idgMap = new HashMap<>();
for(String word : words)
{
    for(char c : word.toCharArray())
    {
        map.putIfAbsent(c, new HashSet<>());
        idgMap.putIfAbsent(c, 0);
    }
}
      for(int i=0; i< words.length -1; i++)
      {
        char[] one = words[i].toCharArray();
        char[]two = words[i+1].toCharArray();

        for(int j =0; j<Math.min(one.length, two.length); j++)
        {
            if(one.length > two.length &&
   words[i].startsWith(words[i+1]))
{
    return "";
}
            if(one[j] != two[j])
            {
                if(!map.get(one[j]).contains(two[j]))
                {
                    map.get(one[j]).add(two[j]);
                    idgMap.put(two[j], idgMap.getOrDefault(two[j],0)+1);
                    if(map.get(two[j]).contains(one[j])) return "";
                }
                break;
            }
        }
      }
      Queue<Character> q = new LinkedList<>();
      for(char c: map.keySet())
      {
        if(idgMap.get(c) == 0)
{
    q.offer(c);
}
      }
      StringBuilder res = new StringBuilder();
      while(!q.isEmpty())
      {
        char ch = q.poll();
        res.append(ch);
        if(!map.containsKey(ch)) continue;
        for(char next: map.get(ch))
        {
            if(!idgMap.containsKey(next)) continue;
            int idg = idgMap.get(next);
            if(idg == 1)
            {
                idgMap.remove(next);
                q.offer(next);
            }else
            {
                idgMap.put(next, idg-1);
            }
        }
      }
      return res.length()==map.size()?res.toString():"";
    }
}
