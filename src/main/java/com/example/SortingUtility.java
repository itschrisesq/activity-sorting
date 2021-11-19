package com.example;

public class SortingUtility {

    public static<T extends Comparable<T>> void selectionSort(Integer[] data) {

        int min;

        for (int index = 0; index < data.length -1; index++) {

            //assume first value is min
            min = index;

            for (int scan = index + 1; scan < data.length; scan++) {

                //find min value
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;
                }

            }
            swap(data, min, index);
        }

    }
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data [index2];
        data [index2] = temp;
    }

    public static<T extends Comparable<T>> void insertionSort(T[] data) {

        for (int index = 1; index < data.length; index++) {

            T key = data[index];
            int position = index;

            while (position > 0 && data[position -1].compareTo(key) > 0) {
                data[position] = data[position -1];
                position--;
            }

            data[position] = key;

        }
    }

    public static<T extends Comparable<T>> void bubbleSort(T[] data) {

        int position, scan;

        for (position = data.length - 1; position >= 0; position++) {

            for (scan = 0; scan <= position -1; scan++) {

                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    swap (data, scan, scan + 1);
                }
            }
        }
    }

    public static<T extends Comparable<T>> void quickSort(T[] data) {

        quickSort(data, 0, data.length - 1);
    }

        private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max) {
            if (min < max) {

                int indexOfPartition = partition(data, min, max);

                //sort left partition
                quickSort(data, min, indexOfPartition -1);
                //sort right partition
                quickSort(data, indexOfPartition + 1, max);
            }
        }

    public static <T extends Comparable<T>> void mergeSort(T[] data) {
        mergeSort(data, 0, data.length);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max) {

        if (min < max) {

            int mid = (min + max) / 2;
            mergeSort(data, min, mid);
            mergeSort(data, mid + 1, max);
            merge(data, min, mid, max);
        }
    }

    private static <T extends Comparable<T>> void mergeSort(T[] data, int first, int mid, int last) {
        T[] temp = (T[]) new Comparable[data.length];

        int first = first1, last1 = mid; // endpoints of first sub-array
        int first2 = mid + 1, last2 = last; // endpoints of second sub-array
        int index = first1; // next index open in temp array

        //Copy smaller item from each sub-array into temp until one of the sub-arrays is exhausted

        while (first1 <= last1 && first2 <= last2) {

            if (data[first1].compareTo(data[first2]) < 0) {
                //Not Sorted
                temp[index] = data[first1];
                first1++;
            } else {
                //sorted
                temp[index] = data[first2];
                first2++;
            }
            index++; //increment for next sorted value

        }
        // copy remaining elements from first sub-array, if any
        while (first1 <= last1) {
            temp[index] = data[first1];
            first1++;
            index++;
        }

        // copy remaining elements from second sub-array, if any
        while (first2 <= last2) {
            temp[index] = data[first2];
            first2++;
            index++;
        }

        //copy merged data into original copy
        for (index = first; index <= last; index++) {
            data[index] = temp[index];
        }

    }
}
