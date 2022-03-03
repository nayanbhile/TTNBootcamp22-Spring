package com.springframework.q3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearch {
    SortAlgorithm sortAlgorithm;

// These properties have no significance related to logic, they are just defined to answer the question number 4

    int lowerBound;
    int upperBound;
    int searchingElement;
    boolean elementFound;
    int tmp=0;

    @Autowired
    public BinarySearch(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int search(int arr[], int lowerBound, int upperBound, int searchingElement)
    {
        if(tmp==0) this.storeProperties(lowerBound, upperBound, searchingElement);

        this.elementFound=true;
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
        this.elementFound=false;
        return -1;
    }

    private void storeProperties(int lowerBound, int upperBound, int searchingElement)
    {
        this.lowerBound=lowerBound;
        this.upperBound=upperBound;
        this.searchingElement=searchingElement;
        this.tmp=1;
    }
    public void printProperties()
    {
        StringBuffer sb=new StringBuffer();
        sb.append("Lower bound: "+this.lowerBound);
        sb.append("\nUpper bound: "+this.upperBound);
        sb.append("\nValue of element to search : "+this.searchingElement);
        sb.append("\nWas element found: "+this.elementFound);
        System.out.println(sb.toString());
    }
}
