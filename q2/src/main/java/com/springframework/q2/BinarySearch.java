package com.springframework.q2;

public class BinarySearch {
    SortAlgorithm sortAlgorithm;

    public BinarySearch(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

   public int search(int arr[], int l, int r, int x)
    {
        sortAlgorithm.sort(arr);

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
}
