package coinSing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CoinSing implements ActionListener{

	static JButton[] btn = new JButton[15];
	static MainMachine main = new MainMachine();
	static Login log = new Login();
	static RoomMachine room = new RoomMachine();

	public static void main(String[] args) {
		
		
		System.out.println("���̵�� ��й�ȣ�� �Է��ϼ���.");
		main.member("kbj0626", "1234");
		main.insert(10000);

		JFrame fr = new JFrame();
		fr.setTitle("���γ뷡��");
		fr.setSize(700, 700);
		GridLayout grid = new GridLayout(3, 5, 0, 100);
		fr.setLayout(grid);

		CoinSing c = new CoinSing();
		for(int i=0; i<btn.length; i++) {
			btn[i] = new JButton(i+1 + "�� ��");
			fr.add(btn[i]);
			btn[i].addActionListener(c);
		}

		fr.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<btn.length; i++) {
			if(btn[i] == e.getSource()) {
				int yesNo = JOptionPane.showConfirmDialog(null, i+1 + "�� ���� �����Ͻðڽ��ϱ�?", null, JOptionPane.YES_NO_OPTION);
				if(yesNo == 0) {
					room.roomCoin = Integer.parseInt(JOptionPane.showInputDialog("����� ���μ��� �Է��ϼ���."));
					int remainCoin = main.coin - room.roomCoin;
					System.out.println("���� ���� �� : " + remainCoin);
					btn[i].setEnabled(false);
				}
			}
		}

	}

}
