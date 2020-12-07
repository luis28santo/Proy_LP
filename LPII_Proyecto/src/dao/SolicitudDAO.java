package dao;

import java.util.List;

import entidad.Solicitud;

public interface SolicitudDAO {
	public abstract int insertaSolicitud(Solicitud objS);
	public abstract int actualizaSolicitud(Solicitud objS);
	public abstract int eliminaSolicitud(int id);
	public abstract List<Solicitud> listSolicitud(String filtro);
}
