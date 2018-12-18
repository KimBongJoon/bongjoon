package project1;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LadderGame extends JFrame{
	
	static String result = null;
	static int betMoney = 0;
	
	FakeMain fake = null;
	ArrayList userMoney = new ArrayList<>();	// ����ڵ� �����ݾ� ����Ʈ
	ArrayList userId = new ArrayList<>();
	int balance = 0;

	MyT red = new MyT("red.png", 257, 240);   // �������� ������
	private JTextField textField;

	class MyT extends Thread {

		int x,y;
		JLabel lb;

		public MyT(String img, int x, int y) {   // ������ x�� y��

			this.x = x;
			this.y = y;

			lb = new JLabel();
			ImageIcon icon = new ImageIcon(img);
			lb.setIcon(icon);
			lb.setBounds(x, y,13,13);
			add(lb);

		}

		Random r = new Random();

		@Override
		public void run() {   // ������ �޼ҵ�
			int random = r.nextInt(2);   // 0�� 1 (����, ������)�����ϳ� ����
			if(random == 0) {      // 0�ϰ�� (���ʿ��� ����)
				for (int a = 0; a < 7; a++) {
					if(a == 0) {   // (����)ù��° ĭ�̵�
						for (y = 274; y <= 321; y++) {
							lb.setBounds(257,y,13,13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 1) {   // (����)�ι�° ĭ�̵�
						for (x = 257; x <= 425; x++) {
							lb.setBounds(x, 321, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 2) {   // (����)����° ĭ�̵�
						for (y = 321; y <= 341; y++) {
							lb.setBounds(425,y,13,13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 3) {   // (����)�׹�° ĭ�̵�
						for (x = 425; x >= 257; x--) {
							lb.setBounds(x, 341, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 4) {   // (����)�ټ���°ĭ�̵�
						for (y = 341; y <= 361; y++) {
							lb.setBounds(257,y,13,13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 5) {   // (����)������°ĭ�̵�
						for (x = 257; x <= 425; x++) {
							lb.setBounds(x, 361, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(a == 6) {   // (����)�ϰ���°ĭ�̵�
						for (y = 361; y <= 412; y++) {
							lb.setBounds(425, y, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
				JOptionPane.showMessageDialog(null, "����� [¦] �Դϴ�");
				if(result.equals("¦")) {
					JOptionPane.showMessageDialog(null, "�����մϴ�! ��÷�ݾ��� " + (int)(betMoney * 1.75) + "����Ʈ�Դϴ�");
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
						ps.setInt(1, (int) (balance + betMoney * 1.75));	// �ܾ� + ���� �ݾ��� ����
						ps.setString(2, fake.memberId);			
						ps.executeUpdate();
						balance = (int) (balance + betMoney * 1.75);
						textField.setText(String.valueOf(balance));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			else if(random == 1) {   // 1�ϰ�� (�����ʿ��� ����)
				for (int b = 0;  b < 7; b++) {
					if(b == 0) {   // (������)ù��° ĭ�̵�
						for (y = 274; y <= 321; y++) {
							lb.setBounds(425, y, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 1) {   // (������)�ι�° ĭ�̵�
						for (x = 425;  x >= 257; x--) {
							lb.setBounds(x, 321, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 2) {   // (������)����° ĭ�̵�
						for (y = 321; y <= 341; y++) {
							lb.setBounds(257, y, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 3) {   // (������)�׹�° ĭ�̵�
						for (x = 257;  x <= 425; x++) {
							lb.setBounds(x, 341, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 4) {   // (������)�ټ���° ĭ�̵�
						for (y = 341; y <= 361; y++) {
							lb.setBounds(425, y, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 5) {   // (������)������° ĭ�̵�
						for (x = 425;  x >= 257; x--) {
							lb.setBounds(x, 361, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(b == 6) {   // (������)�ϰ���° ĭ�̵�
						for (y = 361; y <= 412; y++) {
							lb.setBounds(257, y, 13, 13);
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
				JOptionPane.showMessageDialog(null, "����� [Ȧ] �Դϴ�");
				if(result.equals("Ȧ")) {
					JOptionPane.showMessageDialog(null, "�����մϴ�! ��÷�ݾ��� " + (int)(betMoney * 1.75) + "����Ʈ�Դϴ�");
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
						ps.setInt(1, (int) (balance + betMoney * 1.75));	// �ܾ� + ���� �ݾ��� ����
						ps.setString(2, fake.memberId);			
						ps.executeUpdate();
						balance = (int) (balance + betMoney * 1.75);
						textField.setText(String.valueOf(balance));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	public LadderGame () {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");

			String id = "select * from charge";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(id); 
			while(rs.next()) {
				userId.add(rs.getString(1));
				userMoney.add(rs.getInt(2));	
			}
			for(int i=0; i<userId.size(); i++) {
				if(userId.get(i).equals(fake.memberId)) {	// �α����� ���̵��� DB�� ����� ����Ʈ ������
					balance = (int)userMoney.get(i);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("��ٸ�����");
		setSize(730, 700);   // ȭ�������
		getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\uBCF4\uC720\uC911\uC778 \uD3EC\uC778\uD2B8");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("HY������B", Font.PLAIN, 17));
		label_1.setBounds(172, 600, 175, 45);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setText(String.valueOf(balance));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("HY������B", Font.PLAIN, 17));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(255, 204, 153));
		textField.setBounds(350, 593, 175, 58);
		getContentPane().add(textField);
		
		JButton button = new JButton("Start");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = JOptionPane.showInputDialog(null, "[Ȧ/¦] ����� �Է��ϼ���");
				betMoney = Integer.parseInt(JOptionPane.showInputDialog(null, "�����Ͻ� �ݾ��� �Է��ϼ���"));		
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BJH", "root", "1234");
					if(balance > betMoney) {
						String sql = "update charge set deposit = ? where member_id = ?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, balance - betMoney);	// �ܾ� - ���ñݾ� ����
						ps.setString(2, fake.memberId);			
						ps.executeUpdate();
						balance = balance - betMoney;
						textField.setText(String.valueOf(balance));		// ����Ʈ ���ΰ�ħ
						button.setEnabled(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "����Ʈ�� �����մϴ�");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				textField.setText(String.valueOf(balance));		// ����Ʈ ���ΰ�ħ
				button.setEnabled(false);
				red.start();
			}
		});
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("HY������B", Font.BOLD, 15));
		button.setBackground(new Color(230, 230, 250));
		button.setBounds(212, 215, 267, 50);
		getContentPane().add(button);
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\ladder.png"));
		label.setBounds(0, 0, 714, 567);
		getContentPane().add(label);

		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);

		setVisible(true);

	}

	public static void main(String[] args) {
		new LadderGame();
	}
}