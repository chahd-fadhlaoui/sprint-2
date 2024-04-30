package com.chahd.voyages.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chahd.voyages.entities.Voyage;
import com.chahd.voyages.service.VoyageService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VoyageRESTController {
	@Autowired
	VoyageService voyageService;
	@RequestMapping(method = RequestMethod.GET)

	List<Voyage> getAllVoyages() 
	{
	    return voyageService.getAllVoyages();
	}	

	


}
