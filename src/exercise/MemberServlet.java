package exercise;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		String action = request.getParameter("action");

		String memName = null;
		int memHeight = 0;
		String memBirth = null;
		String memBlood = null;

		try {
			Class.forName("com.maysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/training?serverTimezone=UTC&useSSL=false";
			String name = "root";
			String pass = "sht30";

			Connection con = DriverManager.getConnection(url,name,pass);

			String sql = "SELECT * FROM member";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				memName = rs.getString("name");
				memHeight = rs.getInt("height");
				memBirth = rs.getString("birthday");
				memBlood = rs.getString("bloodtype");
			}

			st.close();
			rs.close();
			con.close();

			HttpSession session = request.getSession();
			session.setAttribute("member",memName);

			RequestDispatcher rd = request.getRequestDispatcher("/member.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
