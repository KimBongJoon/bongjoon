package coinSing;

public class MainMachine {

	int coin = 0;
	
	public void member(String id, String pw) {
		if(id.equals("kbj0626") && pw.equals("1234")) {
			System.out.println("ȯ���մϴ�!");
			System.out.println("���� ���� ���� �� : " + coin);
		}
		else {
			System.out.println("���̵� �Ǵ� ��й�ȣ�� �ٸ��ϴ�.");
			System.exit(0);
		}
	}
	
	public void insert(int money) {
		coin = money / 250;
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		System.out.println("���� ���� ���� �� : " + coin);
	}
	
}
