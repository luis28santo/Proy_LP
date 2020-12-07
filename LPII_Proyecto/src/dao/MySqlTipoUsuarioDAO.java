package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.TipoUsuario;
import lombok.extern.apachecommons.CommonsLog;
import util.MySqlDBConexion;

@CommonsLog
public class MySqlTipoUsuarioDAO implements TipoUsuarioDAO {

	@Override
	public int insertaTipoUsuario(TipoUsuario obj) {
		int salida = -1;

		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "insert into tipousuario values(null,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getNombre());
			psmt.setString(2, obj.getEstado());
//			log.info(psmt);
			salida = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	@Override
	public int actualizaTipoUsuario(TipoUsuario obj) {
		int salida = -1;

		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "update tipousuario set nombre = ?, estado =? where idTipoUsuario =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getNombre());
			psmt.setString(2, obj.getEstado());
			psmt.setInt(3, obj.getIdTipoUsuario());
//			log.info(psmt);
			salida = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	@Override
	public int eliminaTipoUsuario(int idTipoUsuario) {
		int salida = -1;

		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "delete from tipousuario where idTipoUsuario = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, idTipoUsuario);
//			log.info(psmt);
			salida = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	@Override
	public List<TipoUsuario> listaPorNombre(String filtro) {
		ArrayList<TipoUsuario> salida = new ArrayList<TipoUsuario>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select * from tipousuario where nombre like ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, filtro);
//			log.info(psmt);
			rs = psmt.executeQuery();
			TipoUsuario obj = null;
			while(rs.next()) {
				obj = new TipoUsuario();
				obj.setIdTipoUsuario(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setEstado(rs.getString(3));
				salida.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

}
