package fabricas;

import dao.MySqlSolicitudDAO;
import dao.MySqlTipoUsuarioDAO;
import dao.MySqlUsuarioDAO;
import dao.SolicitudDAO;
import dao.TipoUsuarioDAO;
import dao.UsuarioDAO;

//Es una subfabrica que tiene objetos que acceden
//a la base de datos MYSQL
public class FabricaMysql extends Fabrica {
	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new MySqlUsuarioDAO();
	}
	@Override
	public TipoUsuarioDAO getTipoUsuarioDAO() {
		return new MySqlTipoUsuarioDAO();
	}
	@Override
	public SolicitudDAO getSolicitudDAO() {
		return new MySqlSolicitudDAO();
	}
	


}
