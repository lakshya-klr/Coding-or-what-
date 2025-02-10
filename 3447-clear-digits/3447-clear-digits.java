class Solution {
    public String clearDigits(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
           
                stk.push(s.charAt(i));
            
            if(stk.peek()=='0'||stk.peek()=='1'||stk.peek()=='2'||stk.peek()=='3'||stk.peek()=='4'||stk.peek()=='5'||stk.peek()=='6'||stk.peek()=='7'||stk.peek()=='8'||stk.peek()=='9'){

                    stk.pop();
                    stk.pop();
                
            }
           
        }
        if(stk.size()==0) return "";
        StringBuilder str = new StringBuilder();
        
        while(!stk.isEmpty()){
        
            str.append(stk.peek());
            stk.pop();
        }
        return str.reverse().toString();
    }
}