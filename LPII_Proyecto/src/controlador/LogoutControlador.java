package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletLogout
 */
@WebServlet("/logout")
public class LogoutControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Se obtiene la session
		HttpSession session = request.getSession();
		
		//Se destruye la sesi�n
		session.invalidate();
		
		//elimina los elementos del cache del browser
		response.setHeader("Cache-control", "no-cache");
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "no-cache");

		//se envia un mensaje al login.jsp
		String mensaje = "El usuario sali� de sesi�n";
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}




