package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class LoginDialog extends JDialog implements ActionListener {

	private JTextArea taInfo;

	private JButton btnLogout;
	private JButton btnWithdraw;

	private MainFrame owner;

	public LoginDialog(MainFrame owner) {
		super(owner, true);
		this.owner = owner;
		init();
		setDisplay();
		adListeners();
	}

	private void init() {
		taInfo = new JTextArea(10, 40);
		taInfo.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Check your Infomation"));
		// tfInfo.setEditable(false);

		Dimension btnSize = new Dimension(90, 22);
		btnLogout = new JButton("Logout");
		btnWithdraw = new JButton("Withdraw");
		btnLogout.setPreferredSize(btnSize);
		btnWithdraw.setPreferredSize(btnSize);
	}

	private void setDisplay() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnLogout);
		pnlSouth.add(btnWithdraw);

		add(taInfo, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	private void adListeners() {
		btnLogout.addActionListener(this);
		btnWithdraw.addActionListener(this);
	}

	public void showDlg() {
		setTitle("Information");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	// TextArea를 변경하는 메소드
	public void setInput(String input) {
		taInfo.setText(input);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
