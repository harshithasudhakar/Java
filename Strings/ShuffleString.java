import java.util.Scanner;
class ShuffleString {
    public static String restoreString(String s, int[] indices) {
        StringBuilder shuffledString = new StringBuilder();
        int charIndex = 0;
        for(int i = 0; i<indices.length; i++){
            charIndex = indices[i];
            shuffledString.append(s.charAt(charIndex));
        }
        return shuffledString.toString();
    }
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] indices = new int[n];
        for(int i = 0; i<n; i++){
            indices[i] = input.nextInt();
        }
        String s = input.next();
        restoreString(s, indices);
    }
}
