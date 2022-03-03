// (1) Write a program to demonstrate Tightly Coupled code.

package com.springframework.q1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Q1Application {

	public static void main(String[] args) {

		int[] array= {1,5,2,54,6,34,31,34,54,1,3};
		BinarySearch binarySearch=new BinarySearch();
		System.out.print("Is element found? ");
	 	System.out.println( !(binarySearch.search(array,0,array.length-1, 6)== -1));
	}

}
