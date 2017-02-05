package pl.miczeq.vet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "owner")
public class Owner implements Serializable
{
	private static final long serialVersionUID = -6671512778160683748L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID", nullable = false)
	private Integer ID;
	
	@Basic(optional = false)
	@Column(name = "firstname", nullable = false, length = 50)
	@Size(min=3, max=50, message="{owner.validation.badFirstName}")
	private String firstName;
	
	@Basic(optional = false)
	@Column(name = "lastname", nullable = false, length = 50)
	@Size(min=3, max=50, message="{owner.validation.badLastName}")
	private String lastName;
	
	@Basic(optional = false)
	@Column(name = "city", nullable = false, length = 100)
	@Size(min=3, max=50, message="{owner.validation.badCity}")
	private String city;
	
	@Basic(optional = false)
	@Column(name = "address", nullable = false, length = 100)
	@Size(min=4, max=100, message="{owner.validation.badAddress}")
	private String address;
	
	@Basic(optional = false)
	@Column(name = "phonenumber", nullable = false, length = 9)
	@Size(min=9, max=9, message="{owner.validation.badPhoneNumber}")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Pet> petSet;
	
	public Owner() {}
	
	public void setData(String firstName, String lastName, String city, String address, String phoneNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Integer getID()
	{
		return ID;
	}

	public void setID(Integer iD)
	{
		ID = iD;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public Set<Pet> getPetSet()
	{
		return petSet;
	}

	public void setPetSet(Set<Pet> petSet)
	{
		this.petSet = petSet;
	}

	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		if (ID == null)
		{
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (address == null)
		{
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null)
		{
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (firstName == null)
		{
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null)
		{
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null)
		{
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Owner [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
