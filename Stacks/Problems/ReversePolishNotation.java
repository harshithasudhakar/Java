class ReversePolishNotation { // Postfix
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        
        for(String i : tokens){
            if(i.equals("+")){
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a+b);
            }
            else if(i.equals("-")){
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a-b);
            }
            else if(i.equals("*")){
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a*b);
            }
            else if(i.equals("/")){
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a/b);
            }
            else{
                stk.push(Integer.parseInt(i));
            }
        }
        return stk.pop();
    }
}
