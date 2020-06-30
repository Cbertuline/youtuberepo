package controller;

import java.util.List;
import model.Error;
import model.user;
import model.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/validate.do")

public class ValidateServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String mail;
		String pass;
		DAO dao = new DAO();

		mail = request.getParameter("txtMail");
		pass = request.getParameter("txtPass");

		user u = new user(mail, pass);
		user user2 = dao.exist(u);
		
		HttpSession session = request.getSession();
		if (user2.errorExist()) {
			// enviar a error.view (lista errores)
			List<Error> errors = user2.getErrors();
			session.setAttribute("errors", errors);
			request.getRequestDispatcher("error.view").forward(request, response);
		} else {
			// menu
			session.setAttribute("user", user2);
			request.getRequestDispatcher("menu.view").forward(request, response);
		}
	}

	private static final long serialVersionUID = 1L;

	public ValidateServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}
}