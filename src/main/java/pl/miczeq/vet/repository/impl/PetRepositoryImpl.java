package pl.miczeq.vet.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.miczeq.vet.model.Pet;
import pl.miczeq.vet.repository.PetRepository;

@Repository
@Transactional
public class PetRepositoryImpl implements PetRepository
{
	@PersistenceContext
	private EntityManager em;
	
	public List<Pet> getAllPets()
	{
		List list = em.createQuery("SELECT p FROM Pet p").getResultList();
		
		return list;
	}
	
	public void addPet(Pet pet)
	{
		em.persist(pet);
		em.flush();
	}
	
	public Pet getPetByID(int ID)
	{
		Pet pet = em.find(Pet.class, ID);
		
		return pet;
	}
	
	public void editPet(int ID, Pet pet)
	{
		Pet newPet = em.find(Pet.class, ID);
		newPet.setData(pet.getOwner(), pet.getPetName(), pet.getAnimalType(), pet.getBirthDate());
		em.persist(newPet);
		em.flush();
	}
	
	public void removePet(int ID)
	{
		em.remove(em.find(Pet.class, ID));
		em.flush();
	}
}
