package com.tienda_online_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.tienda", "com.tienda_online_springboot"})
@EnableJpaRepositories(basePackages = "com.tienda.repository")
@EntityScan(basePackages = "com.tienda.entity")
public class TiendaOnlineSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaOnlineSpringbootApplication.class, args);
	}

}
