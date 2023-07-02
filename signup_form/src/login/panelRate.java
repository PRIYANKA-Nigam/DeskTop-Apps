package login;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class panelRate extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelRate() {
		setBackground(new Color(0, 0, 160));
		setBounds(0,0,538,396);
		setLayout(null);
		setVisible(true);
		JLabel lblNewLabel = new JLabel("Rate Us ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(156, 102, 123, 67);
		add(lblNewLabel);

	}

}
