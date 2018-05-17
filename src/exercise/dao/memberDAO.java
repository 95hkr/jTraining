package exercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				String memName = rs.getString("name"); // DBで取得したデータをString型の変数に代入
				int memHeight = rs.getInt("height");
				String memBirth = rs.getString("birthday");
				String memBlood = rs.getString("bloodtype");

				MemberBean mbean = new MemberBean(memName,memHeight,memBirth,memBlood);
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
