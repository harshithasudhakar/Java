import java.util.Scanner;

class LongestCommonPrefix{
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        String word;
        for (int i = 0; i < strs[0].length(); i++) {
            char letter = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != letter) {
                    return prefix.toString();
                }
            }
            prefix.append(letter);
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strs = new String[3];
        for (int i = 0; i < 3; i++) {
            strs[i] = input.nextLine();
        }
        System.out.println(longestCommonPrefix(strs));
    }
}
