package com.springframework.q1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class BinarySearch {

    public BinarySearch() {
    }

    public int search(int arr[], int l, int r, int x)
    {
        // Case- 1 (Sorting with Bubble Sort)
        bubbleSort(arr);

        // Case- 2 (Sorting with Selection Sort)
        // selectionSort(arr);

        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return search(arr, l, mid - 1, x);

            return search(arr, mid + 1, r, x);
        }
        return -1;
    }

    public int[] selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }

    public int[] bubbleSort(int[] arr) {

        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;
    }
}

