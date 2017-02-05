package pl.miczeq.vet.service;

import java.util.List;

import pl.miczeq.vet.model.Owner;

public interface OwnerService
{
	List<Owner> getAllOwners();
	
	void addNewOwner(Owner owner);
	
	void removeOwner(int ID);
	
	Owner getByID(int ID);
	
	void editOwner(int ID, Owner owner);
}
