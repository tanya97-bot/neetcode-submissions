class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs)
        {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while( i < str.length())
        {
            int si = i;
            while(str.charAt(i) != '#')
            {
                i++;
            }
            int len = Integer.parseInt(str.substring(si, i));
            i++;
            String cs = str.substring(i, i+len);
            res.add(cs);
            i+=len;
        }
        return res;
    }
}
