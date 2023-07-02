package login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class panelProfile extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelProfile() {
		setBackground(new Color(128, 0, 64));
		setBounds(0,0,538,396);
		setLayout(null);
		setVisible(true);
		JLabel lblNewLabel = new JLabel("Profile section");
		lblNewLabel.setBounds(95, 49, 265, 48);
		add(lblNewLabel);
	}

}
