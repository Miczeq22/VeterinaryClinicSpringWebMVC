package pl.miczeq.vet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.miczeq.vet.model.Pet;
import pl.miczeq.vet.repository.PetRepository;
import pl.miczeq.vet.service.PetService;

@Service
public class PetServiceImpl implements PetService
{
	@Autowired
	private PetRepository petRepository; 
	
	public List<Pet> getAllPets()
	{
		return petRepository.getAllPets();
	}
	
	public void addPet(Pet pet)
	{
		petRepository.addPet(pet);
	}
	
	public Pet getPetByID(int ID)
	{
		return petRepository.getPetByID(ID);
	}
	
	public void editPet(int ID, Pet pet)
	{
		petRepository.editPet(ID, pet);
	}
	
	public void removePet(int ID)
	{
		petRepository.removePet(ID);
	}
} 
