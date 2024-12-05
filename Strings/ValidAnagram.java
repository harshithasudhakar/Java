import java.util.Scanner;

class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (int i = 0; i < t.length(); i++) {
            char charT = t.charAt(i);
            if (map.containsKey(charT) && map.get(charT) > 0) {
                map.put(charT, map.get(charT) - 1);
            } else {
                return false;  // If the character doesn't match or has excess frequency
            }
        }

        // If all frequencies are zero, then it's an anagram
        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter String 1: ");
        String s = input.nextLine();
        System.out.println("Enter String 2: ");
        String t = input.nextLine();
        isAnagram(s, t);
    }
}
