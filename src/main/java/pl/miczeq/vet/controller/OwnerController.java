package pl.miczeq.vet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.miczeq.vet.model.Owner;
import pl.miczeq.vet.model.Pet;
import pl.miczeq.vet.service.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController
{
	@Autowired
	private OwnerService ownerService;
	
	@RequestMapping("/all")
	public String showAll(Model model)
	{
		for(Owner o : ownerService.getAllOwners())
		{
			System.out.println("Imie: " + o.getFirstName() + " Nazwisko: " + o.getLastName() + " Adres: " + o.getAddress());
		}
		
		model.addAttribute("owners", ownerService.getAllOwners());
		
		return "showOwners";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddNewOwner(@ModelAttribute("newOwner") Owner newOwner)
	{
		return "addOwner";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddNewOwner(@ModelAttribute("newOwner") @Valid Owner newOwner, BindingResult result, HttpServletRequest request)
	{
		if(result.hasErrors())
		{
			return "addOwner";
		}
		
		ownerService.addNewOwner(newOwner);
		
		return "redirect:/owners/all";
	}
	
	@RequestMapping("/remove")
	public String removeOwner(@RequestParam("ID") int ID)
	{
		ownerService.removeOwner(ID);
		
		return "redirect:/owners/all";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editOwner(@RequestParam("ID") int ID, Model model)
	{
		model.addAttribute("ownerToEdit", ownerService.getByID(ID));
		
		return "editOwner";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String processEditOwner(@ModelAttribute("ownerToEdit") @Valid Owner owner, @RequestParam("ID") int ownerID, BindingResult result, HttpServletRequest request)
	{
		if(result.hasErrors())
		{
			return "editOwner";
		}
		
		ownerService.editOwner(ownerID, owner);
		
		return "redirect:/owners/all";
	}
	
	public String addNewPet(@ModelAttribute("newPet") Pet pet, @RequestParam("ID") int ID, Model model)
	{
		model.addAttribute("owner", ownerService.getByID(ID));
		
		return "addPet";
	}
}
