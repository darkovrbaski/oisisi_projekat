package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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

	private ProfesoriController() {
	}

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
		adresaKancelarije = DodajProfesoraDialog.txtAdresaKancelarije.getText();
		brojLicne = DodajProfesoraDialog.txtBrojLicneKarte.getText();

		if (!proveriPrezime(prezime) || !proveriIme(ime) || !proveriDatum(datumRodjenja) || !proveriAdresu(adresa)
				|| !proveriBrTelefona(telefon) || !proveriAdrKancelarije(eMail) || !proveriEmail(adresaKancelarije)
				|| !proveriBrTelefona(brojLicne)) {
			retVal = false;
		}

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

		if (titula == Titula.Master) {
			if (zvanje != Zvanje.Asistent) {
				JOptionPane.showMessageDialog(null, "Predavač sa titulom mastera može biti samo asistent!", "GREŠKA",
						JOptionPane.ERROR_MESSAGE);
				retVal = false;
			}
		}

		if (retVal == true) {
			Profesor profesor = new Profesor(ime, prezime, datumRodjenja, adresa, telefon, eMail, adresaKancelarije,
					brojLicne, titula, zvanje, spisakPredmeta);
			retVal = BazaProfesora.getInstance().dodajProfesora(profesor);
			if (retVal == false) {
				JOptionPane.showMessageDialog(null, "Profesor sa unetim brojem lične karte već postoji.", "GREŠKA",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		ProfesorTable.azurirajPrikazProfesora();
		return retVal;
	}

	public boolean proveriPopunjenostPolja() {
		boolean retVal = true;
		if (DodajProfesoraDialog.txtPrezime.getText().trim().isEmpty()
				|| DodajProfesoraDialog.txtIme.getText().trim().isEmpty()
				|| DodajProfesoraDialog.txtDatumRodjenja.getText().trim().isEmpty()
				|| DodajProfesoraDialog.txtAdresaStanovanja.getText().trim().isEmpty()
				|| DodajProfesoraDialog.txtBrojTelefona.getText().trim().isEmpty()
				|| DodajProfesoraDialog.txtEmailAdresa.getText().trim().isEmpty()
				|| DodajProfesoraDialog.txtAdresaKancelarije.getText().trim().isEmpty()
				|| DodajProfesoraDialog.txtBrojLicneKarte.getText().trim().isEmpty()) {
			retVal = false;
		}
		return retVal;
	}

	private boolean proveriEmail(String adresaKancelarije) {
		boolean retVal = true;
		return retVal;
	}

	private boolean proveriAdrKancelarije(String eMail) {
		boolean retVal = true;
		return retVal;
	}

	private boolean proveriBrTelefona(String telefon) {
		boolean retVal = true;
		return retVal;
	}

	private boolean proveriAdresu(String adresa) {
		boolean retVal = true;
		return retVal;
	}

	private boolean proveriDatum(String datumRodjenja) {
		boolean retVal = true;
		return retVal;
	}
	
	private boolean proveriIme(String ime) {
		boolean retVal = true;
		return retVal;
	}
	
	private boolean proveriPrezime(String prezime) {
		boolean retVal = true;
		return retVal;
	}
}
