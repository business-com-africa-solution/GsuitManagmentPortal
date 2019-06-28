package com.bussinesscom.Africa.GsuitAfrica.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bussinesscom.Africa.GsuitAfrica.Entity.Role;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

	List<UserRole> findByUserApp(Optional<UserApp> user);

}
