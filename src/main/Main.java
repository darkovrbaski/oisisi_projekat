package main;

import controller.PredmetController;
import controller.ProfesoriController;
import controller.StudentiController;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudent;
import view.Frame;

public class Main {

	public static void main(String[] args) {
		
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
