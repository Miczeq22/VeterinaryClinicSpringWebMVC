package pl.miczeq.vet.repository;

import java.util.List;

import pl.miczeq.vet.model.Pet;

public interface PetRepository
{
	List<Pet> getAllPets();
	
	void addPet(Pet pet);
	
	Pet getPetByID(int ID);
	
	void removePet(int ID);
	
	void editPet(int ID, Pet pet);
}
