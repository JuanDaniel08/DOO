package co.edu.uco.ucobet.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.ucobet.crosscutting.exceptions.DataUcoBetException;
import co.edu.uco.ucobet.data.dao.CityDAO;
import co.edu.uco.ucobet.data.dao.CountryDAO;
import co.edu.uco.ucobet.data.dao.impl.sql.SqlDAO;
import co.edu.uco.ucobet.entity.CityEntity;
import co.edu.uco.ucobet.entity.CountryEntity;

public final class CitySqlServerDAO extends SqlDAO implements CityDAO {

	protected CitySqlServerDAO(final Connection connection) {
		super(connection);
		
	}

	@Override
	public void create(final CityEntity data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("INSERT INTO City(id, name, state) VAULES (?, ?, ?)");
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			preparedStatement.setObject(1,data.getId());
			preparedStatement.setString(2,data.getName());
			preparedStatement.setObject(3,data.getState().getId());
			
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMenssage = "Se a presentado un problema inesperado tratando de llevar a cabo el registro de la información de un nuevo país. Por favor intente de nuevo, y si el problema persiste reporte la novedad...";
			var technicalMessage="Se a presentado un problema al tratar de registrar la información del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			throw DataUcoBetException.crear(userMenssage, technicalMessage, exception);
		}
		
	}

	@Override
	public void update(CityEntity data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("UPDATE City SET name = ?, state = ? WHERE id = ?");
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			
			preparedStatement.setString(1,data.getName());
			preparedStatement.setObject(2,data.getState().getId());
			preparedStatement.setObject(3,data.getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMenssage = "Se a presentado un problema inesperado tratando de llevar a cabo el registro de la información de un nuevo país. Por favor intente de nuevo, y si el problema persiste reporte la novedad...";
			var technicalMessage="Se a presentado un problema al tratar de registrar la información del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			throw DataUcoBetException.crear(userMenssage, technicalMessage, exception);
		}
		
	}
	
	@Override
	public void delete(UUID data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("DELETE FROM City WHERE id = ?");
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			
			preparedStatement.setObject(1,data);
			
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMenssage = "Se a presentado un problema inesperado tratando de llevar a cabo el registro de la información de un nuevo país. Por favor intente de nuevo, y si el problema persiste reporte la novedad...";
			var technicalMessage="Se a presentado un problema al tratar de registrar la información del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			throw DataUcoBetException.crear(userMenssage, technicalMessage, exception);
		}
		
	}
	
	
	@Override
	public CityEntity findByID(UUID id) {
		
		return null;
	}

	@Override
	public List<CityEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	

	


}
