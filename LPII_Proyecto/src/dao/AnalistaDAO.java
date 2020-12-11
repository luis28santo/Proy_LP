package dao;

import java.util.List;

import entidad.Analista;
import entidad.Solicitud;

public interface AnalistaDAO {
	public List<Analista> listAllAnalista(String filtro);
	public abstract int registroAnalista(Solicitud objS);
	public abstract int actualizaAnalista(Solicitud objS);
	public abstract int eliminaAnalista(int id);
}
