class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> fmap = new TreeMap<>();
        for(int h: hand)
        {
            fmap.put(h, fmap.getOrDefault(h,0)+1);
        }

        while(!fmap.isEmpty())
        {
            int first = fmap.firstKey();
            for(int i=0; i< groupSize; i++)
            {
                int curr = first+i;
                Integer freq = fmap.get(curr);
                if(freq == null) return false;
                if(freq > 1)
                {
                    fmap.put(curr, freq-1);
                }else
                {
                    fmap.remove(curr);
                }
            }
        }
        return true;
    }
}
