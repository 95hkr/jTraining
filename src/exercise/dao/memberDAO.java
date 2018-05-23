package exercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exercise.bean.MemberBean;

public class memberDAO {

	private Connection con;

	public memberDAO() {
		getConnection();
	}
	public List<MemberBean> findAll() {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM member"; // memberテーブルの表示を変数sqlに代入
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			List<MemberBean> lineup = new ArrayList<MemberBean>(); // ArrayListクラスのインスタンス化

			// DBからアカウントの情報を取得
			while(rs.next()) { //
				int memCode = rs.getInt("code");
				String memName = rs.getString("name"); // DBで取得したデータをString型の変数に代入
				int memHeight = rs.getInt("height");
				String memBirth = rs.getString("birthday");
				String memBlood = rs.getString("bloodtype");

				MemberBean mbean = new MemberBean(memCode,memName,memHeight,memBirth,memBlood);
				lineup.add(mbean);
			}

				rs.close(); // メモリの使用を終了する
				st.close();
				con.close();

				return lineup;

			}catch(Exception e) { // 例外処理
				e.printStackTrace();
				System.out.println("データの取得に失敗しました。");
			}
		return null;
	}



	public List<MemberBean> sortBirth(boolean isUp) {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		String sql;

		try {
			if(isUp)
				sql = "SELECT * FROM member ORDER BY birthday";
			else
				sql = "SELECT * FROM member ORDER BY birthday desc";


				st = con.prepareStatement(sql);
				rs = st.executeQuery();

				List<MemberBean> lineup = new ArrayList<MemberBean>();
				while(rs.next()) {
					int memCode = rs.getInt("code");
					String memName = rs.getString("name");
					int memHeight = rs.getInt("height");
					String memBirth = rs.getString("birthday");
					String memBlood = rs.getString("bloodtype");
					MemberBean mbean = new MemberBean(memCode,memName,memHeight,memBirth,memBlood);
					lineup.add(mbean);
				}

				st.close();
				rs.close();
				con.close();

				return lineup;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("レコードの操作に失敗しました。");
		}
		return null;
	}



	public int favoMem(String favoName,int code) {
		if(con == null);
		getConnection();

		PreparedStatement st = null;
		try {
			String sql = "UPDATE userinfo SET favomember=? WHERE code=?";
			st = con.prepareStatement(sql);

			st.setString(1, favoName);
			st.setInt(2, code);

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



	public int nullFavo(int code) {
		if(con == null)
			getConnection();

		PreparedStatement st = null;

		try {
			String sql = "UPDATE userinfo SET favomember=null WHERE code=?";
			st = con.prepareStatement(sql);

			st.setInt(1, code);

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



	private void getConnection(){

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/training?serverTimezone=UTC&useSSL=false";
			String user = "root";
			String pass = "sht30";

			con = DriverManager.getConnection(url,user,pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
