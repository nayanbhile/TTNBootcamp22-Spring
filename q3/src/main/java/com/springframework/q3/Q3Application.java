// (3) Use @Compenent and @Autowired annotations to in Loosely Coupled code for dependency management
// (4) Get a Spring Bean from application context and display its properties.


package com.springframework.q3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Q3Application {

	public static void main(String[] args) {
		int[] array= {1,5,2,54,6,34};
//		BinarySearch binarySearch=new BinarySearch(new QuickSort());
//	 	System.out.println( binarySearch.search(array,4));

		ApplicationContext applicationContext= SpringApplication.run(Q3Application.class, args);
		BinarySearch binarySearch= applicationContext.getBean(BinarySearch.class);
		System.out.print("Is element found? ");
		System.out.println( !(binarySearch.search(array,0,array.length-1, 6)== -1));

		binarySearch.printProperties();

	}

}
