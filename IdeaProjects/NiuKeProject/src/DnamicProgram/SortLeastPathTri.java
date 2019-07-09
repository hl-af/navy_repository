package DnamicProgram;
//极客数据结构：动态规划1杨辉三角最短路径问题

public class SortLeastPathTri {
    private int[][] matrix = {{5},{7,8},{2,3,4},{4,9,6,1},{2,7,9,4,5}};
    private int[][] states =new int[5][5];
    public int sortLeastPathTri(){
        //初始化边缘，（i,0）(i,i)
        //状态转移表法
        states[0][0] = matrix[0][0];
        for(int i = 1;i<5;i++){
            states[i][0] = matrix[i][0] + states[i-1][0];
        }
        for(int i = 1;i<5;i++){
            states[i][i] = matrix[i][i] + states[i-1][i-1];
        }
        for(int i = 1;i<5;i++){
            for(int j = 1;j<i;j++){
                states[i][j] = matrix[i][j] + Math.min(states[i-1][j],states[i-1][j-1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0;j<5;j++){
            if(states[4][j]<min){
                min = states[4][j];
            }
        }
        return min;
    }
    public int f(int i ,int j){
        //递归实现，但是有三种情况
        if(i==0&&j==0){
            return matrix[0][0];
        }
        if(j==0){
            int result = f(i-1,0)+matrix[i][0];
            return  result;
        }else if(i==j){
            int result = f(i-1,j-1)+matrix[i][j];
            return result;
        }else{
            int result = matrix[i][j] + Math.min(f(i-1,j),f(i-1,j-1));
            return result;
        }
    }
    public static void main(String[] args){
        System.out.println(new SortLeastPathTri().sortLeastPathTri());
        SortLeastPathTri Slpt = new SortLeastPathTri();
        int minValue = Integer.MAX_VALUE;
        for(int i = 0;i<5;i++){
            int result = Slpt.f(4,i);
            if(result<minValue){
                minValue = result;
            }
        }
        System.out.println(minValue);
    }
}
