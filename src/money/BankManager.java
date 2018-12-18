package money;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class BankManager extends JFrame implements ActionListener {
	private JTextField id;
	private JTextField name;
	private JTextField age;
	private JTextField tel;

	private JButton btnNewButton; // 회원정보 입력
	private JButton btnNewButton_1; // 회원정보 삭제
	private JButton btnNewButton_2; // 회원정보 수정
	private JButton btnNewButton_3; // 회원정보 검색
	private JButton btnNewButton_4; // 모든 회원정보 검색

	public BankManager() {
		setSize(300, 400);
		setTitle("은행 고객 관리 시스템");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 33, 57, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(12, 85, 57, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uB098\uC774");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(12, 136, 57, 15);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC5F0\uB77D\uCC98");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(12, 189, 57, 15);
		getContentPane().add(lblNewLabel_3);

		id = new JTextField();
		id.setBounds(95, 30, 165, 21);
		getContentPane().add(id);
		id.setColumns(10);

		name = new JTextField();
		name.setBounds(95, 82, 164, 21);
		getContentPane().add(name);
		name.setColumns(10);

		age = new JTextField();
		age.setBounds(95, 133, 165, 21);
		getContentPane().add(age);
		age.setColumns(10);

		tel = new JTextField();
		tel.setBounds(95, 186, 165, 21);
		getContentPane().add(tel);
		tel.setColumns(10);

		btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.setBounds(28, 233, 107, 23);
		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btnNewButton_1.setBounds(153, 233, 107, 23);
		getContentPane().add(btnNewButton_1);

		btnNewButton_2 = new JButton("\uC815\uBCF4\uC218\uC815");
		btnNewButton_2.setBounds(28, 274, 107, 23);
		getContentPane().add(btnNewButton_2);

		btnNewButton_3 = new JButton("\uD68C\uC6D0\uAC80\uC0C9");
		btnNewButton_3.setBounds(153, 274, 107, 23);
		getContentPane().add(btnNewButton_3);

		btnNewButton_4 = new JButton("\uBAA8\uB4E0 \uD68C\uC6D0\uC815\uBCF4 \uAC80\uC0C9");
		btnNewButton_4.setBounds(28, 314, 232, 23);
		getContentPane().add(btnNewButton_4);

		btnNewButton.addActionListener(this); // 회원정보 입력
		btnNewButton_1.addActionListener(this); // 회원정보 삭제
		btnNewButton_2.addActionListener(this); // 회원정보 수정
		btnNewButton_3.addActionListener(this); // 회원정보 검색
		btnNewButton_4.addActionListener(this); // 모든 회원정보 검색

		setVisible(true);
	}

	public static void main(String[] args) {
		new BankManager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BankDTO dto = new BankDTO();
		BankDAO dao = new BankDAO();

		// 회원정보 입력
		if (e.getSource() == btnNewButton) {
			dto.setId(id.getText());
			dto.setName(name.getText());
			dto.setAge(age.getText());
			dto.setTel(tel.getText());

			dao.insertInfo(dto);
			JOptionPane.showMessageDialog(null, "회원가입 완료!");
		}

		// 회원정보 삭제
		if (e.getSource() == btnNewButton_1) {
			dao.deleteInfo(id.getText());
			JOptionPane.showMessageDialog(null, id.getText() + "님의 회원정보가 삭제 되었습니다.");
		}

		// 회원정보 수정
		if (e.getSource() == btnNewButton_2) {
			dto.setId(id.getText());
			dto.setTel(tel.getText());

			dao.updateInfo(dto);
			JOptionPane.showMessageDialog(null, id.getText() + "님의 연락처가 수정 되었습니다.");
		}

		// 회원정보 검색
		if (e.getSource() == btnNewButton_3) {
			String getId = id.getText();
			dto = dao.selectInfo(getId);

			id.setText(dto.id);
			name.setText(dto.name);
			age.setText(dto.age);
			tel.setText(dto.tel);
		}

		// 모든 회원정보 검색
		if (e.getSource() == btnNewButton_4) {
			new SelectAll();
		}

	}
}
