package controller;

import java.util.ArrayList;

import model.BazaStudent;
import model.Ocena;
import model.Student;
import model.Student.Status;
import model.Student.TrenutnaGodina;
import view.StudentTable;
import view.dialogs.DodajStudentaDialog;

public class StudentiController {

	private static StudentiController instance = null;

	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}

	private StudentiController() {}

	public void dodajStudenta() {
		@SuppressWarnings("unused")
		DodajStudentaDialog dialog = new DodajStudentaDialog();
	}

	public boolean proveriStudenta() {
		boolean retVal = true;
		String ime;
		String prezime;
		String datumRodjenja;
		String adresa;
		String telefon;
		String eMail;
		String brIndeksa;
		String godUpisa;
		String prosecnaOcjena = null;
		
		TrenutnaGodina trenGodina;
		Status status;
		
		ArrayList<Ocena> spisakPolozenihIspita = new ArrayList<Ocena>();
		ArrayList<Ocena> spisakNePolozenihIspita = new ArrayList<Ocena>();
		

		prezime = DodajStudentaDialog.txtPrezime.getText();
		ime = DodajStudentaDialog.txtIme.getText();
		datumRodjenja = DodajStudentaDialog.txtDatumRodjenja.getText();
		adresa = DodajStudentaDialog.txtAdresaStanovanja.getText();
		telefon = DodajStudentaDialog.txtBrojTelefona.getText();
		eMail = DodajStudentaDialog.txtEmailAdresa.getText();
		brIndeksa = DodajStudentaDialog.txtBrIndeksa.getText();
		godUpisa = DodajStudentaDialog.txtGodUpisa.getText();
		
		
		
		switch (DodajStudentaDialog.cbTrenutnaG.getSelectedItem().toString()) {
		case "PRVA":
			trenGodina = TrenutnaGodina.PRVA;
			break;
			
		case "DRUGA":
			trenGodina = TrenutnaGodina.DRUGA;
			break;
			
		case "TRECA":
			trenGodina = TrenutnaGodina.TRECA;
			break;

		case "CETVRTA":
			trenGodina = TrenutnaGodina.CETVRTA;
			break;
			
			
		default:
			trenGodina = null;
			retVal = false;
			break;
		}
		
		
		
		switch (DodajStudentaDialog.cbStatus.getSelectedItem().toString()) {
		case "B":
			status = Status.B;
			break;
		case "S":
			status = Status.S;
			break;
		default:
			status = null;
			retVal = false;
			break;
		}
		
		
		

		Student student = new Student(prezime, ime, datumRodjenja, adresa, telefon, eMail,
				brIndeksa,  godUpisa,  trenGodina, status,  prosecnaOcjena,
				spisakPolozenihIspita,  spisakNePolozenihIspita);
		
		
		
		if (retVal == true) {
			if (BazaStudent.getInstance().dodajStudenta(student) == false) {
				retVal = false;
			}
		} else {
			retVal = false;
		}
		
		StudentTable.azurirajPrikazStudenata();
		return retVal;
	}

	
	
	
}
