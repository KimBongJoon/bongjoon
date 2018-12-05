package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Charge {

	FakeMain fake = null;
	ArrayList userMoney = new ArrayList<>();	// 사용자들 보유금액 리스트
	ArrayList userId = new ArrayList<>();
	int balance = 0;	// 잔액

	public void deposit() {		// 입금신청 클릭시


		int money = Integer.parseInt(JOptionPane.showInputDialog("충전하실 포인트를 입력하세요"));	// 충전 할 금액 입력

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

			String id = "select * from charge";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(id); 
			while(rs.next()) {
				userId.add(rs.getString(1));
				userMoney.add(rs.getInt(2));	// charge테이블 deposit값
			}
			for(int i=0; i<userId.size(); i++) {
				if(userId.get(i).equals(fake.memberId)) {
					balance = (int)userMoney.get(i);
				}
			}

			String sql = "update charge set deposit = ? where member_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, balance + money);	// 잔액 + 충전 금액을 저장
			ps.setString(2, fake.memberId);			
			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "충전 완료 / 잔액 : " + (money + balance) + "포인트");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void withdrawal() {		// 출금신청 클릭시

		int money = Integer.parseInt(JOptionPane.showInputDialog("출금하실 금액을 입력하세요"));	// 출금 할 금액 입력

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

			String id = "select * from charge";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(id); 
			while(rs.next()) {
				userId.add(rs.getString(1));
				userMoney.add(rs.getInt(2));	// charge테이블 deposit값
			}
			for(int i=0; i<userId.size(); i++) {
				if(userId.get(i).equals(fake.memberId)) {
					balance = (int)userMoney.get(i);
				}
			}

			if(balance > money) {
				String sql = "update charge set deposit = ? where member_id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, balance - money);	// 잔액 + 충전 금액을 저장
				ps.setString(2, fake.memberId);			
				ps.executeUpdate();

				JOptionPane.showMessageDialog(null, "출금 완료 / 잔액 : " + (balance - money) + "포인트");
			}
			else {
				JOptionPane.showMessageDialog(null, "잔액 부족 / 잔액 : " + balance + "포인트");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void details() {		// 입/출금내역 클릭시
		System.out.println("입/출금내역");
	}

}
