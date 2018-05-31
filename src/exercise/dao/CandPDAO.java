package exercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exercise.bean.CandPBean;

public class CandPDAO {
	private Connection con;

	public CandPDAO(){
		getConnection();
	}

	public List<CandPBean> selectUser(String name,String pass) {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM userinfo WHERE name = ? and pass = ?";
			st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, pass);
			rs = st.executeQuery();

			List<CandPBean> account = new ArrayList<CandPBean>(); // ArrayListクラスのインスタンス化

			// DBからアカウントの情報を取得
			while(rs.next()) { //
				String userName = rs.getString("name"); // DBで取得したデータをString型の変数に代入
				String userPass = rs.getString("pass");
				int userCode = rs.getInt("code");
				String userFavomem = rs.getString("favomember");
				String userBirth = rs.getString("Birthday");

				CandPBean cpBean = new CandPBean(userName,userPass,userCode,userFavomem,userBirth);
				account.add(cpBean);
			}

			rs.close(); // メモリの使用を終了する
			st.close();
			con.close();

			return account;

		}catch(Exception e) { // 例外処理
			e.printStackTrace();
			System.out.println("データの取得に失敗しました。");
		}
			return null;
	}

	public int addAc(String name,String pass,String Birthday) {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			// DBに追加
			String sql = "INSERT INTO userinfo(name,pass,Birthday)VALUES(?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, name); // VALUESに代入（数字は1つ目、2つ目という意味で使用）
			st.setString(2, pass);
			st.setString(3, Birthday);
			int rows = st.executeUpdate();

			st.close();
			con.close();

			return rows;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("レコードの操作に失敗しました。");
		}
		return 0;
	}



	public int delUser(int code) {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		try {

			String sql = "DELETE FROM userinfo WHERE code=?";
			st = con.prepareStatement(sql);
			st.setInt(1, code);
			int rows = st.executeUpdate();

			return rows;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("レコードの操作に失敗しました。");
		}
		return 0;
	}



	private void getConnection() {

		try {
			// DBの登録
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/training?serverTimezone=UTC&useSSL=false";
			String name = "root";
			String pass = "sht30";

			con = DriverManager.getConnection(url,name,pass);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データベースへの接続に失敗しました。");
		}
	}
}

