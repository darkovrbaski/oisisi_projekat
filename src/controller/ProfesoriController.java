package controller;

import java.util.ArrayList;

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;
import view.ProfesorTable;
import view.dialogs.DodajProfesoraDialog;

public class ProfesoriController {

	private static ProfesoriController instance = null;

	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}

	private ProfesoriController() {}

	public void dodajProfesora() {
		@SuppressWarnings("unused")
		DodajProfesoraDialog dialog = new DodajProfesoraDialog();
	}

	public boolean proveriProfesora() {
		boolean retVal = true;
		String prezime;
		String ime;
		String datumRodjenja;
		String adresa;
		String telefon;
		String eMail;
		String adresaKancelarije;
		String brojLicne;
		Titula titula;
		Zvanje zvanje;
		ArrayList<Predmet> spisakPredmeta = new ArrayList<Predmet>();

		prezime = DodajProfesoraDialog.txtPrezime.getText();
		ime = DodajProfesoraDialog.txtIme.getText();
		datumRodjenja = DodajProfesoraDialog.txtDatumRodjenja.getText();
		adresa = DodajProfesoraDialog.txtAdresaStanovanja.getText();
		telefon = DodajProfesoraDialog.txtBrojTelefona.getText();
		eMail = DodajProfesoraDialog.txtEmailAdresa.getText();
		adresaKancelarije = DodajProfesoraDialog.txtAdresakancelarije.getText();
		brojLicne = DodajProfesoraDialog.txtBrojLicneKarte.getText();

		switch (DodajProfesoraDialog.cbTitula.getSelectedItem().toString()) {
		case "Master":
			titula = Titula.Master;
			break;
		case "Doktor":
			titula = Titula.Doktor;
			break;
		case "Doktor profesor":
			titula = Titula.DoktorProfesor;
			break;
		default:
			titula = null;
			retVal = false;
			break;
		}
		switch (DodajProfesoraDialog.cbZvanje.getSelectedItem().toString()) {
		case "Asistent":
			zvanje = Zvanje.Asistent;
			break;
		case "Docent":
			zvanje = Zvanje.Docent;
			break;
		case "Vanredni profesor":
			zvanje = Zvanje.VanredniProfesor;
			break;
		case "Redovni profesor":
			zvanje = Zvanje.RedovniProfesor;
			break;
		default:
			zvanje = null;
			retVal = false;
			break;
		}

		Profesor profesor = new Profesor(ime, prezime, datumRodjenja, adresa, telefon, eMail, adresaKancelarije,
				brojLicne, titula, zvanje, spisakPredmeta);
		if (retVal == true) {
			if (BazaProfesora.getInstance().dodajProfesora(profesor) == false) {
				retVal = false;
			}
		} else {
			retVal = false;
		}
		
		ProfesorTable.azurirajPrikazProfesora();
		return retVal;
	}
}
