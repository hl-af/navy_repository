package JianzhiOffer.niXuDu;

public class NiXuDuTest {

    public static void main(String[] args){
        int[] a = new int[]{5,4,1,2,3};
        System.out.println(inverseParis(a));
    }
    public static int inverseParis(int[] array){
        if(array==null){
            return 0;
        }
        int[] aux = new int[array.length];
        return sort(array, aux, 0, array.length - 1);

    }
    public static int sort(int[] array,int[] aux,int low,int high){
        if(high<=low){
            return 0;
        }
        int mid = (low + high)/2;
        int lowSequence = sort(array,aux,low,mid);
        int highSequenve = sort(array,aux,mid+1,high);
        int megeSequence = merge(array,aux,low,mid,high);
        return lowSequence + highSequenve+ megeSequence;
    }
    public static int merge(int[] array,int[] aux,int low,int mid,int high){
        int i = low;
        int j = mid;
        int times = 0;
        int k = low;
        while(i<=mid||j<=high){
            if(array[i]>array[j]){
                times++;
                aux[k++] = array[j++];
            }else {
                aux[k++] = array[i++];
            }
        }
        int start = i;int end = mid;
        if(start>=mid){
            start = j;
            end = high;
        }
        while(start<=end){
            aux[k++] = array[start++];
        }
        k = low;
        while(k<=high){
            array[k] = aux[k];
            k++;
        }
        return times;
    }
}
