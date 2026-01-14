class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;

        if(digits[n-1] != 9){
            digits[n-1] += 1;
            return digits;
        }

        for(int i = n-1; i>=0; i--){
            if(digits[i] == 9 && i == n-1){
                carry = 1;
                digits[n-1] = 0;
            }
            else if(digits[i] == 9 && carry == 1){
                carry = 1;
                digits[i] = 0;
            }
            else{
                digits[i] += carry;
                carry = 0;
            }
        }

        if(carry == 1){
            int[] result = new int[n+1];
            result[0] = carry;
            for(int i = 1; i<result.length; i++){
                result[i] = digits[i-1];
            }

            return result;
        }

        return digits;
    }
}
