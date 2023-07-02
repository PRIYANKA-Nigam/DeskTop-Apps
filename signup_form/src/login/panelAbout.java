package login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class panelAbout extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelAbout() {
		setBackground(new Color(255, 128, 64));
		setBounds(0,0,538,396);
       setLayout(null);
       setVisible(true);
       JLabel lblNewLabel = new JLabel("This is about section");
       lblNewLabel.setBounds(80, 42, 304, 42);
       add(lblNewLabel);
	}

}
