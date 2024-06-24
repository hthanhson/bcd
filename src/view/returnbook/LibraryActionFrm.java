package view.returnbook;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.User;

public class LibraryActionFrm extends JFrame implements ActionListener{
	private JButton btnReturnedBook;
	private User user;

	public LibraryActionFrm(User user) {
		super("Room management");	
		this.user = user;

		JPanel listPane = new JPanel();
		listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));

		JPanel lblPane = new JPanel();
		lblPane.setLayout(new BoxLayout(lblPane, BoxLayout.LINE_AXIS));
//		lblPane.add(Box.createRigidArea(new Dimension(450, 0)));
		JLabel lblUser = new JLabel("Loged in as: " + user.getFullname());
		lblUser.setAlignmentX(Component.RIGHT_ALIGNMENT);	
		lblPane.add(lblUser);
		listPane.add(lblPane);
		listPane.add(Box.createRigidArea(new Dimension(0,20)));

		JLabel lblHome = new JLabel("Library Action");
		lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);	
		lblHome.setFont (lblHome.getFont ().deriveFont (28.0f));
		listPane.add(lblHome);
		listPane.add(Box.createRigidArea(new Dimension(0,20)));

		btnReturnedBook = new JButton("Retured Book");
		btnReturnedBook.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnReturnedBook.addActionListener(this);
		listPane.add(btnReturnedBook);
		listPane.add(Box.createRigidArea(new Dimension(0,10)));

		this.setSize(400,200);				
		this.setLocation(200,10);
		this.add(listPane, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                this.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if((e.getSource() instanceof JButton)&&(((JButton)e.getSource()).equals(btnReturnedBook))) {
                    
			(new SearchReaderInforFrm(user)).setVisible(true);
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(this, "This function is under construction!");
		}
	}

}
