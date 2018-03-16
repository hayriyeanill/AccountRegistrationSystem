package labWeek6;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AccountRegistrationSystem extends JFrame implements ActionListener {

	JLabel lblCountry = new JLabel();
	JTextField txtName = new JTextField();
	JTextField txtUser = new JTextField();
	JPasswordField txtPass = new JPasswordField();
	JPasswordField txtPass2 = new JPasswordField();


	String[] country = {"--SELECT--", "Turkey", "England", "France", "Italy"};
	JComboBox<String> cmbCountry = new JComboBox<>(country);
	
	/* Combobox with model
	String[] arr = new String[] { "Foo", "Bar" };
	DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(arr);
	JComboBox<String> combobox = new JComboBox<>(model);*/

	JButton btnEnter = new JButton("ENTER");
	JButton btnCancel = new JButton("CANCEL");


	public AccountRegistrationSystem() {
		setTitle("Account registration");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new GridLayout(6,2));

		//setLocation(600,100);
		//setBounds(600, 100, 700, 500);
		//setLayout(new BorderLayout());

		setComponents();
		setListeners();

		String name;

		do {
			name = JOptionPane.showInputDialog(null, "Enter your account name", "account name", JOptionPane.OK_CANCEL_OPTION);
			if(name == null) {
				System.exit(-1);
			}
		}while(name.length() == 0);

		txtName.setText(name);
		txtName.setEnabled(false);

}


	private void setListeners() {
		cmbCountry.addActionListener(this);
		btnCancel.addActionListener(this);
		btnEnter.addActionListener(this);

	}


	public void setComponents() {




		add(new JLabel("Name: "));
		add(txtName);
	

		add(new JLabel("Password: "));
		add(txtPass);
		

		add(new JLabel("Password(repeat): "));
		add(txtPass2);
		


		add(new JLabel("Country: "));
		JPanel pnlCountry = new JPanel();
		pnlCountry.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlCountry.add(lblCountry);
		add(cmbCountry);
		add(pnlCountry);



		add(new JPanel());
		add(btnCancel);
		add(btnEnter);

	}


	public static void main(String[] args) {
		new GUI().setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnCancel) {
			int result= JOptionPane.showConfirmDialog(null, "Are you sure?", 
					"Select an option",JOptionPane.YES_NO_CANCEL_OPTION);
			if (result == JOptionPane.YES_OPTION) System.exit(0);

		}else if(e.getSource() == btnEnter) {

			if(txtName.getText().isEmpty() || new String(txtPass.getPassword()).isEmpty() || 
					new String(txtPass2.getPassword()).isEmpty() || cmbCountry.getSelectedItem().equals("--SELECT--")) {
				JOptionPane.showMessageDialog(btnEnter, "An account type should be selected");  


			}else if(!new String(txtPass.getPassword()).equals(new String(txtPass2.getPassword()))) {
				 JOptionPane.showMessageDialog(null, "Passwords are not matching.");
                  
				 
			}else {
				JOptionPane.showMessageDialog(null, "Done");
			System.exit(0);
			}
		}

	}
}
