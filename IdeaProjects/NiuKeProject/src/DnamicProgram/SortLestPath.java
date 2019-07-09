package DnamicProgram;
//极客数据结构：动态规划2的矩阵路径题
public class SortLestPath {
    int[][] weight={{1,3,5,9}, {2,1,3,4},{5,2,6,7},{6,8,4,3}};
    int[][] value =new int[4][4];
    int n =4;
    private int[][] matrix =
            {{1,3,5,9}, {2,1,3,4},{5,2,6,7},{6,8,4,3}};
    private int[][] mem = new int[4][4];
    public int minDist(int i, int j) { // 文中标准接法，调用 minDist(n-1, n-1);
            if (i == 0 && j == 0) return matrix[0][0];
            if (mem[i][j] > 0) return mem[i][j];
            int minLeft = Integer.MAX_VALUE;
            if (j-1 >= 0) {
            minLeft = minDist(i, j-1);
            }
            int minUp = Integer.MAX_VALUE;
            if (i-1 >= 0) {
            minUp = minDist(i-1, j);
            }
    
            int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
            mem[i][j] = currMinDist;
            return currMinDist;
    }

    public int sortLestPath(int i,int j){//我的多了初始化第一行和第一列，然后文中没有替换次优的步骤
            int n =weight.length;
            if(i==0||j==0){
                return value[i][j];
            }
            int v  = weight[i][j] + Math.min(sortLestPath(i-1,j),sortLestPath(i,j-1));
            if(value[i][j]>v){//这个条件其实没有用到
                value[i][j] = v;
            }
            return  v;
    }
    public void init(){

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                value[i][j] = Integer.MAX_VALUE;
            }
        }
        value[0][0] = 1;
        for(int j =1;j<n;j++){ //初始化行
            value[0][j] = value[0][j-1]+weight[0][j];
        }
        for(int i = 1;i<n;i++){//初始化列
            value[i][0] = value[i-1][0]+weight[i][0];
        }

    }
    public static void main(String[] args){
        SortLestPath Slp = new SortLestPath();
        Slp.init();
        System.out.println(Slp.sortLestPath(3,3));
        System.out.println(Slp.minDist(3,3));
    }

}
