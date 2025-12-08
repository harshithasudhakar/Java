class MergeStringsAlternatively {
    public String mergeAlternately(String word1, String word2) {
        int s1 = word1.length();
        int s2 = word2.length();

        StringBuilder sb = new StringBuilder();

        if(s1<s2){
            for(int i = 0; i<s1; i++){
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }

            sb.append(word2.substring(s1, s2));
        }
        else if(s2<s1){
            for(int i = 0; i<s2; i++){
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }

            sb.append(word1.substring(s2, s1));
        }
        else{
            for(int i = 0; i<s1; i++){
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
        }   

        return sb.toString();     
    }
}
