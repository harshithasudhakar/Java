class NoOfOneBits {
    public int hammingWeight(int n) {
        int setBits = 0;
        while(n!=1){
            if(n%2 == 1){
                setBits += 1;
            }
            n = n/2;
        }

        return setBits+1;
    }
}
