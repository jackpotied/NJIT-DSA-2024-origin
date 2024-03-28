package oy.tol.tra;

public class Algorithms {
    public static <T> void swap(T[]array,int a,int b){
        T temp;
        temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
    public static <T extends Comparable<T>> void sort(T [] array) {
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j< array.length-i-1;j++){
                if(array[j].compareTo(array[j+1])>0){
                    swap(array,j,j+1);
                }
            }
        }

    }



    public static <T> void reverse(T [] array) {
        for(int i=0;i<=array.length/2-1;i++){
            swap(array,i, array.length-i-1);
        }
    }
    public static <T extends Comparable<T>> int binarySearch(T aValue, T [] fromArray, int fromIndex, int toIndex) {
        if(fromIndex==toIndex){
            if (aValue.compareTo(fromArray[fromIndex])==0){
                return fromIndex;
            }else{
                return -1;
            }
        }
        int mid=(fromIndex+toIndex)/2;
        int temp=aValue.compareTo(fromArray[mid]);
        if(temp==0){
            return mid;
        } else if (temp>0) {
            return binarySearch(aValue,fromArray,mid+1,toIndex);
        } else {
            return binarySearch(aValue,fromArray,fromIndex,mid-1);
        }
    }
    public static <E extends Comparable<E>> void fastSort(E [] array) {
        quickSort(array, 0, array.length - 1);
    }
    public static <E extends Comparable<E>> void quickSort(E [] array, int begin, int end) {
        if(begin>=end){
            return;
        }
        int flag = partition(array,begin,end);
        quickSort(array,begin,flag-1);
        quickSort(array,flag+1,end);
    }
    private static <E extends Comparable<E>> int partition(E [] array, int begin, int end) {
        E flag =array[begin];
        int i=begin;int j=end;
        while(true){
            while(array[i].compareTo(flag)<0){
                i++;
            }
            while (array[j].compareTo(flag)>0){
                j--;
            }
            if(i<j){
                swap(array,i,j);
            }else{
                return i;
            }


        }
    }



}
