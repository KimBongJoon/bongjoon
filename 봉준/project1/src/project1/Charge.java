package project1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

// ��,��� ��û
public class Charge extends JFrame {

	FakeMain fake = null;
	ArrayList userMoney = new ArrayList<>();	// ����ڵ� �����ݾ� ����Ʈ
	ArrayList userId = new ArrayList<>();
	int balance = 0;	// �ܾ�
	Calendar now = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd(E) HH:mm:ss");
	String date = sdf.format(now.getTime());
	int cnt = 1;

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
			try {	// �Աݳ��� ���Ϸ� ����
				FileWriter file = new FileWriter(fake.memberId + " " + cnt + " deposit.txt");
				file.write(money + "����Ʈ �Ա�\r\n");
				file.write(date);
				file.flush();
				file.close();
				cnt++;
			} catch (IOException e) {
				e.printStackTrace();
			}

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
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(id); 
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
				ps.setInt(1, balance - money);	// �ܾ� - ��� �ݾ��� ����
				ps.setString(2, fake.memberId);			
				ps.executeUpdate();

				JOptionPane.showMessageDialog(null, "��� �Ϸ� / �ܾ� : " + (balance - money) + "����Ʈ");
				try {	// ��ݳ��� ���Ϸ� ����
					FileWriter file = new FileWriter(fake.memberId + " " + cnt + " Withdrawal.txt");
					file.write(money + "����Ʈ ���\r\n");
					file.write(date);
					file.flush();
					file.close();
					cnt++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "�ܾ� ���� / �ܾ� : " + balance + "����Ʈ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void details() {		// ��,��ݳ��� Ŭ����
		
		setSize(500, 500);
		
		
		String[] file = new File("D:\\bongjoon\\project1").list();	// ������ġ�� �ִ� ���� ���� �˻�
		ArrayList list = new ArrayList<>();
		
		for(int i=0; i<file.length; i++) {
			if(file[i].startsWith(fake.memberId)) {		// member ���̵�� ���۵Ǵ� ���ϸ� ��������
				list.add(file[i]);
			}
		}

		// ���̺� ����
		String[] title = {"��/��� ����", "�ð�"};
		String[][] content = new String[list.size()][3];
		
		for(int i=0; i<content.length; i++) {
			try {
				Scanner sc = new Scanner(new File((String) list.get(i)));
				content[i][0] = sc.nextLine();	// ��,��� ����
				content[i][1] = sc.nextLine();	// �ð�
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}
		
		JTable table = new JTable(content, title);
		JScrollPane scroll = new JScrollPane(table);	
		getContentPane().add(scroll);
		
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		
		setVisible(true);
		
	}

}
