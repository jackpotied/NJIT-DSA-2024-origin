package oy.tol.tra;

import java.util.Comparator;
import java.util.function.Predicate;

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
        E flag = array[begin];
        int i = begin;
        int j = end;
        while (true) {
            while (array[i].compareTo(flag) < 0) {
                i++;
            }
            while (array[j].compareTo(flag) > 0) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            } else {
                return i;
            }
        }
    }
    public static<E> void sortWithComparator(E[] array, Comparator<E> comparator) {
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j< array.length-i-1;j++){
                if(comparator.compare(array[j],array[j+1])>0){
                    swap(array,j,j+1);
                }
            }
        }

    }

    public static <T> int partitionByRule(T[] array, int count, Predicate<T> rule) {
        // Find first element rules applies to.
        // Index of that element will be in variable index.
        int index = 0;
        for (; index < count; index++) {
            if (rule.test(array[index])) {
                break;
            }
        }
        // If went to the end, nothing was selected so quit here.
        if (index >= count) {
            return count;
        }
        // Then start finding not selected elements starting from next from index.
        // If the element is not selected, swap it with the selected one.
        int nextIndex = index + 1;
        // Until end of array reached.
        while (nextIndex != count) {
            if (!rule.test(array[nextIndex])) {
                swap(array, index, nextIndex);
                // If swapping was done, add to index since now it has non-selected element.
                index++;
            }
            nextIndex++;
        }
        return index;
    }
}
