package com.ttn.springdata.idgenerators;

import com.ttn.springdata.idgenerators.entities.Employee;
import com.ttn.springdata.idgenerators.repos.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository repository;

	// (3) Perform Create Operation on Entity using Spring Data JPA
	@Test
	void testCreateEmployee() {
		Employee employee=new Employee();
		employee.setName("Alice");
		employee.setAge(32);
		employee.setLocation("Delhi");
		repository.save(employee);

// ---------Please uncomment the following code and then execute to fill the sample table entries----------

//		employee=new Employee();
//		employee.setName("Bob");
//		employee.setAge(22);
//		employee.setLocation("Lucknow");
//		repository.save(employee);
//
//		employee=new Employee();
//		employee.setName("Charlie");
//		employee.setAge(27);
//		employee.setLocation("Mumbai");
//		repository.save(employee);
//
//		employee=new Employee();
//		employee.setName("Karthik");
//		employee.setAge(34);
//		employee.setLocation("Delhi");
//		repository.save(employee);
//
//		employee=new Employee();
//		employee.setName("Ketan");
//		employee.setAge(21);
//		employee.setLocation("Indore");
//		repository.save(employee);
//
//		employee=new Employee();
//		employee.setName("Kirti");
//		employee.setAge(31);
//		employee.setLocation("Ujjain");
//		repository.save(employee);

	}


	// (5) Perform Read Operation on Entity using Spring Data JPA
	@Test
	public void testRead()
	{
		Employee employee=repository.findById(302).get();
		Assertions.assertNotNull(employee);
		Assertions.assertEquals("Alice",employee.getName());
	}


	// (4) Perform Update Operation on Entity using Spring Data JPA
	@Test
	public void testUpdate()
	{
		Employee employee=repository.findById(302).get();
		employee.setLocation("Ujjain");
		repository.save(employee);
	}


	// (5) Perform Delete Operation on Entity using Spring Data JPA
	@Test
	public void testDelete()
	{
		if(repository.existsById(302)) repository.deleteById(302);
	}


	// 	(6) Get the total count of the number of Employees
	@Test
	public void testCount()
	{
		System.out.println(repository.count());
	}


	// (7) Implement Pagination and Sorting on the bases of Employee Age
	@Test
	public void testFindAllPagingAndSorting()
	{
		Pageable pageable= PageRequest.of(0,2, Sort.Direction.ASC,"age");
		repository.findAll(pageable).forEach(t->System.out.println(t.getName()));
	}


	// (8) Create and use finder to find Employee by Name
	@Test
	public void testFindByName()
	{
		List<Employee> products= repository.findByName("Alice");
		products.forEach(e->System.out.println(e.getId()));
	}


	// (9) Create and use finder to find Employees starting with A character
	@Test
	public void testFindByNameLike()
	{
		List<Employee> products= repository.findByNameLike("A%");
		products.forEach(e->System.out.println(e.getName()));
	}


	// (10) Create and use finder to find Employees Between the age of 28 to 32
	@Test
	public void testFindByAgeBetween()
	{
		List<Employee> products= repository.findByAgeBetween(20,30);
		products.forEach(e->System.out.println(e.getName()));
	}

}
