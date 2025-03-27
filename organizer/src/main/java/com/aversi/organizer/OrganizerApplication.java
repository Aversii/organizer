package com.aversi.organizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aversi.organizer.domain.objectValue.Email;

@SpringBootApplication
public class OrganizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizerApplication.class, args);

		Email mail = new Email("lucasaversi@gmail.com");
		System.out.println(mail.getAddress());
	}

}
