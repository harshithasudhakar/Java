class LongestSubstrWithoutCharRepetition { //sliding window + 2-pointer approach
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int l = 0;
        int r = 0;
        int maxL = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(r<n){
            if(map.containsKey(s.charAt(r)) && (map.get(s.charAt(r))>=l && map.get(s.charAt(r))<r)){
                l = map.get(s.charAt(r)) + 1;
            }
            map.put(s.charAt(r), r);
            maxL = Math.max(maxL, r-l+1);
            r++;
        }

        return maxL;
    }
}
