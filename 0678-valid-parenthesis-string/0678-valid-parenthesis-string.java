class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> extraopenbracket= new Stack<>();
        Stack<Integer> aestrick = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch =='(') extraopenbracket.push(i);
            else if(ch=='*') aestrick.push(i);
            else{
                if(!extraopenbracket.isEmpty()){
                    extraopenbracket.pop();
                }
                else if(!aestrick.isEmpty()){
                    aestrick.pop();
                }
                else return false;
            }
        }

        while(!extraopenbracket.isEmpty()){
            if(aestrick.isEmpty()){
                return false;
            }
            int openindex=extraopenbracket.pop();
            int closeindex=aestrick.pop();
            if(openindex>closeindex){
                return false;
            }
        }
        return extraopenbracket.isEmpty();
    }
}