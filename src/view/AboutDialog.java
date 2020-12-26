package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AboutDialog extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2566945927276159128L;

	public AboutDialog() {
		
		setTitle("Help - Upustvo za koriscenje programa");
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
        
        JPanel firstPanel = new JPanel(); 
        JLabel helpLabela = new JLabel("Ovaj prozor treba da Vam pruzi informacije o verziji samog programa i o samim autorima");
        firstPanel.add(helpLabela);
        this.add(firstPanel, BorderLayout.NORTH);
        
        
        JTextArea jta = new JTextArea(" Trenutna verzija programa je: ... \n Opis Verzije: \n \n Nikola Ninkovic - Biografija \n \n \n Darko Vrbaski - Biografija \n \n \n ", 25, 50);
        jta.setLineWrap(true);
        this.add(jta, BorderLayout.CENTER);
        
		 JScrollPane scrollPane = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       add(scrollPane,BorderLayout.CENTER);
        
        jta.setEditable(false);
        
        pack();
		
		
		
		
		
	}
	
}
