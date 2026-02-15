class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new TreeMap<>();
        Map<Character, Character> map2 = new TreeMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i<s.length(); i++){
            if(!map1.containsKey(s.charAt(i))){
                map1.put(s.charAt(i), t.charAt(i));
            }
            if(map1.get(s.charAt(i)) != t.charAt(i)){
                return false;
            }
            if(!map2.containsKey(t.charAt(i))){
                map2.put(t.charAt(i), s.charAt(i));
            }
            if(map2.get(t.charAt(i)) != s.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
