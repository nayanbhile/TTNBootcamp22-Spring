// (2) Write a program to demonstrate Loosely Coupled code.

package com.springframework.q2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Q2Application {

	public static void main(String[] args) {
		int[] array= {1,5,2,54,6,34,31,34,54,1,3};
		BinarySearch binarySearch=new BinarySearch(new SelectionSort());
//		BinarySearch binarySearch=new BinarySearch(new BubbleSort());
		System.out.print("Is element found? ");
		System.out.println( !(binarySearch.search(array,0,array.length-1, 6)== -1));
	}

}
