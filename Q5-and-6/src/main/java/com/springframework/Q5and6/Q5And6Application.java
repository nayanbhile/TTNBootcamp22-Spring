/*
(5) Demonstrate how you will resolve ambiguity while autowiring bean (Hint : @Primary)
(6) Perform Constructor Injection in a Spring Bean
 */

package com.springframework.Q5and6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Q5And6Application {

	public static void main(String[] args) {

			int[] array= {1,5,2,54,6,34,34,64,7,2};
			ApplicationContext applicationContext= SpringApplication.run(Q5And6Application.class, args);
			BinarySearch binarySearch= applicationContext.getBean(BinarySearch.class);
			System.out.print("Is element found? ");
			System.out.println( !(binarySearch.search(array,0,array.length-1, 6)== -1));
	}

}
