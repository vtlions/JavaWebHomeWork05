package itea.web06;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	private static final long serialVersionUID = -9071757192018689176L;

	String formLogin = "<html><center>\r\n" + "		   <form action=\"\" method='post'>\r\n"
			+ "		   <table border=\"0\">\r\n" + "		      <tr>\r\n"
			+ "		         <td width=\"100\">Login</td>\r\n"
			+ "		         <td ><input type=\"text\" name=\"login\" /></td>\r\n" + "		      </tr>\r\n"
			+ "		      <tr>\r\n" + "		         <td>Password</td>\r\n"
			+ "		         <td><input type=\"text\" name=\"password\" /></td>\r\n" + "		      </tr>\r\n"
			+ "		      <tr>\r\n"
			+ "		         <td align=\"center\" colspan=\"2\"><input type=\"submit\" value=\"Send\" /></td>\r\n"
			+ "		      </tr>\r\n" + "\r\n" + "		   </table>\r\n" + "		   </form></center></html>";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.write(Menu.MENU);
		out.write(formLogin);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if (login != null) {
			if ("admin".equals(login) && "123".equals(password)) {
				out.write("Access granted");
			} else {
				out.write("Access denied");
				doGet(request, response);

			}
		}
	}
}
