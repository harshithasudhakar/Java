class MaxNoOfWordsInString {
    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for(int i = 0; i < sentences.length; i++) {
            int count = noOfWords(sentences[i]);
            if(count > max) {
                max = count;
            }
        }
        return max;
    }
    
    public static int noOfWords(String sentence) {
        String[] words = sentence.split(" ");
        return words.length;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] sentences = new String[n];
        for(int i = 0; i<n; i++){
            sentences[i] = input.nextLine();
        }
        mostWordsFound(sentences);
    }
}
