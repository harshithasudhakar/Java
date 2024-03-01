// Selection Sort
class SortSentence {
    public String sort(String s) {
        String[] words = s.split(" ");
        for(int i = 0; i< words.length-1;i++){
            for(int j = i; j< words.length; j++){
                if(getIndex(words[j])<getIndex(words[i])){
                    swap(words, i, j);
                }
            }
        }
        StringBuilder originalString = new StringBuilder();
        for(String word : words){
            originalString.append(word.substring(0, word.length() - 1)).append(" ");
        }
        return originalString.toString().trim();
    }
    
    public static int getIndex(String word){
        return Character.getNumericValue(word.charAt(word.length()-1));
    }

    public static void swap(String[] words, int index1, int index2){
        String temp = words[index1];
        words[index1] = words[index2];
        words[index2] = temp;
    }
    
    public static void main(String[] args){
        SortSentence solution = new SortSentence();
        String s = new String();
        solution.sortSentence(s);
    }
}
