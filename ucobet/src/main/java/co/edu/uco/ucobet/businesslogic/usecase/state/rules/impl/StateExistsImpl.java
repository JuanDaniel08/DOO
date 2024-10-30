package co.edu.uco.ucobet.businesslogic.usecase.state.rules.impl;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.businesslogic.usecase.state.rules.StateExists;
import co.edu.uco.ucobet.crosscutting.exceptions.BusinessLogicUcoBetException;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.entity.StateEntity;

public class StateExistsImpl implements StateExists {

	@Override
	public void execute(UUID data, DAOFactory factory) {
		var state =ObjectHelper.getDefault(factory.getStateDAO().findByID(data), new StateEntity());
		
		if(data.compareTo(state.getId()) !=0)  {
			var userMenssage = "No existe el Departamento con el identidficador "+ data.toString();
			

			throw BusinessLogicUcoBetException.crear(userMenssage);
		}	
	}

}
