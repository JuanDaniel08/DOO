package co.edu.uco.ucobet.data.dao.impl.sql;

import java.sql.Connection;

import co.edu.uco.crosscutting.helpers.SqlConnectionHelper;
import co.edu.uco.ucobet.crosscutting.exceptions.DataUcoBetException;

public class SqlDAO {
	
	private Connection connection;
	
	protected SqlDAO(final Connection connection) {
		setConnection(connection);
	}
	
	protected Connection getConnection() {
		return connection;
	}
	
	private void setConnection(final Connection connection) {
		validateIfConnetionIsOpen(connection);
		this.connection = connection;
	}
	
	private void validateIfConnetionIsOpen(final Connection connection) {
		if(!SqlConnectionHelper.connectionIsOpen(connection)) {
			var userMenssage = "Se a presentado un problema inesperado tratando de llevar a cabo la operación deseada...";
			var technicalMessage="No es posible crear un acceso a datos de tipo SQL con una conexión nula o cerrada...";
			throw DataUcoBetException.crear(userMenssage, technicalMessage);
		}
	}
}