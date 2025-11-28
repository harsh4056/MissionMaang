class DetectSquares {
    int[][]points;
    public DetectSquares() {
        points=new int[1001][1001];
    }

    public void add(int[] point) {
        int r=point[0];
        int c=point[1];
        points[r][c]++;
    }

    public int count(int[] point) {
        int mr=point[0];
        int mc=point[1];
        int count=0;
        for(int j=0;j<=1000;j++){
            if(j!=mc &&points[mr][j]>0){
                int len=Math.abs(j-mc);
                //upper square?
                int p1=1+points[mr][mc];
                int p2=mr-len>=0?points[mr-len][mc]:0;
                int p3=mr-len>=0?points[mr-len][j]:0;
                int p4=points[mr][j];

                count+=(p1*p2*p3*p4);

                //lower square?
                p1=1+points[mr][mc];
                p2=mr+len>=0?points[mr+len][mc]:0;
                p3=mr+len>=0?points[mr+len][j]:0;
                p4=points[mr][j];

                count+=(p1*p2*p3*p4);


            }
        }
        return count;

    }

    public static void main(String[] args) {
        DetectSquares ds = new DetectSquares();

        ds.add(new int[]{3, 10});
        ds.add(new int[]{11, 2});
        ds.add(new int[]{3, 2});

        System.out.println(ds.count(new int[]{11, 10})); // expected 1
        System.out.println(ds.count(new int[]{14, 8}));  // expected 0

        ds.add(new int[]{11, 2});

        System.out.println(ds.count(new int[]{11, 10})); // expected 2
    }



}
