package main;

import java.io.IOException;

import controller.PredmetController;
import controller.ProfesoriController;
import controller.StudentiController;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudent;
import model.Entiteti;
import view.Frame;

public class Main {

	public static void main(String[] args) {
		
		try {
			Entiteti.getInstance().desrializeToXML();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BazaStudent.getInstance();
		StudentiController.getInstance();
		BazaProfesora.getInstance();
		ProfesoriController.getInstance();
		BazaPredmeta.getInstance();
		PredmetController.getInstance();
		Frame studentskaSluzba = Frame.getInstance();
		studentskaSluzba.setVisible(true);
		
		
	
	}

}
