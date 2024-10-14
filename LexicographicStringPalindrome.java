import java.util.*;

class LexicographicStringPalindrome{

    static String lexiPal(TreeMap<Character, Integer> map){
        
        StringBuilder prefix = new StringBuilder();
        StringBuilder oddStr = new StringBuilder();
        int count = 0;
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            
            int frequency = entry.getValue();
            int prefixSize = frequency / 2;
            
            // Append the character 'prefixSize' times to the prefix
            for(int i = 0; i < prefixSize; i++){
                prefix.append(entry.getKey());
            }
            
            // Check for odd frequency outside the prefix loop
            if(frequency % 2 == 1){
                oddStr.append(entry.getKey());
                count++;
                
                // If more than one character has an odd frequency, palindrome isn't possible
                if(count > 1){
                    return "Can't make a palindrome";
                }
            }
        }
        
        // Create the suffix by reversing the prefix
        String suffix = new StringBuilder(prefix).reverse().toString();
        
        // Combine prefix, oddStr (if any), and suffix to form the palindrome
        return prefix.toString() + oddStr.toString() + suffix;
    }

    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = input.nextLine();
        char[] arrChar = str.toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();
        
        // Counting the frequency of each character
        for(char ch : arrChar){
            map.put(ch, map.getOrDefault(ch, 0) + 1); // Creating the TreeMap
        }
        
        System.out.println(lexiPal(map));

        input.close();
    }
}