package DnamicProgram;
/*动态规划3思考题 求一组数据的顺序度
我用了状态转移法的递归
状态转移方程：f(i)=1+max(f(i+1),f(i+2)....f(n))
f(i)表示从当前位置出发的所有符合顺序排列的长度
* */
public class AsecSec {
    private int[] sec = {9,2,3,5,1,7};
    public  int n =sec.length;
    public int f(int index){
        int max=0;
        for(int j = index+1;j<n;j++){
            if(sec[j]>sec[index]){
                int result = f(j);
                if(max<result)
                    max = result;
            }
        }
        return max+1;
    }
     public static void main(String[] args){
        AsecSec As =new AsecSec();
        int maxAS = 0;
        for(int i = 0;i<As.n;i++){
            int result = As.f(i);
            if(maxAS<result) {
                maxAS = result;
            }
        }
        System.out.println(maxAS);
     }
}
/*网友的解法，是从后往前确定顺序
还有状态转移法，这个方法只用了一维数组，没有懂他的解法
    public int recursionCount4(int[] arrays, int index) {

        if (index == 0) {
            return 1;
        }
        int max = 0;
        //此问题的解，递归的核心就是在之前的序列中找到最大递增子序列加1
        //所以需要遍历此此之前的全部数据项
        for (int i = 0; i < index; i++) {
            //递归求解每项的最递增序列
            int value = recursionCount4(arrays, i);
            if (arrays[i] < arrays[index]) {
                if (value > max) {
                    max = value;
                }
            }
        }

        return max + 1;
    }



    public void countDynamic(int[] arrays) {
        int length = arrays.length;

        int[] status = new int[length];

        status[0] = 1;

        int commMax = 0;

        for (int i = 1; i < length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arrays[j] < arrays[i]) {
                    if (status[j] > max) {
                        max = status[j];
                    }
                }
            }
            status[i] = max + 1;

            if (status[i] > commMax) {
                commMax = status[i];
            }
        }

        System.out.println("最大递增序列为 ：" + commMax);
        int maxComp = commMax;
        System.out.println("递增:" + Arrays.toString(status));

        for (int i = length - 1; i >= 0; i--) {
            if (status[i] == maxComp) {
                System.out.print("-->" + arrays[i]);
                maxComp = maxComp - 1;
            }
        }
    }*/