package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame implements ActionListener {

	private JLabel lblId;
	private JLabel lblPw;

	private JTextField tfId;
	private JPasswordField pfPw;

	private JButton btnLogin;
	private JButton btnJoin;

	private JoinDialog joinDialog;
	private LoginDialog logInDialog;
	private UserInfo userInfo;

	public static final int INPUT_SIZE = 10;

	public MainFrame() {
		init();
		setDisplay();
		adListeners();
		showFrame();
		this.logInDialog = new LoginDialog(this);
		this.joinDialog = new JoinDialog(logInDialog);
//		this.userInfo = new 
	}

	private void init() {
		Dimension lblSize = new Dimension(80, 18);
		lblId = new JLabel("ID");
		lblPw = new JLabel("Password");
		lblId.setPreferredSize(lblSize);
		lblPw.setPreferredSize(lblSize);

		tfId = new JTextField(INPUT_SIZE);
		pfPw = new JPasswordField(INPUT_SIZE);

		Dimension btnSize = new Dimension(90, 22);
		btnLogin = new JButton("Login");
		btnJoin = new JButton("Join");
		btnLogin.setPreferredSize(btnSize);
		btnJoin.setPreferredSize(btnSize);
	}

	private void setDisplay() {
		JPanel pnlNorth = new JPanel(new GridLayout(2, 1));

		JPanel pnlId = new JPanel();
		pnlId.add(lblId);
		pnlId.add(tfId);

		JPanel pnlPw = new JPanel();
		pnlPw.add(lblPw);
		pnlPw.add(pfPw);

		pnlNorth.add(pnlId);
		pnlNorth.add(pnlPw);

		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnLogin);
		pnlSouth.add(btnJoin);

		JPanel pnlMain = new JPanel(new BorderLayout());

		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);

		pnlMain.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pnlMain, BorderLayout.CENTER);
	}

	private void adListeners() {
		btnJoin.addActionListener(this);
		btnLogin.addActionListener(this);
	}

	private void showFrame() {
		setTitle("Login");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	// ���̺��� Text�� �����ϴ� �޼ҵ�
	// public void setInput(String input) {
	// lblId.setText(input);
	// }

	// ���� �������� �ʰ� ���̺��� Text�� �����ϴ� �޼ҵ带 �̿��ؼ� �������� ������
	// public void cancelInput() {
	// setInput("��ҵǾ����ϴ�.");
	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		String inputId = tfId.getText().trim();
		String inputPw = pfPw.getText().trim();
		// Join��ư �׼�
		if (src == btnJoin) {
			joinDialog.showDlg();
			// Login��ư �׼�
		} else {
			// ID�� �����̸�
			if (inputId.length() == 0) {
				JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
				tfId.requestFocus();
				tfId.selectAll();
				// PW�� �����̸�
			} else if (inputPw.length() == 0) {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
				pfPw.requestFocus();
				pfPw.selectAll();
				// ID�� PW�� ������ �ƴϸ�
			} else if (inputId.length() != 0 && inputPw.length() != 0) {
				// ���̵� ��ġ�ϴ��� Ȯ��

				// ��й�ȣ�� ��ġ�ϴ��� Ȯ��

				// infomation â ���
				logInDialog.showDlg();
			}
		}
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
