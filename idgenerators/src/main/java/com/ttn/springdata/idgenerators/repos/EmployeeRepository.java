package com.ttn.springdata.idgenerators.repos;

import com.ttn.springdata.idgenerators.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
     List<Employee> findByName(String name);
     List<Employee> findByNameLike(String str);
     List<Employee> findByAgeBetween(int age1, int age2);


}
