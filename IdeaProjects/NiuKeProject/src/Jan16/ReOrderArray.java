package Jan16;

/**
 * git test
 */
public class ReOrderArray {

    public void f(int p,int q,int[] alpha){
        if(p==q){
            return;
        }
        int l = (p+q)/2;
        f(p,l,alpha);
        f(l+1,q,alpha);
        merge(p,q,alpha);
    }
    public void merge(int p,int q,int[] alpha){
        System.out.print("p="+p+" "+"q="+q+":");
        int l = (p+q)/2;
        int i = p;int j = l+1;
        int[] temp = new int[q-p+1];
        int k = 0;
        while(i<=l&&j<=q){
            if(alpha[i]%2!=0){
                temp[k++] = alpha[i++];
            }else if(alpha[j]%2!=0){
                temp[k++] = alpha[j++];
            }else{
                break;
            }
        }
        int start = i;int end = l;
        if(i<=l){
            start = i;end = l;
            for(int s=start;s<=end;s++){
                temp[k++] = alpha[s];
            }
        }
        if(j<=q){
            start = j;end = q;
            for(int s=start;s<=end;s++){
                temp[k++] = alpha[s];
            }
        }

        for(int s = p;s<=q;s++){
            System.out.print(temp[s-p]+" ");
            alpha[s] = temp[s-p];
        }
        System.out.println();
    }
 /*   private int[] merge(int p ,int q){
        int[] temp = new int[q-p+1];
        int l = (p+q)/2;
        int i = p;
        int j = l+1;
        int k = 0;
        while(true){
            if((alpha[i]%2!=0)&&(i!=l+1)){
                temp[k] = alpha[i];
                k++;i++;
            }
            if((alpha[j]%2!=0)&&(j!=q+1)){
                temp[k] = alpha[j];
                k++;j++;
            }

            if((i==l)||(j==q)){
                break;
            }
        }
        if(i<=l){
            temp[k] = alpha[i];
            i++;k++;
        }
        if(j<=l){
            temp[k] = alpha[j];
            j++;k++;
        }
        return temp;
    }*/
    public static void main(String[] args){
        //int[] alpha={6,1,4,3,2,7,5};
        int[] alpha={6,1,4,3,2,7};
        //int[] alpha={0};
        ReOrderArray ROA = new ReOrderArray();
        ROA.f(0,alpha.length-1,alpha);
        for(int i:alpha){
            System.out.print(i+" ");
        }
    }
}
