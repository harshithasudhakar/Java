class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        boolean del = false;

        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return palindrome(i+1, j, s) || palindrome(i, j-1, s);
            }
        }

        return true;
    }

    static boolean palindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
