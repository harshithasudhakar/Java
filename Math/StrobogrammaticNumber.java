import java.util.*;

class StrobogrammaticNumber{

    static ArrayList<String> strobonumGeneration(int n, int length){
        if(n == 0){
            return new ArrayList<String>(Arrays.asList(""));
        }
        if(n == 1){
            return new ArrayList<String>(Arrays.asList("1", "0", "8"));
        }

        ArrayList<String> middles = strobonumGeneration(n-2, length);
        ArrayList<String> result = new ArrayList<>();

        for(String middle: middles){
            if(n != length){
                result.add("0" + middle + "0");
            }
            result.add("1" + middle + "1");
            result.add("8" + middle + "8");
            result.add("6" + middle + "9");
            result.add("9" + middle + "6");
        }
        return result;
    }

    static boolean isStrobo(String str){

        int n = str.length();
        Map<Character, Character> stroboMap = new HashMap<>();
        stroboMap.put('0', '0');
        stroboMap.put('1', '1');
        stroboMap.put('8', '8');
        stroboMap.put('6', '9');
        stroboMap.put('9', '6');
        
        for(int i = 0, j = n-1; i <= j; i++, j--){
            char left =  str.charAt(i);
            char right =  str.charAt(j);
            char mapping = stroboMap.getOrDefault(left, '-');
            if (mapping == '-' || mapping != right) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of number: ");
        int n = input.nextInt();
        int length = n;
        // Consume the leftover newline character
        input.nextLine();
        System.out.println("The numbers are: ");
        System.out.println(strobonumGeneration(n, length));
        System.out.println("Enter strobogrammatic number: ");
        String str = input.nextLine();
        System.out.println(isStrobo(str));
        input.close();
    }
}
