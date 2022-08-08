package com.kenfukuyama.examples.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kenfukuyama.examples.models.Dojo;
import com.kenfukuyama.examples.services.DojoService;
import com.kenfukuyama.examples.services.NinjaService;


@Controller // this will return .jsp
public class DojoController {
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public DojoController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
    
    
    // ! Get Dojos
    @GetMapping("/dojos")
    public String dojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
    	List<Dojo> dojos = dojoService.allDojos();	
    	model.addAttribute("dojos", dojos);
        return "newDojo.jsp";

    }
    
    
 // ! POST dojos
    @PostMapping("/dojos")
    public String dojoCreate(@Valid @ModelAttribute("dojo") Dojo dojo,
            BindingResult result) {

        if (result.hasErrors()) {
            return "newDojo.jsp";
        }

        dojoService.createDojo(dojo);
        return "redirect:/dojos";

    }
    
    // ! show all ninjas in dojos
    @GetMapping("dojos/{id}/show")
    public String showDojo(@PathVariable("id") Long id, Model model) {
    	Dojo dojo = dojoService.findDojo(id);
    	model.addAttribute("dojo", dojo);
    	
    	return "showDojo.jsp";
    	
    }
    
 
    
	

}
