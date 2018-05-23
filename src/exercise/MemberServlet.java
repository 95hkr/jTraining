package exercise;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exercise.bean.MemberBean;
import exercise.dao.memberDAO;

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
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		try {
			String action = request.getParameter("action");

			memberDAO mDao = new memberDAO();

			if(action.equals("group")) {
			List<MemberBean> lineup = mDao.findAll();
			session.setAttribute("member", lineup);

			MemberBean mBean = lineup.get(0);

			String memName = mBean.getMemName();
			int memHeight = mBean.getMemHeight();
			String memBirth = mBean.getMemBirth();
			String memBlood = mBean.getMemBirth();

			session.setAttribute("mName", memName);
			session.setAttribute("mHeight", memHeight);
			session.setAttribute("mBirth", memBirth);
			session.setAttribute("mBlood", memBlood);

			RequestDispatcher rd = request.getRequestDispatcher("/member.jsp");
			rd.forward(request, response);



			} else if(action.equals("sort")) {
				String key = request.getParameter("key");
				List<MemberBean> lineup;
				if(key.equals("memBirth_asc"))
					lineup = mDao.sortBirth(true);
				else
					lineup = mDao.sortBirth(false);

				session.setAttribute("member", lineup);
				RequestDispatcher rd = request.getRequestDispatcher("/member.jsp");
				rd.forward(request, response);



			} else if(action.equals("favo")) { // actionがお気に入りの場合
				int code = (int) session.getAttribute("intoCode"); // ログインしている人のコード
				String favoName = request.getParameter("bName"); // お気に入りのメンバーの名前を取得
				int rows = mDao.favoMem(favoName,code); // 上記をDAOに送る

				if(rows == 1) {
					session.setAttribute("favoMessage", favoName + "をお気に入りに追加しました。");
				}

				RequestDispatcher rd = request.getRequestDispatcher("/member.jsp");
					rd.forward(request, response);



			}else if(action.equals("nullfavo")) {
				int code = (int) session.getAttribute("intoCode");

				int rows = mDao.nullFavo(code);

				if(rows == 1) {
					session.setAttribute("nullmessage", "あなたの選択をお待ちしております。");
				}

				RequestDispatcher rd = request.getRequestDispatcher("/mypage.jsp");
				rd.forward(request, response);



			}else if(action.equals("mInfo")) {
				RequestDispatcher rd = request.getRequestDispatcher("/memberPage.jsp");
				rd.forward(request, response);
			}

		}catch (Exception e) {
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
