class Solution {
    public boolean checkValidCuts(int n, int[][] rect) {
        int s = rect.length;

        int [][] vert = rect.clone();
        int [][] horz = rect.clone();

        Arrays.sort(vert, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int hz = 0, vr = 0,h=0;
        int mh = 0;
        for(int i =0;i<s-1;i++){
            int b = vert[i][1];
            h = Math.max(h,vert[i][3]);
            
            if(vert[i+1][1]>=h){
                hz++;
            }

            if(hz>=2) break;

        }

        System.out.println(hz);


        Arrays.sort(horz, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        h = 0;

        for(int i =0;i<s-1;i++){
            int b = horz[i][0];
            h = Math.max(h,horz[i][2]);
            
            if(horz[i+1][0]>=h){
                vr++;
            }

            if(vr>=2) break;

        }
        System.out.println(hz +" "+vr);
        return hz>=2 || vr>=2;
    }
}