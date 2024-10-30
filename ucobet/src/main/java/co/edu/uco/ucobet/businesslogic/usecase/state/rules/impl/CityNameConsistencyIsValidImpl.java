package co.edu.uco.ucobet.businesslogic.usecase.state.rules.impl;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.businesslogic.usecase.state.rules.NameConsistencyIsValid;
import co.edu.uco.ucobet.crosscutting.exceptions.BusinessLogicUcoBetException;
import co.edu.uco.ucobet.crosscutting.exceptions.DataUcoBetException;

public class CityNameConsistencyIsValidImpl implements NameConsistencyIsValid {

	@Override
	public void execute(String data) {
		// TODO Auto-generated method stub
		
	}
	
	private void validateLen(final String data) {
		if (!TextHelper.maxLenIsValid(data,50)) {
			var userMenssage = "El nombre de la ciudad puede contener maximo 50 caracteres...";
			
			throw BusinessLogicUcoBetException.crear(userMenssage);
		}
	}
	
	private void validateFormat(final String data) {
		if (!TextHelper.containsOnlyLettersAndSpaces(data)) {
			var userMenssage = "El nombre de la ciudad solo puede tener letras y espacios...";
			throw BusinessLogicUcoBetException.crear(userMenssage);
		}
	}
	private void validateNotNull(final String data) {
		if (!TextHelper.isEmpty(data)) {
			var userMenssage = "El nombre de la ciudad no puede estar vacio...";
			throw BusinessLogicUcoBetException.crear(userMenssage);
		}
	}
	
}
