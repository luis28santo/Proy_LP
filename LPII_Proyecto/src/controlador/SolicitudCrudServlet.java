package controlador;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SolicitudDAO;
import entidad.Solicitud;
import fabricas.Fabrica;

@WebServlet("/SolicitudCrud")
public class SolicitudCrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("ACCION");
		if (accion.equals("INSERTAR")) {
			registrar(request, response);
		} else if (accion.equals("MODIFICAR")) {
			modificar(request, response);
		} else if (accion.equals("ELIMINAR")) {
			eliminar(request, response);
		} else if (accion.equals("LISTAR")) {
			listado(request, response);
		}
	}

	private void listado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String listar = request.getParameter("LISTA");
		Fabrica subFabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		SolicitudDAO dao = subFabrica.getSolicitudDAO();
		
		List<Solicitud> lista = dao.listSolicitud(listar+"%");
		request.setAttribute("SOLICITUD", lista);
		request.getRequestDispatcher("/ReporteSolicitud.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// parametros
			String id = request.getParameter("codigo");

			Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
			SolicitudDAO dao = fabrica.getSolicitudDAO();

			int s = dao.eliminaSolicitud(Integer.parseInt(id));
			if (s > 0) {
				List<Solicitud> lista = dao.listSolicitud("%");
				request.setAttribute("SOLICITUD", lista);
				request.setAttribute("mensaje", "Eliminado Correctamente");

			} else {
				request.setAttribute("mensaje", "Error al Eliminar");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("mensaje", "Error al Eliminar");
		}finally {
			request.getRequestDispatcher("/ReporteSolicitud.jsp").forward(request, response);
		}
	}

	private void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// parametros
			String id = request.getParameter("codigo");
			String app = request.getParameter("apli");
			String descrip = request.getParameter("descripcion");
			String area = request.getParameter("area");
			String fecha = request.getParameter("fecha");
			String estado = request.getParameter("estado");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// crear objeto
			Solicitud objS = new Solicitud();
			objS.setCodigo(Integer.parseInt(id));
			objS.setApp(app);
			objS.setDescripcion(descrip);
			objS.setArea(area);
			objS.setFechaEmi(new Date(sdf.parse(fecha).getTime()));
			objS.setEstado(estado);

			Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
			SolicitudDAO dao = fabrica.getSolicitudDAO();

			int s = dao.actualizaSolicitud(objS);
			if (s > 0) {
				List<Solicitud> lista = dao.listSolicitud("%");
				request.setAttribute("SOLICITUD", lista);
				request.setAttribute("mensaje", "Eliminado Correctamente");
			} else {
				request.setAttribute("mensaje", "Error en la Aprobacion");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("mensaje", "Error Envio");
		}finally {
			request.getRequestDispatcher("/ReporteSolicitud.jsp").forward(request, response);
		}

	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			// parametros
			String app = request.getParameter("apli");
			String descrip = request.getParameter("descripcion");
			String area = request.getParameter("area");
			String fecha = request.getParameter("fecha");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// crear objeto
			Solicitud objS = new Solicitud();
			objS.setApp(app);
			objS.setDescripcion(descrip);
			objS.setArea(area);
			objS.setFechaEmi(new Date(sdf.parse(fecha).getTime()));

			Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
			SolicitudDAO dao = fabrica.getSolicitudDAO();

			int s = dao.insertaSolicitud(objS);
			if (s > 0) {
				request.setAttribute("mensaje", "Envioado Correctamente");
				request.getRequestDispatcher("/ReporteSolicitud.jsp").forward(request, response);
			} else {
				request.setAttribute("mensaje", "Error Envio");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("mensaje", "Error Envio");
		}

	}

}
