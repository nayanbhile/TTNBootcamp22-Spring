package com.ttn.springdata.JPQL;

import com.ttn.springdata.JPQL.entities.Employee;
import com.ttn.springdata.JPQL.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
class JpqlApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateEmployee()
	{
		Employee employee=new Employee();
		employee.setFirstName("Alice");
		employee.setLastName("Tirkey");
		employee.setSalary(35000);
		employeeRepository.save(employee);

		employee=new Employee();
		employee.setFirstName("Bob");
		employee.setLastName("Sethi");
		employee.setSalary(34000);
		employeeRepository.save(employee);

		employee=new Employee();
		employee.setFirstName("Robert");
		employee.setLastName("Gome");
		employee.setSalary(54000);
		employeeRepository.save(employee);

		employee=new Employee();
		employee.setFirstName("Paola");
		employee.setLastName("Rodriguez");
		employee.setSalary(32144);
		employeeRepository.save(employee);

		employee=new Employee();
		employee.setFirstName("Ritik");
		employee.setLastName("Sharma");
		employee.setSalary(14242);
		employeeRepository.save(employee);

		employee=new Employee();
		employee.setFirstName("Samantha");
		employee.setLastName("Lion");
		employee.setSalary(76000);
		employeeRepository.save(employee);

		employee=new Employee();
		employee.setFirstName("Charlie");
		employee.setLastName("Robert");
		employee.setSalary(27000);
		employeeRepository.save(employee);

		employee=new Employee();
		employee.setFirstName("Natasha");
		employee.setLastName("Singh");
		employee.setSalary(12000);
		employeeRepository.save(employee);
	}

	@Test
	public void testFindAboveAvgSalary()
	{
		List<Object[]> objects= employeeRepository.findAboveAvgSalary();
		for (Object[] obj: objects)
		{
			System.out.print(obj[0]);
			System.out.print(" ");
			System.out.println(obj[1]);
		}
	}

	@Test
	public void testUpdateEmployeeSalary()
	{
		employeeRepository.updateSalaryOfEmployee(55555);
	}


}
