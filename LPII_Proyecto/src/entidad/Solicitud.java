package entidad;

import java.sql.Date;

public class Solicitud {
	private int codigo;
	private Date fechaEmi;
	private String area,descripcion,app,estado;
	private String usuario;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFechaEmi() {
		return fechaEmi;
	}
	public void setFechaEmi(Date fechaEmi) {
		this.fechaEmi = fechaEmi;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
