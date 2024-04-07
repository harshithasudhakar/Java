class DefanglingIPaddressSolution {
    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }
    public static void main(String[] args){
        String address = new String();
        defangIPaddr(address);
    }
}
