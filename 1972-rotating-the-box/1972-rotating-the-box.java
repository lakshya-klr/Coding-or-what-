class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
    int m =box.length;
    int n= box[0].length;
    char[][] ans= new char[n][m];
    for(int i =0;i<m;i++){
        char[] row= applygravity(box[i]);
        for(int j=0;j<n;j++){
            ans[j][m-1-i]=row[j];
        }
    }
return ans;
    }
    private char[] applygravity(char[] row){
        int stones=0;
        int cells=0;
        for(int i=0;i<row.length;i++){
            if(row[i]=='*'){
                int j =i-1;
                while(cells-->0){
                    if(stones>0){
                        stones-=1;
                        row[j]='#';
                    }
                    else{
                        row[j]='.';
                    }
                    j-=1;

                }

            }
            else if(row[i]=='#'){
                stones+=1;
            }
            cells+=1;
        }
        int j =row.length-1;
         while(cells-->0){
                    if(stones>0){
                        stones-=1;
                        row[j]='#';
                    }
                    else{
                        row[j]='.';
                    }
                    j-=1;
                    
                    
                }
                return row;
    }
}