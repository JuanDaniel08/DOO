package co.edu.uco.ucobet.businesslogic.facade.city.impl;

import co.edu.uco.ucobet.businesslogic.adapter.dto.CityDTOAdapter;
import co.edu.uco.ucobet.businesslogic.facade.city.RegisterNewCityFacade;
import co.edu.uco.ucobet.businesslogic.usecase.city.impl.RegisterNewCityImpl;
import co.edu.uco.ucobet.crosscutting.exceptions.BusinessLogicUcoBetException;
import co.edu.uco.ucobet.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.data.dao.enums.DAOSource;
import co.edu.uco.ucobet.dto.CityDTO;

public class RegisterNewCityFacadeImpl implements RegisterNewCityFacade{

	

	@Override
	public void execute(CityDTO data) {
var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try  {
			factory.initTransaction();
			var registerNewCityUseCase = new RegisterNewCityImpl(factory);
			var cityDomain = CityDTOAdapter.getCityDTOAdapter().adaptSource(data);
			
			registerNewCityUseCase.execute(null);
			
			factory.commitTransaction();
		} catch(final UcoBetException exception) {
			factory.rollbackTransaction();
			throw exception;
		}catch(final Exception exception) {
			factory.rollbackTransaction();
			var userMenssage ="Se a presentado un problema tratando de registar la informaciòn de la nueva ciudad...";
			var technicalMenssage ="un problema inesperado registrado la informaciòn de la nueva ciudad. Por favor revise el log de errores para tener mas detalles...";
			
			throw BusinessLogicUcoBetException.crear(userMenssage, technicalMenssage, exception);
		}finally {
			factory.closeConnection();
		}
		
	}

	

	

}
