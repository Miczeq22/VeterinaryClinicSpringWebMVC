package pl.miczeq.vet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.miczeq.vet.model.Owner;
import pl.miczeq.vet.repository.OwnerRepository;
import pl.miczeq.vet.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService
{
	@Autowired
	private OwnerRepository ownerRepository;
	
	public List<Owner> getAllOwners()
	{
		return ownerRepository.getAllOwners();
	}
	
	public void addNewOwner(Owner owner)
	{
		ownerRepository.addNewOwner(owner);
	}
	
	public void removeOwner(int ID)
	{
		ownerRepository.removeOwner(ID);
	}
	
	public Owner getByID(int ID)
	{
		return ownerRepository.getByID(ID);
	}
	
	public void editOwner(int ID, Owner owner)
	{
		ownerRepository.editOwner(ID, owner);
	}
}
