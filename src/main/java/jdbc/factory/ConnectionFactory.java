package jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost/hotelalura?useTimezone=true&serverTimezone=UTC");
		cpds.setUser("root");
		cpds.setPassword("1234");
		
		this.dataSource=cpds;
	}
	
	public Connection recuperarConexion() {
		try {
			return this.dataSource.getConnection();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
