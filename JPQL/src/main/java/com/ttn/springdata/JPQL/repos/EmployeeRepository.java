package com.ttn.springdata.JPQL.repos;

import com.ttn.springdata.JPQL.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    // Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.

    @Query("SELECT fname,lname FROM Employee " +
            "WHERE (SELECT AVG(salary) FROM Employee)<salary " +
            "ORDER BY Employee.salary ASC")
    List<Object[]> findAboveAvgSalary();

    @Modifying
    @Query("UPDATE Employee e " +
            "SET e.salary= :salary " +
            "WHERE e.salary<(SELECT AVG(salary) FROM e)")
    void updateSalaryOfEmployee(@Param("salary") int salary);
}
