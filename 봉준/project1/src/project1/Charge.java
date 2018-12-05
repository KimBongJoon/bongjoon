package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Charge {
	
	public void deposit() {		// 입금신청 클릭시
		int money = Integer.parseInt(JOptionPane.showInputDialog("충전하실 금액을 입력하세요"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");
			
			String sql = "update charge set deposit = ? where member_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, money);
			
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void withdrawal() {		// 출금신청 클릭시
		System.out.println("출금");
	}
	
	public void details() {		// 입/출금내역 클릭시
		System.out.println("입/출금내역");
	}
	
}
