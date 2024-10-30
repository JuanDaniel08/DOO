package co.edu.uco.ucobet.data.dao;

import co.edu.uco.ucobet.crosscutting.exceptions.DataUcoBetException;
import co.edu.uco.ucobet.data.dao.enums.DAOSource;
import co.edu.uco.ucobet.data.dao.impl.sql.sqlserver.SqlServerDAOFactory;

public abstract class DAOFactory {

	public final static DAOFactory getFactory(final DAOSource source) {
		
		switch (source) {
		case SQLSERVER:{
			return new SqlServerDAOFactory();
		}
		default:
			var userMenssage = "Se a presentado un problema inesperado tratando de llevar a cabo la operación deseada...";
			var technicalMessage="no existe una factoria implementada para...";
			throw DataUcoBetException.crear(userMenssage, technicalMessage);
		}
		
	}

	protected abstract void openConnection();

	public abstract void initTransaction();

	public abstract void commitTransaction();

	public abstract void rollbackTransaction();

	public abstract void closeConnection();

	public abstract CityDAO getCityDAO();

	public abstract StateDAO getStateDAO();

	public abstract CountryDAO getCountryDAO();

}
