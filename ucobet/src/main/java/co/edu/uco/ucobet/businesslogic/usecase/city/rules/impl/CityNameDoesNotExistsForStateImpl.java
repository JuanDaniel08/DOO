package co.edu.uco.ucobet.businesslogic.usecase.city.rules.impl;

import co.edu.uco.ucobet.businesslogic.usecase.city.rules.CityNameDoesNotExistsForState;
import co.edu.uco.ucobet.crosscutting.exceptions.BusinessLogicUcoBetException;
import co.edu.uco.ucobet.crosscutting.exceptions.DataUcoBetException;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.domain.CityDomain;
import co.edu.uco.ucobet.entity.CityEntity;
import co.edu.uco.ucobet.entity.StateEntity;

public final class CityNameDoesNotExistsForStateImpl implements CityNameDoesNotExistsForState {

	@Override
	public void execute(CityDomain data, DAOFactory factory) {
		// TODO Auto-generated method stub
		final var city = new CityEntity();
		city.setName(data.getName());
		
		final var state= new StateEntity();
		state.setId(data.getState().getId());
		
		city.setState(state);
		
		var results = factory.getCityDAO().findByFilter(city);	
	
		
		if(!results.isEmpty()) {
			var userMenssage = "Ya existe una Ciudad llamada"+city.getName()+"para el departamento "+ results.get(0).getName();
			

			throw BusinessLogicUcoBetException.crear(userMenssage);
		}
	}

}
