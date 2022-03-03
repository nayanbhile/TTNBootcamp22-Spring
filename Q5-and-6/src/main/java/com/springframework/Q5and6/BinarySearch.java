package com.springframework.Q5and6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearch {
    SortAlgorithm sortAlgorithm;

    @Autowired
    public BinarySearch(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int search(int arr[], int lowerBound, int upperBound, int searchingElement)
    {
        sortAlgorithm.sort(arr);
        if (upperBound >= lowerBound) {
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            if (arr[mid] == searchingElement) {
                return mid;
            }
            if (arr[mid] > searchingElement)
                return search(arr, lowerBound, mid - 1, searchingElement);

            return search(arr, mid + 1, upperBound, searchingElement);
        }
        return -1;
    }

}
