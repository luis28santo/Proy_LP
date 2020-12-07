package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class MySqlDBConexion {

	// permite el acceso los parámetros del archivo properties
	private static ResourceBundle rb = ResourceBundle.getBundle("database");

	// Accede a las clases del mysqlconnectorXXXX.jar
	static {
		try {
			Class.forName(rb.getString("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Metodo para crear conexiones
	public static Connection getConexion(){
		Connection cn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mantenimientosistemas?serverTimezone=UTC","root","mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;	
	}

}
