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

// 입,출금 신청
public class Charge extends JFrame {

	FakeMain fake = null;
	ArrayList userMoney = new ArrayList<>();	// 사용자들 보유금액 리스트
	ArrayList userId = new ArrayList<>();
	int balance = 0;	// 잔액
	Calendar now = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd(E) HH:mm:ss");
	String date = sdf.format(now.getTime());
	int cnt = 1;

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
			try {	// 입금내역 파일로 저장
				FileWriter file = new FileWriter(fake.memberId + " " + cnt + " deposit.txt");
				file.write(money + "포인트 입금\r\n");
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

	public void withdrawal() {		// 출금신청 클릭시

		int money = Integer.parseInt(JOptionPane.showInputDialog("출금하실 금액을 입력하세요"));	// 출금 할 금액 입력

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

			String id = "select * from charge";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(id); 
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
				ps.setInt(1, balance - money);	// 잔액 - 출금 금액을 저장
				ps.setString(2, fake.memberId);			
				ps.executeUpdate();

				JOptionPane.showMessageDialog(null, "출금 완료 / 잔액 : " + (balance - money) + "포인트");
				try {	// 출금내역 파일로 저장
					FileWriter file = new FileWriter(fake.memberId + " " + cnt + " Withdrawal.txt");
					file.write(money + "포인트 출금\r\n");
					file.write(date);
					file.flush();
					file.close();
					cnt++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "잔액 부족 / 잔액 : " + balance + "포인트");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void details() {		// 입,출금내역 클릭시
		
		setSize(500, 500);
		
		
		String[] file = new File("D:\\bongjoon\\project1").list();	// 저장위치에 있는 파일 전부 검색
		ArrayList list = new ArrayList<>();
		
		for(int i=0; i<file.length; i++) {
			if(file[i].startsWith(fake.memberId)) {		// member 아이디로 시작되는 파일만 가져오기
				list.add(file[i]);
			}
		}

		// 테이블 생성
		String[] title = {"입/출금 내역", "시간"};
		String[][] content = new String[list.size()][3];
		
		for(int i=0; i<content.length; i++) {
			try {
				Scanner sc = new Scanner(new File((String) list.get(i)));
				content[i][0] = sc.nextLine();	// 입,출금 내역
				content[i][1] = sc.nextLine();	// 시간
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
