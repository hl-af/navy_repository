package JianzhiOffer.niXuDu;

public class SortSequenceSort51 {
    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4,5,5,5,5,5,7,8,9};
        System.out.println(findKlenNum(a,5));

    }
    static int findKlenNum(int[] a,int k){
        int from = findLeftNum(a,k);
        int to = findRightNum(a,k);
        return to-from+1;
    }
    static int findLeftNum(int[] a ,int k){
        int low = 0;
        int high = a.length-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(a[mid] < k){
                low = mid + 1;
            }else if(a[mid] > k){
                high = mid -1;
            }else{
                if(mid>0&&a[mid-1]==k){
                    high = mid-1;
                }else
                    return mid;
            }
        }
        return -1;
    }

    static int findRightNum(int[] a ,int k){
        int low = 0;
        int high = a.length-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(a[mid] < k){
                low = mid + 1;
            }else if(a[mid] > k){
                high = mid -1;
            }else {
                if(mid<a.length-1&&a[mid+1]==k){
                    //mid<a.length-1是为了防止{1,2,3,3,3,3}的情况
                    low = mid + 1;
                }else
                    return mid;
            }
        }
        return -1;
    }


}
