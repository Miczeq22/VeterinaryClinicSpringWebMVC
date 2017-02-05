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

import pl.miczeq.vet.model.Pet;
import pl.miczeq.vet.service.OwnerService;
import pl.miczeq.vet.service.PetService;

@Controller
@RequestMapping("/pets")
public class PetController
{
	@Autowired
	private PetService petService;
	
	@Autowired
	private OwnerService ownerService;
	
	@RequestMapping("/all")
	public String showPets(Model model)
	{
		
		model.addAttribute("pets", petService.getAllPets());

		return "showPets";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddNewPet(@ModelAttribute("newPet") Pet pet, Model model)
	{
		model.addAttribute("owners", ownerService.getAllOwners());
		
		return "addPet";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddNewPet(@ModelAttribute("newPet") @Valid Pet pet, BindingResult result, HttpServletRequest request, Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("owners", ownerService.getAllOwners());
			return "addPet";
		}
		
		petService.addPet(pet);
		
		return "redirect:/pets/all";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String getEditPet(@RequestParam("ID") int ID, Model model)
	{
		model.addAttribute("owners", ownerService.getAllOwners());
		model.addAttribute("petToEdit", petService.getPetByID(ID));
		
		return "editPet";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String processEditPet(@ModelAttribute("petToEdit") @Valid Pet pet, @RequestParam("ID") int ID, BindingResult result, HttpServletRequest request)
	{
		if(result.hasErrors())
		{
			return "editPet";
		}
		
		petService.editPet(ID, pet);
		
		return "redirect:/pets/all";
	}
	
	@RequestMapping("/remove")
	public String removePet(@RequestParam("ID") int ID)
	{
		petService.removePet(ID);
		
		return "redirect:/pets/all";
	}
}
