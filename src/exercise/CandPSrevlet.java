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
 * Servlet implementation class CandPSrevlet
 */
@WebServlet("/CandPSrevlet")
public class CandPSrevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandPSrevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		// リクエストパラメータの取得
		String action = request.getParameter("action");

		String userName = null;
		String userPass = null;

		// データベースへ接続
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/training?serverTimezone=UTC&useSSL=false";
			String name = "root";
			String pass = "sht30";

			Connection con = DriverManager.getConnection(url,name,pass);

			String sql = "SELECT * FROM userinfo";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			// DBからメンバーの情報を取得
			while(rs.next()) {
			userName = rs.getString("name");
			userPass = rs.getString("pass");
			}

			rs.close();
			st.close();
			con.close();

			if(action.equals("login")) {
				// 入力値の取得
				String yourName = request.getParameter("yourname");
				String yourPass = request.getParameter("pw");

				// 入力値とDB内データの一致確認
				if(yourName.equals(userName)&&yourPass.equals(userPass)) {
					HttpSession session = request.getSession();
					session.setAttribute("okLogin", yourName);

					RequestDispatcher rd = request.getRequestDispatcher("/intopage.jsp");
					rd.forward(request,response);
			}

			}

		} catch (Exception e) {
			System.out.println("データベースの接続に失敗しました。");
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
