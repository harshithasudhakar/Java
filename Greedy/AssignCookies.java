class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int j = 0;
        int i = 0;

        while(j<s.length && i<g.length){
            if(s[j]>=g[i]){
                i++;
                j++;
                count++;
            }
            else{
                j++;
            }
        }
        
        return count;
    }
}
