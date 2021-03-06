package fabricas;

import dao.AnalistaDAO;
import dao.DistritoDAO;
import dao.SolicitudDAO;
import dao.TipoUsuarioDAO;
import dao.UsuarioDAO;

//Es una f�brica de objetos
//Se usa el patr�n DAO (Data Access Object)
public abstract class Fabrica {

	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;

	public abstract UsuarioDAO getUsuarioDAO();
	public abstract TipoUsuarioDAO getTipoUsuarioDAO();
	public abstract SolicitudDAO getSolicitudDAO();
	public abstract DistritoDAO getDistritoDAO();
	public abstract AnalistaDAO getAnalistaDAO();

	// Va fabricar subfabricas (Mysql y sqlserver)
	public static Fabrica getFabrica(int tipo) {
		Fabrica salida = null;
		switch (tipo) {
		case MYSQL:
			salida = new FabricaMysql();
			break;

		}
		return salida;
	}
}
