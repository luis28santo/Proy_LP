package dao;

import java.util.List;

import entidad.TipoUsuario;

public interface TipoUsuarioDAO {

	public abstract int insertaTipoUsuario(TipoUsuario obj);

	public abstract int actualizaTipoUsuario(TipoUsuario obj);

	public abstract int eliminaTipoUsuario(int idTipoUsuario);

	public abstract List<TipoUsuario> listaPorNombre(String filtro);

}
