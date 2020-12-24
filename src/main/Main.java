package main;

import controller.ProfesoriController;
import model.BazaProfesora;
import view.Frame;

public class Main {

	public static void main(String[] args) {
		
		BazaProfesora.getInstance();
		ProfesoriController.getInstance();
		Frame studentskaSluzba = Frame.getInstance();
		studentskaSluzba.setVisible(true);
		
		
	
	}

}
