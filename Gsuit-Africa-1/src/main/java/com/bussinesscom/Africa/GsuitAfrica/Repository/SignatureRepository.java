package com.bussinesscom.Africa.GsuitAfrica.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bussinesscom.Africa.GsuitAfrica.Entity.Company;
import com.bussinesscom.Africa.GsuitAfrica.Entity.SignatureTemplate;

public interface SignatureRepository extends JpaRepository<SignatureTemplate, Integer>{

	List<SignatureTemplate> findByCompany(Company myCompany);
	

}
