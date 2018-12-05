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
	ArrayList userMoney = new ArrayList<>();	// ����ڵ� �����ݾ� ����Ʈ
	ArrayList userId = new ArrayList<>();
	int balance = 0;	// �ܾ�

	public void deposit() {		// �Աݽ�û Ŭ����


		int money = Integer.parseInt(JOptionPane.showInputDialog("�����Ͻ� ����Ʈ�� �Է��ϼ���"));	// ���� �� �ݾ� �Է�

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

			String id = "select * from charge";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(id); 
			while(rs.next()) {
				userId.add(rs.getString(1));
				userMoney.add(rs.getInt(2));	// charge���̺� deposit��
			}
			for(int i=0; i<userId.size(); i++) {
				if(userId.get(i).equals(fake.memberId)) {
					balance = (int)userMoney.get(i);
				}
			}

			String sql = "update charge set deposit = ? where member_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, balance + money);	// �ܾ� + ���� �ݾ��� ����
			ps.setString(2, fake.memberId);			
			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "���� �Ϸ� / �ܾ� : " + (money + balance) + "����Ʈ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void withdrawal() {		// ��ݽ�û Ŭ����

		int money = Integer.parseInt(JOptionPane.showInputDialog("����Ͻ� �ݾ��� �Է��ϼ���"));	// ��� �� �ݾ� �Է�

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

			String id = "select * from charge";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(id); 
			while(rs.next()) {
				userId.add(rs.getString(1));
				userMoney.add(rs.getInt(2));	// charge���̺� deposit��
			}
			for(int i=0; i<userId.size(); i++) {
				if(userId.get(i).equals(fake.memberId)) {
					balance = (int)userMoney.get(i);
				}
			}

			if(balance > money) {
				String sql = "update charge set deposit = ? where member_id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, balance - money);	// �ܾ� + ���� �ݾ��� ����
				ps.setString(2, fake.memberId);			
				ps.executeUpdate();

				JOptionPane.showMessageDialog(null, "��� �Ϸ� / �ܾ� : " + (balance - money) + "����Ʈ");
			}
			else {
				JOptionPane.showMessageDialog(null, "�ܾ� ���� / �ܾ� : " + balance + "����Ʈ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void details() {		// ��/��ݳ��� Ŭ����
		System.out.println("��/��ݳ���");
	}

}
