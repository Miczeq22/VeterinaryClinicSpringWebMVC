package pl.miczeq.vet.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.miczeq.vet.model.Owner;
import pl.miczeq.vet.repository.OwnerRepository;

@Repository
@Transactional
public class OwnerRepositoryImpl implements OwnerRepository
{
	@PersistenceContext
	private EntityManager em;
	
	public List<Owner> getAllOwners()
	{
		List list = em.createQuery("SELECT o FROM Owner o").getResultList();
		
		return list;
	}
	
	public void addNewOwner(Owner owner)
	{
		em.persist(owner);
		em.flush();
	}
	
	public void removeOwner(int ID)
	{
		em.remove(em.find(Owner.class, ID));
		em.flush();
	}
	
	public Owner getByID(int ID)
	{
		Owner owner = em.find(Owner.class, ID);
		
		return owner;
	}
	
	public void editOwner(int ID, Owner owner)
	{
		Owner updatedOwner = em.find(Owner.class, ID);
		updatedOwner.setData(owner.getFirstName(), owner.getLastName(), owner.getCity(), owner.getAddress(), owner.getPhoneNumber());
		em.persist(updatedOwner);
		em.flush();
	}
}
