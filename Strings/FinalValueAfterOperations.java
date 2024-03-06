class FinalValueAfterOperations {
    public static int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for(int i = 0; i<operations.length; i++){
            if(operations[i].equals("--X") || operations[i].equals("X--")){
                X = X - 1;
            }
            else if(operations[i].equals("++X") || operations[i].equals("X++")){
                X = X + 1;
            }
        }
        return X;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] operations = new String[n];
        for(int i = 0; i<n; i++){
            operations[i] = input.nextLine();
        }
        finalValueAfterOperations(operations);
        System.out.println(finalValueAfterOperations(operations));
    }
}
