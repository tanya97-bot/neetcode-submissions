class Solution {
    public boolean checkValidString(String s) {
        ArrayDeque<Integer> openStack  = new ArrayDeque<>();
        ArrayDeque<Integer> starStack = new ArrayDeque<>();

        for(int i=0; i< s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                openStack.push(i);
            }
            else if(s.charAt(i)==')')
            {
                if(!openStack.isEmpty())
                {
                    openStack.pop();
                }else if(!starStack.isEmpty())
                {
                    starStack.pop();
                }
                else
                {
                    return false;
                }
            }
            else
            {
                starStack.push(i);
            }
        }

        while(!openStack.isEmpty() && !starStack.isEmpty())
        {
            if(openStack.poll() > starStack.poll())
            {
                return false;
            }
        }
        return openStack.isEmpty();
    }
}
