class RemoveDigitToMaximizeResult {
    public String removeDigit(String number, char digit) {
        String result = "";
        for(int i = 0; i<number.length(); i++){
            if(number.charAt(i) == digit){
                String str = number.substring(0,i) + number.substring(i+1);

                if(str.compareTo(result) > 0){
                    result = str;
                }
            }
        }
        return result;
    }
}
