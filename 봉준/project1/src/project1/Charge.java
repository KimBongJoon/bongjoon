package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Charge {
	
	public void deposit() {		// �Աݽ�û Ŭ����
		int money = Integer.parseInt(JOptionPane.showInputDialog("�����Ͻ� �ݾ��� �Է��ϼ���"));
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
	
	public void withdrawal() {		// ��ݽ�û Ŭ����
		System.out.println("���");
	}
	
	public void details() {		// ��/��ݳ��� Ŭ����
		System.out.println("��/��ݳ���");
	}
	
}
