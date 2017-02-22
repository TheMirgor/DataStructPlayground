package com.si;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PlayingWithArrayBean {
    private String title = "Playing with Arrays and Sorting Algorithms.";
    private int[] anArray;

    public PlayingWithArrayBean() {
        //anArray = new int[10];
        anArray = new int[] {7, 4, 2, 9, 6, 8, 5, 0, 1, 3};
    }

    ///////////////////////////////////////////////////////////////////////////
    // Bubble Sort - A comparison-based sort, compares each pair of adjacent
    // items and swaps them if they are in the wrong order. Large values bubble
    // their way up or down depending on order.
    // Avg: O(n^2)
    ///////////////////////////////////////////////////////////////////////////
    public String getBubbleSortedDesc() {
        int[] sortedArray = anArray.clone();

        int i;
        boolean flag = true;
        int temp;

        while(flag) {
            flag = false;
            for(i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {  // switch to use > for Ascending
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }

        return getAsString(sortedArray);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Merge Sort - A comparison-based sort using divide and conquer. Stable Sort.
    // Best/Avg: O(n log(n))
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getMergeSortedDesc() {
        int[] sortedArray = anArray.clone();

        int[] tmp = new int[sortedArray.length];

        mergeSort(sortedArray, tmp, 0, sortedArray.length - 1);

        return getAsString(sortedArray);
    }

    private void mergeSort(int[] a, int[] tmp, int left, int right) {
        if(left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private void merge(int[] a, int[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] > a[right])    // switch to use < for Ascending
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)
            tmp[k++] = a[left++];

        while(right <= rightEnd)
            tmp[k++] = a[right++];

        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Quick Sort - A comparison-based sort using divide and conquer, can be used on any comparable type. Not Stable!
    // Best/Avg: O(n log(n))
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getQuickSortedDesc() {
        int[] sortedArray = anArray.clone();

        quickSort(sortedArray, 0, sortedArray.length - 1);

        return getAsString(sortedArray);
    }

    private void quickSort(int[] a, int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        // calculate a pivot number
        int pivot = a[(higherIndex + lowerIndex) / 2];
        // Divide into 2 arrays, in each iteration identify a number from left side which is greater and identify a number
        // from the right side which is less than the pivot value.  then exchange them
        while(i <= j) {
            while(a[i] < pivot)
                i++;
            while(a[j] > pivot)
                j--;
            if(i <= j) {
                exchangeNumbers(a, i, j);
                i++;
                j--;
            }
        }
        if(lowerIndex < j)
            quickSort(a, lowerIndex, j);
        if(i < higherIndex)
            quickSort(a, i, higherIndex);
    }





    public String getTitle() {
        return title;
    }


    public String getAsString() {
        return getAsString(anArray);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // HELP!
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private String getAsString(int[] pArray) {
        StringBuilder sb = new StringBuilder();
        for(int i : pArray) {
            sb.append(i + " ");
        }
        return sb.toString();
    }

    private void exchangeNumbers(int[] pArray, int i, int j) {
        int temp = pArray[i];
        pArray[i] = pArray[j];
        pArray[j] = temp;
    }
}
