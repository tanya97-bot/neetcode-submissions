class Solution {
    public List<String> letterCombinations(String digits) {
        List<Character>[] map = new List[10];
        map[2] = List.of('a','b','c');
        map[3] = List.of('d','e','f');
        map[4] = List.of('g','h','i');
        map[5] = List.of('j','k','l');
        map[6] = List.of('m','n','o');
        map[7] = List.of('p','q','r','s');
        map[8] = List.of('t','u','v');
        map[9] = List.of('w','x','y','z');
        List<String> result = new ArrayList<>();
        findPermutations("",0, digits, map, result);
        return result;
    }
    private void findPermutations(String curr,int i, String str,
     List<Character>[] map, List<String> res)
    {
        if(i == str.length())
        {
            if(curr.length()>0) res.add(curr);
            return;
        }
        for(char c: map[str.charAt(i)-'0'])
        {
            findPermutations(curr+c,i+1,str, map, res);
        }
    }
}
