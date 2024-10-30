package co.edu.uco.ucobet.businesslogic.usecase.city.impl;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.businesslogic.adapter.entity.CityEntityAdapter;
import co.edu.uco.ucobet.businesslogic.usecase.city.UpdateCity;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.domain.CityDomain;

public final class UpdateCityImpl implements UpdateCity{

	private DAOFactory daoFactory;
	
	public UpdateCityImpl(DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}
	
	
	
	@Override
	public void execute(CityDomain data) {
		
		
		
		var cityEntity = CityEntityAdapter.getCityEntityAdapter().adaptTarget(data);
		daoFactory.getCityDAO().update(cityEntity);
	}
	
	private void setDaoFactory(final DAOFactory daoFactory) {
		if(ObjectHelper.isNull(daoFactory)) {
			
		}
		
		this.daoFactory= daoFactory;
	}

}
