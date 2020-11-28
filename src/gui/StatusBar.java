package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1696597433259221588L;
	
	public StatusBar(){

	        setLayout(new BorderLayout());
	        setPreferredSize(new Dimension(getWidth(), 23));

	        // Left Panel
	        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 3));
	        leftPanel.setOpaque(false);
	        add(leftPanel, BorderLayout.WEST);
	        
	        JLabel leftLabel = new JLabel("Studentska Služba");
	        leftPanel.add(leftLabel);
	        
	        
	        // Right Panel
	        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 5, 3));
	        rightPanel.setOpaque(false);
	        add(rightPanel, BorderLayout.EAST);
	        
	        JLabel rightLabel = new JLabel("");
	        
	        clock(rightLabel);
	        rightPanel.add(rightLabel);
	}
	
	
	/**REFERENCA: https://www.youtube.com/watch?v=tpQAslXjNKU&ab_channel=ProgrammingKnowledge  Prilagodjeno kod projektu */
	public void clock(JLabel jl) {
		
		Thread clock = new Thread() {
			
			public void run() {
				
				try {
					
					while(true) {
					Calendar cal = new GregorianCalendar();
					int day= cal.get(Calendar.DAY_OF_MONTH);
					int month= cal.get(Calendar.MONTH);
					int year= cal.get(Calendar.YEAR);
					
					int second= cal.get(Calendar.SECOND);
					int minute= cal.get(Calendar.MINUTE);
					int hour= cal.get(Calendar.HOUR); 
					
					jl.setText(""+hour+":"+minute+":"+second+"  "+day+"."+month+"."+year);
					
					
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		};
			
		clock.start();
	}
	
	
}


