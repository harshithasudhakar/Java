class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxL = 0; // max substring length
        int maxC = 0; // max freq in map

        Map<Character, Integer> map = new HashMap<>();

        while(r<n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);

            maxC = map.get(s.charAt(r))>maxC ? map.get(s.charAt(r)) : maxC;

            if((r-l+1) - maxC > k){ // r-l+1 gives us the current window size
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }

            maxL = Math.max(maxL, r-l+1);
            r++;

        }

        return maxL;
    }
}
