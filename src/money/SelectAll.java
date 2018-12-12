package money;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SelectAll extends JFrame {

	public SelectAll() {
		setSize(400, 400);
		setTitle("모든 회원정보");
		
		BankDAO dao = new BankDAO();
		
		// BankDAO 클래스의 selectInfoAll()에서 반환 값(BankDTO 주소)을 list에 넣어줌
		ArrayList<BankDTO> list = dao.selectInfoAll();	
		
		String[] col = {"아이디", "이름", "나이", "연락처"};	// 테이블의 칼럼 초기화
		String[][] row = new String[list.size()][col.length];	// 테이블의 로우 초기화
		
		JTable table = new JTable(row, col);
		JScrollPane scroll = new JScrollPane(table);	// 스크롤에 테이블 붙여줌
		
		for (int i = 0; i < list.size(); i++) {	// 각 로우, 칼럼에 해당 데이터 set
			row[i][0] = list.get(i).getId();
			row[i][1] = list.get(i).getName();
			row[i][2] = list.get(i).getAge();
			row[i][3] = list.get(i).getTel();
		}
		
		add(scroll);
		pack();	// 테이블을 창 크기에 맞춰줌
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SelectAll();
	}

}
