class LargestGoodInteger {
    public String largestGI(String num) {
        
        String str = "";
        for(int i = 0; i<=num.length()-3;i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i)==num.charAt(i+2) && str.compareTo(num.substring(i,i+3))<0){
                str=num.substring(i,i+3);
            }
        }
        
        return str;
    }
}
