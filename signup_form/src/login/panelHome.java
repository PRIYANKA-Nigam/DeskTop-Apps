package login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class panelHome extends JPanel {

	public panelHome() {
		setBackground(new Color(0, 255, 64));
		setBounds(0,0,538,396);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Home section");
		lblNewLabel.setBounds(99, 52, 247, 46);
		add(lblNewLabel);
	}

}
