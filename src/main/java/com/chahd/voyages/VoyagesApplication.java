package com.chahd.voyages;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.chahd.voyages.entities.Voyage;
import com.chahd.voyages.service.VoyageService;

@SpringBootApplication
public class VoyagesApplication  implements CommandLineRunner{
	@Autowired
	VoyageService voyageService;

	public static void main(String[] args) {
		SpringApplication.run(VoyagesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	    voyageService.saveVoyage(new Voyage("istanbul",2800.500,new Date()));
	    voyageService.saveVoyage(new Voyage("new york ",2800.500,new Date()));
	    voyageService.saveVoyage(new Voyage("Tokyo", 600.00, new Date()));
	}

	

}
