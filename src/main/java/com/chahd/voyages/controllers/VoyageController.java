package com.chahd.voyages.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chahd.voyages.entities.Voyage;
import com.chahd.voyages.service.VoyageService;
@Controller
public class VoyageController {
@Autowired
VoyageService voyageService;
 @RequestMapping("/ListeVoyages")
public String ListeVoyages(ModelMap modelMap,
		@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
{
	Page<Voyage> voyages = voyageService.getAllVoyagesParPage(page, size);
	modelMap.addAttribute("voyages", voyages);
	modelMap.addAttribute("pages", new int[voyages.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeVoyages";

}
 @RequestMapping("/showCreate")
public String showCreate()
{
return "createVoyage";
}
@RequestMapping("/saveVoyage")
public String saveVoyage(@ModelAttribute("voyage") Voyage voyage,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateVoyage = dateformat.parse(String.valueOf(date));
 voyage.setDateVoyage(dateVoyage);

 Voyage saveVoyage = voyageService.saveVoyage(voyage);
String msg ="voyage enregistré avec Id "+saveVoyage.getIdVoyage();
modelMap.addAttribute("msg", msg);
return "createVoyage";
}

 @RequestMapping("/supprimerVoyage")
public String supprimerProduit(@RequestParam("id") Long id,
 ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
 @RequestParam (name="size", defaultValue = "2") int size)
{
	 voyageService.deleteVoyageById(id);
	 Page<Voyage> voyages = voyageService.getAllVoyagesParPage(page, size);
	 modelMap.addAttribute("voyages", voyages);
	 modelMap.addAttribute("pages", new int[voyages.getTotalPages()]);
	 modelMap.addAttribute("currentPage", page);
	 modelMap.addAttribute("size", size); // Ajout de la taille de la page

return "listeVoyages";
}

 @RequestMapping("/modifierVoyage")
public String editerVoyage(@RequestParam("id") Long id,
 ModelMap modelMap)
{
	 Voyage v= voyageService.getVoyage(id);
modelMap.addAttribute("voyage", v);
return "editerVoyage";
}
@RequestMapping("/updateVoyage")
public String updateVoyage(@ModelAttribute("voyage") Voyage
		voyage, @RequestParam("date") String date,
 ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateVoyage = dateformat.parse(String.valueOf(date));
 voyage.setDateVoyage(dateVoyage);

 voyageService.updateVoyage(voyage);
 List<Voyage> voyas = voyageService.getAllVoyages();
 modelMap.addAttribute("voyages", voyas);
return "listeVoyages";
}
}