package processor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Listuser;
import model.ToDoList;
import processor.ProcessUser;
import processor.ProcessList;
import processor.ProcessStatus;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Listuser user = new Listuser();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (request.getParameter("option").equals("1")) {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			ProcessUser u = new ProcessUser();
			String message = "";
			if (name == null || name.isEmpty() || password == null || password.isEmpty()) {
				message = "Please enter your name and password to log in";
				request.setAttribute("error", message);
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			} else{ 
				int userid = u.UserLogin(name, password);
				if (userid != 0) {
				ProcessList pl = new ProcessList();
				List<ToDoList> list = null;
				list = pl.getList(userid);
				user.setId(userid);
				session.setAttribute("userId", user.getId());
				session.setAttribute("ToDoList", list);
				request.getRequestDispatcher("/ListManagement.jsp").forward(request, response);
			} else {
				message = "Please enter correct information to log in";
				request.setAttribute("error", message);
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
			}
		} else if (request.getParameter("option").equals("2")) {
			int listId = Integer.parseInt(request.getParameter("listId"));
			ProcessStatus ss = new ProcessStatus();
			String s = ss.GetStatus(listId);
			String status = "";
			if (s.equals("1")) {
				status = "You have completed this task already, congratulations!";
			} else {
				status = "Not complete yet.";
			}
			session.setAttribute("status", status);
			request.getRequestDispatcher("/StatusReport.jsp").forward(request, response);
		} else if (request.getParameter("option").equals("3")) {
			int listId = Integer.parseInt(request.getParameter("listId"));
			ProcessStatus ss = new ProcessStatus();
			String s = ss.GetStatus(listId);
			String done = "";
			if (s.equals("1")) {
				done = "You have done this already!";
			} else {
				ss.updateStatus(listId);
				done = "Done!";
				System.out.println("finished");
			}
			session.setAttribute("done", done);
			request.getRequestDispatcher("/ListManagement.jsp").forward(request, response);
		} else if (request.getParameter("option").equals("4")) {
			ProcessList pl = new ProcessList();
			List<ToDoList> list = null;
			list = pl.getList((int) user.getId());
			session.setAttribute("ToDoList", list);
			request.getRequestDispatcher("/ListManagement.jsp").forward(request, response);
		}else if (request.getParameter("option").equals("5")) {
			ProcessList pl = new ProcessList();
			int userId=Integer.parseInt(request.getParameter("userId"));
			String item=request.getParameter("item");
			int month=Integer.parseInt(request.getParameter("month"));
			int date=Integer.parseInt(request.getParameter("date"));
			int year=Integer.parseInt(request.getParameter("year"));
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(0);
			cal.set(year, month-1, date);;
			Date d = cal.getTime();
			pl.AddItem(userId, item, d);
			request.getRequestDispatcher("/ListAction.jsp").forward(request, response);
		}else if (request.getParameter("option").equals("6")) {
			
			request.getRequestDispatcher("/ListAction.jsp").forward(request, response);
		}

	}
}
