class Solution {
    public List<String> stringMatching(String[] words) {
       List<String> ans=new ArrayList();
       HashSet<String> set = new HashSet<>();
        for(int i =0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(words[i].length()>words[j].length()){
                    if(words[i].contains(words[j])){
                        set.add(words[j]);
                    
                    }
                }
            }
        }
        for(String str : set){
            ans.add(str);
        }
        return ans;
    }
   
    }
