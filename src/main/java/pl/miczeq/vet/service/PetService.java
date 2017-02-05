package pl.miczeq.vet.service;

import java.util.List;

import pl.miczeq.vet.model.Pet;

public interface PetService
{
	List<Pet> getAllPets();
	
	void addPet(Pet pet);
	
	Pet getPetByID(int ID);
	
	void removePet(int ID);
	
	void editPet(int ID, Pet pet);
}
