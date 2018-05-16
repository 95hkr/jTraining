package exercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandPDAO {
	private Connection con;

	public CandPDAO(){
		getConnection();
	}

	public List<String> findAll() {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM userinfo"; // userinfoテーブルの表示を変数sqlに代入
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			List<String> account = new ArrayList<String>(); // ArrayListクラスのインスタンス化

			// DBからアカウントの情報を取得
			while(rs.next()) { //
				String userName = rs.getString("name"); // DBで取得したデータをString型の変数に代入
				String userPass = rs.getString("pass");

				account.add(userName); // DBで取得したデータを配列に格納
				account.add(userPass);
			}

			rs.close(); // メモリの使用を終了する
			st.close();
			con.close();

			return account;

		}catch(Exception e) { // 例外処理
			e.printStackTrace();
			System.out.println("データの取得に失敗しました。");
		}
	}

	public List<String> selectUser(String name,String pass) {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM userinfo WHERE name = ? and pass = ?"; //
			st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, pass);
			rs = st.executeQuery();

			List<String> account = new ArrayList<String>(); // ArrayListクラスのインスタンス化

			// DBからアカウントの情報を取得
			while(rs.next()) { //
				String userName = rs.getString("name"); // DBで取得したデータをString型の変数に代入
				String userPass = rs.getString("pass");

				account.add(userName); // DBで取得したデータを配列に格納
				account.add(userPass);
			}

			rs.close(); // メモリの使用を終了する
			st.close();
			con.close();

			return account;

		}catch(Exception e) { // 例外処理
			e.printStackTrace();
			System.out.println("データの取得に失敗しました。");
		}
	}

	public int addAc(String name,String pass) {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			// DBに追加
			String sql = "INSERT INTO userinfo(name,pass)VALUES(?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, name); // VALUESに代入（数字は1つ目、2つ目という意味で使用）
			st.setString(2, pass);
			int rows = st.executeUpdate();

			st.close();
			con.close();

			return rows;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("レコードの操作に失敗しました。");
		}
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

