package pl.miczeq.vet.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.miczeq.vet.model.Owner;
import pl.miczeq.vet.service.OwnerService;

public class OwnerConverter implements Converter<String, Owner> 
{
	@Autowired
	private OwnerService ownerService;
	
	public Owner convert(String ID)
	{
		try
		{
			int ownerID = Integer.parseInt(ID);
			return ownerService.getByID(ownerID);
		}
		catch(NumberFormatException e)
		{
			System.out.println("NIE BANGLA");
			return null;
		}
	}
}
