package controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		prezime = DodajProfesoraDialog.txtPrezime.getText().trim();
		ime = DodajProfesoraDialog.txtIme.getText().trim();
		datumRodjenja = DodajProfesoraDialog.txtDatumRodjenja.getText().trim();
		adresa = DodajProfesoraDialog.txtAdresaStanovanja.getText().trim();
		telefon = DodajProfesoraDialog.txtBrojTelefona.getText().trim();
		eMail = DodajProfesoraDialog.txtEmailAdresa.getText().trim();
		adresaKancelarije = DodajProfesoraDialog.txtAdresaKancelarije.getText().trim();
		brojLicne = DodajProfesoraDialog.txtBrojLicneKarte.getText().trim();

		if (!proveriIme(ime + " " + prezime) || !proveriDatum(datumRodjenja) || !proveriAdresu(adresa)
				|| !proveriBrTelefona(telefon) || !proveriEmail(eMail) || !proveriAdresu(adresaKancelarije)
				|| !proveriBrLicne(brojLicne)) {
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

	private boolean proveriBrLicne(String brojLicne) {
		boolean retVal = true;
		Pattern patern = Pattern.compile("^[0-9]*$");
		Matcher matcher = patern.matcher(brojLicne);
		retVal = matcher.matches();
		if (retVal == false) {
			JOptionPane.showMessageDialog(null, "GREŠKA Proverite unet broj ličen karte.\nSamo brojevi su dozvoljeni!",
					"GREŠKA", JOptionPane.ERROR_MESSAGE);
		}
		return retVal;
	}

	private boolean proveriEmail(String eMail) {
		boolean retVal = true;
		Pattern patern = Pattern.compile(
				"^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
		Matcher matcher = patern.matcher(eMail);
		retVal = matcher.matches();
		if (retVal == false) {
			JOptionPane.showMessageDialog(null, "GREŠKA Proverite unetu eMail adresu.", "GREŠKA",
					JOptionPane.ERROR_MESSAGE);
		}
		return retVal;
	}

	private boolean proveriBrTelefona(String telefon) {
		boolean retVal = true;
		Pattern patern = Pattern.compile("\\+?\\d[\\d\\s]{6,15}\\d");
		Matcher matcher = patern.matcher(telefon);
		retVal = matcher.matches();
		if (retVal == false) {
			JOptionPane.showMessageDialog(null, "GREŠKA Proverite unet broj telefona.\nSamo brojevi su dozvoljeni!",
					"GREŠKA", JOptionPane.ERROR_MESSAGE);
		}
		return retVal;
	}

	private boolean proveriAdresu(String adresa) {
		boolean retVal = true;
		Pattern patern = Pattern.compile("[a-zA-ZšŠđĐčČćĆžŽ0-9',. -]+");
		Matcher matcher = patern.matcher(adresa);
		retVal = matcher.matches();
		if (retVal == false) {
			JOptionPane.showMessageDialog(null,
					"GREŠKA Proverite unetu adresu ili adresu kancelarije.\nPolje sadrži nedozvoljene karaktere!",
					"GREŠKA", JOptionPane.ERROR_MESSAGE);
		}
		return retVal;
	}

	private boolean proveriDatum(String datumRodjenja) {
		boolean retVal = true;
		Pattern patern = Pattern.compile("(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.((?:19|20)\\d{2})");
		Matcher matcher = patern.matcher(datumRodjenja);
		retVal = matcher.matches();
		if (retVal == false) {
			JOptionPane.showMessageDialog(null,
					"GREŠKA Proverite datum rođenja.\nFormat datuma je: dd.mm.yyyy .",
					"GREŠKA", JOptionPane.ERROR_MESSAGE);
		}
		return retVal;
	}

	private boolean proveriIme(String ime) {
		boolean retVal = true;
		Pattern patern = Pattern.compile("^[a-zA-ZšŠđĐčČćĆžŽ]+(([',. -][a-zA-ZšŠđĐčČćĆžŽ ])?[a-zA-ZšŠđĐčČćĆžŽ]*)*$");
		Matcher matcher = patern.matcher(ime);
		retVal = matcher.matches();
		if (retVal == false) {
			JOptionPane.showMessageDialog(null,
					"GREŠKA Proverite uneto ime ili prezime.\nPolje sadrži nedozvoljene karaktere!", "GREŠKA",
					JOptionPane.ERROR_MESSAGE);
		}
		return retVal;
	}
}
