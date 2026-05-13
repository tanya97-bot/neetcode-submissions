class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for(String s: strs)
        {
            result.append(s.length()).append("#").append(s);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < str.length())
        {
            int si = i;
            while(str.charAt(i) != '#')
            {
                i++;
            }
            int len = Integer.parseInt(str.substring(si, i));
            //skip #
            i++;
            list.add(str.substring(i, i+len));
            i+=len;
        }
        return list;
    }
}
