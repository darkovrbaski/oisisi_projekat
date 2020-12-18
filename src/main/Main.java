package main;

import model.BazaProfesora;
import view.Frame;

public class Main {

	public static void main(String[] args) {
		
		BazaProfesora.getInstance();
		Frame studentskaSluzba = Frame.getInstance();
		studentskaSluzba.setVisible(true);
		
	}

}
