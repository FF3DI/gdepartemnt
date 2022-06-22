package com.leith.employes.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.leith.employes.models.Rattrapage;
import com.leith.employes.models.Motif;
import com.leith.employes.models.Role;
import com.leith.employes.models.User;
import com.leith.employes.service.RattrapageService;

@Controller
public class RattrapageController {
   @Autowired
   RattrapageService rattrapageService;
   @RequestMapping("/showCreate")
   public String showCreate(ModelMap modelMap)
   {
	   List<Motif> post=rattrapageService.getAllPostes();
	   Rattrapage emp=new Rattrapage(); 
	   Motif pos=new Motif(); 
	   emp.setMotif(pos);
	   
	   modelMap.addAttribute("employe",emp);
	   modelMap.addAttribute("mode", "new");
	   modelMap.addAttribute("postes", post);
	   return "formEmploye";
   }
   
   @RequestMapping("/saveEmploye")
   public String saveEmploye(@Valid Rattrapage employe,

   BindingResult bindingResult)

   {
   if (bindingResult.hasErrors()) 
	   return "formEmploye";
   rattrapageService.saveEmployee(employe);
   return "redirect:/ListeEmployes";
   }
   @RequestMapping("/ListeEmployes")
   public String listeEmployes(ModelMap modelMap,

   @RequestParam (name="page",defaultValue = "0") int page,
   @RequestParam (name="size", defaultValue = "2") int size)

   {
	   
   Page<Rattrapage> emps = rattrapageService.getAllEmployeesParPage(page, size);
   List<Motif> post=rattrapageService.getAllPostes();
   modelMap.addAttribute("employes", emps);
   modelMap.addAttribute("postes", post);
   modelMap.addAttribute("pages", new int[emps.getTotalPages()]);

   modelMap.addAttribute("currentPage", page);
   return "listeEmploye";
   }
   @RequestMapping("/supprimerEmploye")
   public String supprimerEmploye(@RequestParam("id") Long id,

    ModelMap modelMap,
   @RequestParam (name="page",defaultValue = "0") int page,
   @RequestParam (name="size", defaultValue = "2") int size)

   {
   rattrapageService.deleteEmployeeById(id);
   Page<Rattrapage> emps = rattrapageService.getAllEmployeesParPage(page, size);

   modelMap.addAttribute("employes", emps);
   modelMap.addAttribute("pages", new int[emps.getTotalPages()]);
   modelMap.addAttribute("currentPage", page);
   modelMap.addAttribute("size", size);
   return "listeEmploye";
   }
   
   
   @RequestMapping("/modifierEmploye")
   public String editerEmploye(@RequestParam("id") Long id,ModelMap modelMap)
   {
   Rattrapage e= rattrapageService.getEmployee(id);
   List<Motif> post=rattrapageService.getAllPostes();
   modelMap.addAttribute("employe", e);
   modelMap.addAttribute("mode", "edit");
   modelMap.addAttribute("postes", post);
   return "formEmploye";
   }
   @RequestMapping("/updateEmploye")
   public String updateEmploye(@ModelAttribute("employe") Rattrapage employe,
   @RequestParam("date") String date,

   
   ModelMap modelMap) throws ParseException

   {
   //conversion de la date

   SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
   Date datenaissance = dateformat.parse(String.valueOf(date));
   employe.setDate(datenaissance);
   rattrapageService.updateEmployee(employe);
   List<Rattrapage> emps = rattrapageService.getAllEmployees();
   modelMap.addAttribute("employe", emps);
   return "listeEmploye";

   }
   
   @RequestMapping("/chercherNom")
   public String chercherEmploye(@RequestParam("nomEmploye") String nom,
   		ModelMap modelMap,
   		@RequestParam (name="page",defaultValue = "0") int page,
   		@RequestParam (name="size", defaultValue = "10") int size)
   
   
   {     
	 	
   	  List <Rattrapage> emps = rattrapageService.findByNomEmployesContains(nom);
   	  
   	  modelMap.addAttribute("Employes",emps);
   	 
   	  
   	  return "resultat";
   }  
  
}

