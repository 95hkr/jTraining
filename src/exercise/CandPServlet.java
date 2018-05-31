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

import exercise.bean.CandPBean;
import exercise.dao.CandPDAO;

/**
 * Servlet implementation class CandPSrevlet
 */
@WebServlet("/CandPServlet")
public class CandPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8"); //

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		try {
		// リクエストパラメータの取得
		String action = request.getParameter("action");

		CandPDAO cpDao = new CandPDAO(); // CandPDAOクラスをインスタンス化

			if(action.equals("login")) { // actionがlogin（ログイン）の場合、以下の処理を実施

				// ログインフォームの入力値の取得（String型の変数に入力した値を代入）
				String yourName = request.getParameter("yourname");
				String yourPass = request.getParameter("pw");

				List<CandPBean> account = cpDao.selectUser(yourName,yourPass); // 入力値をメソッドに当てはめる

				if(account.size() >= 1) {
					CandPBean cpBean = account.get(0);

					int userCode = cpBean.getCode();

					session.setAttribute("intoName", yourName); // セッションスコープに入れる
					session.setAttribute("intoPass", yourPass);
					session.setAttribute("intoCode", userCode);

					RequestDispatcher rd = request.getRequestDispatcher("/intopage.jsp");
					rd.forward(request, response);

				}else {
					request.setAttribute("message","入館申請をおこなってください。");
					request.setAttribute("error", "Entranceへ");
					RequestDispatcher rd = request.getRequestDispatcher("/errInto.jsp");
					rd.forward(request, response);
				}



			}else if(action.equals("add")) { // actionがadd（追加）の場合、以下の処理を実施
				// 登録フォームの入力値を取得（String型の変数に入力値を代入）
				String newName = request.getParameter("nyourname");
				String newPass = request.getParameter("npw");
				String newBirth = request.getParameter("mybirth");

				// 空欄だった場合
				if(newName.equals("") || newPass.equals("")) {
					RequestDispatcher rd = request.getRequestDispatcher("inputerror.jsp");
					rd.forward(request, response);
					return;
				}
				// CandPDAOクラスのaddAcメソッドに入力値を代入
				cpDao = new CandPDAO(); // CandPDAOクラスをインスタンス化
				int rows = cpDao.addAc(newName, newPass,newBirth); // ???addAcメソッドの入力値を件数に代入???

				// 件数が１だった場合以下の処理を実行
				if(rows == 1) {
					request.setAttribute("setAc", newName + "様の鍵が完成しました。"); // seAcに右の名前や文を入れる、jspで${setAc}と使用する
				// その他の場合以下の処理を実行
				}else {
					request.setAttribute("message", "登録できませんでした。"); // jspで${message}と使用する
				}
				// signok.jspへフォワード
				RequestDispatcher rd = request.getRequestDispatcher("/signok.jsp");
				rd.forward(request,response);



			}else if(action.equals("logout")) {
				session = request.getSession(false);
				if(session != null) {
					session.invalidate();
				}
					RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
					rd.forward(request, response);



			}else if(action.equals("mypg")) { // MyPageメニューを押した場合
				String yourName = (String) session.getAttribute("intoName");
				String yourPass = (String) session.getAttribute("intoPass");

				List<CandPBean> account = cpDao.selectUser(yourName,yourPass);
				CandPBean cpBean = account.get(0);

				String userName = cpBean.getName();
				String userPass = cpBean.getPass();
				String userBirth = cpBean.getBirthday();
				String userFavomem = cpBean.getFavomember();

				session.setAttribute("myname", userName);
				session.setAttribute("mypass", userPass);
				session.setAttribute("mybirth", userBirth);

				if(userFavomem == null) {
					session.setAttribute("myFmem", "あなたの選択をお待ちしております。");
				}else{
					session.setAttribute("myFmem", userFavomem);
				}
				// mypage.jspへ
				RequestDispatcher rd = request.getRequestDispatcher("/mypage.jsp");
				rd.forward(request, response);



			}else if(action.equals("acDele")) {
				int code = (int) session.getAttribute("intoCode");
				int rows = cpDao.delUser(code);

				if(rows == 1) {
					RequestDispatcher rd = request.getRequestDispatcher("/delcomp.jsp");
					rd.forward(request, response);
				}
			}

			// 例外処理
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データの取得に失敗しました。");
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
