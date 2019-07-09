package DnamicProgram;

public class CoinSolve {
    boolean[][] states = new boolean[9][10];//横排代表用的纸币个数，竖排代表现在的钱数
    public int coinSolve(){
        int result = 0;
        states[0][0] = true;
        for(int i =1;i<9;i++){
            for(int j = 0;j<9;j++){
                if(states[i-1][j]==true){
                    if((j+1)<=9) states[i][j+1] =true;
                    if((j+3)<=9) {
                        states[i][j+3] =true;
                        System.out.println(i+","+(j+3));
                    }
                    if((j+5)<=9) states[i][j+5] =true;
                }
            }
        }
        for(int i=0;i<9;i++){
            if(states[i][9]==true){
                result = i+1;
                break;
            }


        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(new CoinSolve().coinSolve());
    }
}
