package co.edu.uco.ucobet.entity;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class CountryEntity extends DomainEntity{
	
	private String name;
	
	public CountryEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	@Override
	public void setId(final UUID id) {
		super.setId(id);
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}
	public static void main(String[] args) {
		CountryEntity country= new CountryEntity();
		country.setName(null);
		
		System.out.println(country.getId());
		System.out.println(country.getName());	
	}

}
