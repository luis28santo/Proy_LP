package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Solicitud;
import util.MySqlDBConexion;

public class MySqlSolicitudDAO implements SolicitudDAO{

	@Override
	public int insertaSolicitud(Solicitud objS) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "insert into solicitud values(null,?,?,?,?,'Pendiente',3)";
			pstm = conn.prepareStatement(sql);
			pstm.setDate(1, objS.getFechaEmi());
			pstm.setString(2, objS.getArea());
			pstm.setString(3, objS.getDescripcion());
			pstm.setString(4, objS.getApp());
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception			
			}
		}
		return salida;
	}

	@Override
	public int actualizaSolicitud(Solicitud objS) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "update solicitud set FecEmi_Soli=?,Area_Soli=?,Descrip_Soli=?,App_Soli=?,Est_Soli=?,id_usu=3 where idSolicitud=?";
			pstm = conn.prepareStatement(sql);
			pstm.setDate(1, objS.getFechaEmi());
			pstm.setString(2, objS.getArea());
			pstm.setString(3, objS.getDescripcion());
			pstm.setString(4, objS.getApp());
			pstm.setString(5, objS.getEstado());
			pstm.setInt(6, objS.getCodigo());
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception			
			}
		}
		return salida;
	}

	@Override
	public int eliminaSolicitud(int id) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "delete from solicitud where idSolicitud=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception			
			}
		}
		return salida;
	}

	@Override
	public List<Solicitud> listSolicitud(String filtro) {
		ArrayList<Solicitud> lista = new ArrayList<Solicitud>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select s.idSolicitud, s.FecEmi_Soli,s.Area_Soli,s.Descrip_Soli,s.App_Soli,s.Est_Soli,concat(u.nombres,' ',u.apaterno) as usuario from solicitud s join usuario u on s.id_usu = u.idUsuario where s.Area_Soli like ? and s.Est_Soli='Pendiente'";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro);
			rs= pstm.executeQuery();
			
			Solicitud obj = null;
			while(rs.next()) {
				obj = new Solicitud();
				obj.setCodigo(rs.getInt(1));
				obj.setFechaEmi(rs.getDate(2));
				obj.setArea(rs.getString(3));
				obj.setDescripcion(rs.getString(4));
				obj.setApp(rs.getString(5));
				obj.setEstado(rs.getString(6));
				obj.setUsuario(rs.getString(7));
				lista.add(obj);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception			
			}
		}
		return lista;
	}
	
}
