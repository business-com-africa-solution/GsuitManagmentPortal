package com.bussinesscom.Africa.GsuitAfrica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bussinesscom.Africa.GsuitAfrica.Entity.Domain;

public interface DomainRepository  extends JpaRepository<Domain, Long>{

	Domain findByDomainName(String string);

}
