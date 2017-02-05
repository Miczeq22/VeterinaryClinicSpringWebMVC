package pl.miczeq.vet.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pet")
public class Pet implements Serializable
{
	private static final long serialVersionUID = 356993528957980913L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID", nullable = false)
	private Integer ID;
	
	@Basic(optional = false)
	@Column(name = "petname", nullable = false, length = 50)
	@Size(min=2, max = 50, message="{pet.validation.badPetName}")
	private String petName;
	
	@Basic(optional = false)
	@Column(name = "birthdate", nullable = false)
	@Pattern(regexp="[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}", message="{pet.validation.badBirthDate}")
	private String birthDate;
	
	@Basic(optional = false)
	@Column(name = "animaltype", nullable = false, length = 50)
	private String animalType;
	
	@JoinColumn(name = "owner", referencedColumnName = "ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private Owner owner;
	
	public Pet() {}
	
	public void setData(Owner owner, String petName, String animalType, String birthDate)
	{
		this.owner = owner;
		this.petName = petName;
		this.animalType = animalType;
		this.birthDate = birthDate;
	}

	public Integer getID()
	{
		return ID;
	}

	public void setID(Integer iD)
	{
		ID = iD;
	}

	public String getPetName()
	{
		return petName;
	}

	public void setPetName(String petName)
	{
		this.petName = petName;
	}

	public String getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate;
	}

	public String getAnimalType()
	{
		return animalType;
	}

	public void setAnimalType(String animalType)
	{
		this.animalType = animalType;
	}

	public Owner getOwner()
	{
		return owner;
	}

	public void setOwner(Owner owner)
	{
		this.owner = owner;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((animalType == null) ? 0 : animalType.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((petName == null) ? 0 : petName.hashCode());
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
		Pet other = (Pet) obj;
		if (ID == null)
		{
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (animalType == null)
		{
			if (other.animalType != null)
				return false;
		} else if (!animalType.equals(other.animalType))
			return false;
		if (birthDate == null)
		{
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (petName == null)
		{
			if (other.petName != null)
				return false;
		} else if (!petName.equals(other.petName))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Pet [ID=" + ID + ", petName=" + petName + ", owner=" + owner + "]";
	}
}
