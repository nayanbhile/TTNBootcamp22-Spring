package com.ttn.springcloud.coupenservice.repos;

import com.ttn.springcloud.coupenservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
