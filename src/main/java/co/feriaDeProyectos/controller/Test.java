package co.feriaDeProyectos.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import co.feriaDeProyectos.dao.ProyectoDaoMySQL;

import co.feriaDeProyectos.model.Proyecto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProyectoDaoMySQL proyectoDao;

	/**
	 * Default constructor.
	 */
	public Test() {

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.proyectoDao = new ProyectoDaoMySQL();

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			default:
				listProyectos(request, response);
				break;
			}
		} catch (SQLException e) {

			throw new ServletException(e);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}



	private void listProyectos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		// TODO Auto-generated method stub
		List<Proyecto> listProyectos = proyectoDao.selectAll();
		request.setAttribute("listProyectos", listProyectos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
