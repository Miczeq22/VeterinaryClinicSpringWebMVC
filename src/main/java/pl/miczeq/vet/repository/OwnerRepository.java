package pl.miczeq.vet.repository;

import java.util.List;

import pl.miczeq.vet.model.Owner;

public interface OwnerRepository
{
	List<Owner> getAllOwners();
	
	void addNewOwner(Owner owner);
	
	void removeOwner(int ID);
	
	Owner getByID(int ID);
	
	void editOwner(int ID, Owner owner);
}
