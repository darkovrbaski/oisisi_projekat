package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class HelpDialog extends JDialog {
	

	  public HelpDialog() {
	   
         
          setTitle("Help - Upustvo za koriscenje programa");
          setSize(400,400);
          setLocationRelativeTo(null);
          setVisible(true);
          
          JPanel firstPanel = new JPanel(); 
          JLabel helpLabela = new JLabel("Ovaj prozor treba da Vam pruzi sve informacije neophodne za koriscenje aplikacije");
          firstPanel.add(helpLabela);
          this.add(firstPanel, BorderLayout.NORTH);
          
          
          JTextArea jta = new JTextArea("GLAVNI PROZOR APLIKACIJE SE SASTOJI OD: \n \n Menu Bar cine stavke: \n  1.File \n a)New - dodavanje novog entiteta \n b)Close - zatvaranje aplikacije \n 2.Edit \n a)Edit - izmjena postojeceg entiteta \n b)Delete - brisanje postojeceg entiteta \n 3.Help \n a)Help-ova sekcija sadrzi vodic za koriscenje aplikacije \n b)About-prikazuje verzije aplikacije i kratak opis autora \n \n Tool Bar koga cine stavke: \n Prvo dugme sluzi za otvaranje dijaloga za stvaranje novog entiteta. \n Dok drugo dugme otvara dijalog za izmjenu oznacenog entiteta. \n Trece dugme brise oznacene entitete. \n Dugme za pretragu sluzi za pretrazivanje entiteta. \n \n Centralni dio panela: \n Sluzi za prikaz tabele entiteta. \n \n Status Bar koga cine: \n 1) Ime samog programa (levi donji ugao) \n 2) Trenutno vrijeme i datum (desni donji ugao) \n \n Za brzi pristup stavkama samog programa sledite dole navedene precice: \n (1) Mnemonici: \n 1) File -> ALT + A \n a) New -> ALT + Q \n b) Close -> ALT + W \n 2) Edit -> ALT + B \n a) Edit -> ALT + E \n b) Delete -> ALT + R \n 3) Help -> ALT + B \n a) Help -> ALT + T \n b) About -> ALT + Z \n \n (2)Akceleratori: \n 1. File \n a) New -> CTRL + N \n b) Close -> CTRL + C \n 2.Edit \n a) Edit -> CTRL + E \n b) Delete -> CTRL + D \n 3.Help \n a) Help -> CTRL + H \n b) About -> CTRL + A \n ", 25, 50);
          jta.setLineWrap(true);
          this.add(jta, BorderLayout.CENTER);
          
 		 JScrollPane scrollPane = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         add(scrollPane,BorderLayout.CENTER);
          
          jta.setEditable(false);
          
          pack();
         

		  
		  
	  }

	  
	}


