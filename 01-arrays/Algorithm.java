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



}
