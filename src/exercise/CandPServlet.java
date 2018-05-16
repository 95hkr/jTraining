package exercise;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		try {
		// リクエストパラメータの取得
		String action = request.getParameter("action");

			if(action.equals("login")) { // actionがlogin（ログイン）の場合、以下の処理を実施

				CandPDAO cpDao = new CandPDAO(); // CandPDAOクラスをインスタンス化

				// ログインフォームの入力値の取得（String型の変数に入力した値を代入）
				String yourName = request.getParameter("yourname");
				String yourPass = request.getParameter("pw");

				List<String> account = cpDao.selectUser(yourName,yourPass); // 入力値をメソッドに当てはめる

				if(account.size() >= 1) {
					request.setAttribute("message", "～ " + yourName + "様、ようこそ ～");

				}else {

					request.setAttribute("message","入館申請をおこなってください。");
					request.setAttribute("error", "Entranceへ");
				}

				RequestDispatcher rd = request.getRequestDispatcher("/intopage.jsp");
				rd.forward(request, response);

				// 入力値とDB内データの一致確認[if(入力値.equals(DBのデータ))]
//				if(yourName.equals(acName)&&yourPass.equals(acPass)) {
//					HttpSession session = request.getSession(); // ???
//					session.setAttribute("okLogin", yourName);
//
//					// 上記が一致したら、intopage.jspへフォワード
//					RequestDispatcher rd = request.getRequestDispatcher("/intopage.jsp");
//					rd.forward(request,response);

			}else if(action.equals("add")) { // actionがadd（追加）の場合、以下の処理を実施
				// 登録フォームの入力値を取得（String型の変数に入力値を代入）
				String newName = request.getParameter("nyourname");
				String newPass = request.getParameter("npw");

				// 空欄だった場合
				if(newName.equals("") || newPass.equals("")) {
					RequestDispatcher rd = request.getRequestDispatcher("inputerror.jsp");
					rd.forward(request, response);
					return;
				}

				// CandPDAOクラスのaddAcメソッドに入力値を代入
				CandPDAO cpDao = new CandPDAO(); // CandPDAOクラスをインスタンス化
				int rows = cpDao.addAc(newName, newPass); // ???addAcメソッドの入力値を件数に代入???

				// 件数が１だった場合以下の処理を実行
				if(rows == 1) {
					request.setAttribute("setAc", newName + "様の鍵が完成しました。"); // seAcに右の名前や分を入れる、jspで${setAc}と使用する
				// その他の場合以下の処理を実行
				}else {
					request.setAttribute("message", "登録できませんでした。"); // jspで${message}と使用する
				}
				// signok.jspへフォワード
				RequestDispatcher rd = request.getRequestDispatcher("/signok.jsp");
				rd.forward(request,response);
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