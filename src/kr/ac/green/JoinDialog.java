package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JoinDialog extends JDialog implements ActionListener {

	private JLabel lblId;
	private JLabel lblPw;
	private JLabel lblRe;
	private JLabel lblName;
	private JLabel lblNickName;

	private JTextField tfId;
	private JPasswordField pfPw;
	private JPasswordField pfRe;
	private JTextField tfName;
	private JTextField tfNickName;

	private JRadioButton rbtnMale;
	private JRadioButton rbtnFemale;

	private JButton btnJoin;
	private JButton btnCancel;

	// private MainFrame owner;
	private LoginDialog infoDialog;

	public static final int INPUT_SIZE = 10;

	// public JoinDialog(MainFrame owner) {
	// super(owner, true);
	// this.owner = owner;
	// init();
	// setDisplay();
	// adListeners();
	// }

	public JoinDialog(LoginDialog infoDialog) {
		this.infoDialog = infoDialog;
		init();
		setDisplay();
		adListeners();
	}

	private void init() {
		Dimension lblSize = new Dimension(80, 18);
		lblId = new JLabel("ID");
		lblPw = new JLabel("Password");
		lblRe = new JLabel("Retry");
		lblName = new JLabel("Name");
		lblNickName = new JLabel("NickName");
		lblId.setPreferredSize(lblSize);
		lblPw.setPreferredSize(lblSize);
		lblRe.setPreferredSize(lblSize);
		lblName.setPreferredSize(lblSize);
		lblNickName.setPreferredSize(lblSize);

		tfId = new JTextField(INPUT_SIZE);
		pfPw = new JPasswordField(INPUT_SIZE);
		pfRe = new JPasswordField(INPUT_SIZE);
		tfName = new JTextField(INPUT_SIZE);
		tfNickName = new JTextField(INPUT_SIZE);

		rbtnMale = new JRadioButton("Male", true);
		rbtnFemale = new JRadioButton("Female");
		ButtonGroup sizeGroup = new ButtonGroup();
		sizeGroup.add(rbtnMale);
		sizeGroup.add(rbtnFemale);

		Dimension btnSize = new Dimension(90, 22);
		btnJoin = new JButton("Join");
		btnCancel = new JButton("Cancel");
		btnJoin.setPreferredSize(btnSize);
		btnCancel.setPreferredSize(btnSize);
	}

	private void setDisplay() {
		JPanel pnlNorth = new JPanel(new GridLayout(0, 1));

		JPanel pnlId = new JPanel();
		pnlId.add(lblId);
		pnlId.add(tfId);
		JPanel pnlPw = new JPanel();
		pnlPw.add(lblPw);
		pnlPw.add(pfPw);
		JPanel pnlRe = new JPanel();
		pnlRe.add(lblRe);
		pnlRe.add(pfRe);
		JPanel pnlName = new JPanel();
		pnlName.add(lblName);
		pnlName.add(tfName);
		JPanel pnlNickName = new JPanel();
		pnlNickName.add(lblNickName);
		pnlNickName.add(tfNickName);

		pnlNorth.add(pnlId);
		pnlNorth.add(pnlPw);
		pnlNorth.add(pnlRe);
		pnlNorth.add(pnlName);
		pnlNorth.add(pnlNickName);

		JPanel pnlCenter = new JPanel();
		pnlCenter.add(rbtnMale);
		pnlCenter.add(rbtnFemale);
		pnlCenter.setBorder(new TitledBorder("Gender"));

		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnJoin);
		pnlSouth.add(btnCancel);

		JPanel pnlMain = new JPanel(new BorderLayout());

		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);

		pnlMain.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pnlMain, BorderLayout.CENTER);
	}

	private void adListeners() {
		btnJoin.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	public void showDlg() {
		setTitle("Join");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object src = ae.getSource();
		// Join버튼 액션
		if (src == btnJoin) {
			String input = lblId.getText() + "	:    " + tfId.getText() + "\n" + lblName.getText() + "	:    "
					+ tfName.getText() + "\n" + lblNickName.getText() + "	:    " + tfNickName.getText();

			infoDialog.setInput(input);
			// cancel버튼 액션
		} else {
			dispose();
		}
		// 창보이게
		// owner.setVisible(true);
		// 이 창에 대한 자원 해제
		dispose();
	}
}
