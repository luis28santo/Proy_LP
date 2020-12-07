package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipoUsuarioDAO;
import entidad.TipoUsuario;
import fabricas.Fabrica;

@WebServlet("/crudTipoUsuario")
public class TipoUsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String metodo = request.getParameter("metodo");

		if (metodo.equals("INSERTA")) {
			inserta(request, response);
		} else if (metodo.equals("ACTUALIZA")) {
			actualiza(request, response);
		} else if (metodo.equals("ELIMINA")) {
			elimina(request, response);
		} else if (metodo.equals("LISTA")) {
			lista(request, response);
		}
	}

	protected void inserta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String nom = request.getParameter("nombre");
			String est = request.getParameter("estado");

			TipoUsuario obj = new TipoUsuario();
			obj.setNombre(nom);
			obj.setEstado(est);

			Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
			TipoUsuarioDAO dao = fabrica.getTipoUsuarioDAO();

			int salida = dao.insertaTipoUsuario(obj);
			if (salida > 0) {
				List<TipoUsuario> lista = dao.listaPorNombre("%");
				request.getSession().setAttribute("TIPOUSUARIOS", lista);
				request.getSession().setAttribute("MENSAJE", " El registro es exitoso");

			} else {
				request.getSession().setAttribute("MENSAJE", "Error en el registro ");
			}

		} catch (Exception e) {
			request.getSession().setAttribute("MENSAJE", "Error en el registro ");
			e.printStackTrace();
		} finally {
			response.sendRedirect("intranetCrudTipoUsuario.jsp");
		}
	}

	protected void actualiza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("idTipoUsuario");
			String nom = request.getParameter("nombre");
			String est = request.getParameter("estado");

			TipoUsuario obj = new TipoUsuario();
			obj.setIdTipoUsuario(Integer.parseInt(id));
			obj.setNombre(nom);
			obj.setEstado(est);

			Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
			TipoUsuarioDAO dao = fabrica.getTipoUsuarioDAO();

			int salida = dao.actualizaTipoUsuario(obj);
			if (salida > 0) {
				List<TipoUsuario> lista = dao.listaPorNombre("%");
				request.getSession().setAttribute("TIPOUSUARIOS", lista);
				request.getSession().setAttribute("MENSAJE", " El actualizar es exitoso");

			} else {
				request.getSession().setAttribute("MENSAJE", "Error en el actualizar ");
			}

		} catch (Exception e) {
			request.getSession().setAttribute("MENSAJE", "Error en el actualizar ");
			e.printStackTrace();
		} finally {
			response.sendRedirect("intranetCrudTipoUsuario.jsp");
		}
	}

	protected void elimina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String id = request.getParameter("id");

			Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
			TipoUsuarioDAO dao = fabrica.getTipoUsuarioDAO();

			int salida = dao.eliminaTipoUsuario(Integer.parseInt(id));
			if (salida > 0) {
				List<TipoUsuario> lista = dao.listaPorNombre("%");
				request.getSession().setAttribute("TIPOUSUARIOS", lista);
				request.getSession().setAttribute("MENSAJE", " El eliminar es exitoso");

			} else {
				request.getSession().setAttribute("MENSAJE", "Error en el eliminar ");
			}

		} catch (Exception e) {
			request.getSession().setAttribute("MENSAJE", "Error en el eliminar ");
			e.printStackTrace();
		} finally {
			response.sendRedirect("intranetCrudTipoUsuario.jsp");
		}
	}

	protected void lista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filtro = request.getParameter("filtro");

		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		TipoUsuarioDAO dao = fabrica.getTipoUsuarioDAO();

		List<TipoUsuario> lista = dao.listaPorNombre(filtro + "%");
		request.getSession().setAttribute("TIPOUSUARIOS", lista);
		response.sendRedirect("intranetCrudTipoUsuario.jsp");

	}

}
