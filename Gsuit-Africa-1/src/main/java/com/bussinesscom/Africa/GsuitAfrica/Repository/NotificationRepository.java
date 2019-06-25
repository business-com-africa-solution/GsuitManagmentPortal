package com.bussinesscom.Africa.GsuitAfrica.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bussinesscom.Africa.GsuitAfrica.Entity.Notification;
import com.bussinesscom.Africa.GsuitAfrica.Entity.UserApp;

public interface NotificationRepository extends JpaRepository<Notification, Long>{


	List<Notification> findByUserApp(Optional<UserApp> user);

}
