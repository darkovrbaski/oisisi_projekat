package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		String prezime;
		String ime;
		Date datumRodjenja;
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
		adresa = DodajProfesoraDialog.txtAdresaStanovanja.getText().trim();
		telefon = DodajProfesoraDialog.txtBrojTelefona.getText().trim();
		eMail = DodajProfesoraDialog.txtEmailAdresa.getText().trim();
		adresaKancelarije = DodajProfesoraDialog.txtAdresaKancelarije.getText().trim();
		brojLicne = DodajProfesoraDialog.txtBrojLicneKarte.getText().trim();

		if (!proveriIme(ime + " " + prezime) || !proveriAdresu(adresa) || !proveriBrTelefona(telefon)
				|| !proveriEmail(eMail) || !proveriAdresu(adresaKancelarije) || !proveriBrLicne(brojLicne)) {
			return false;
		}

		datumRodjenja = new Date();
		try {
			datumRodjenja = new SimpleDateFormat("dd.MM.yyyy")
					.parse(DodajProfesoraDialog.txtDatumRodjenja.getText().trim());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "GREŠKA Proverite datum rođenja.\nFormat datuma je: dd.mm.yyyy",
					"GREŠKA", JOptionPane.ERROR_MESSAGE);
			return false;
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
			return false;
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
			return false;
		}

		if (titula == Titula.Master) {
			if (zvanje != Zvanje.Asistent) {
				JOptionPane.showMessageDialog(null, "Predavač sa titulom mastera može biti samo asistent!", "GREŠKA",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		Profesor profesor = new Profesor(ime, prezime, datumRodjenja, adresa, telefon, eMail, adresaKancelarije,
				brojLicne, titula, zvanje, spisakPredmeta);

		if (BazaProfesora.getInstance().dodajProfesora(profesor) == false) {
			JOptionPane.showMessageDialog(null, "Profesor sa unetim brojem lične karte već postoji.", "GREŠKA",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		ProfesorTable.azurirajPrikazProfesora();

		return true;
	}

	public boolean proveriPopunjenostPolja() {
		boolean retVal = false;
		if (proveriIme(DodajProfesoraDialog.txtPrezime.getText().trim())
				&& proveriIme(DodajProfesoraDialog.txtIme.getText().trim())
				&& proveriDatum(DodajProfesoraDialog.txtDatumRodjenja.getText().trim())
				&& proveriAdresu(DodajProfesoraDialog.txtAdresaStanovanja.getText().trim())
				&& proveriBrTelefona(DodajProfesoraDialog.txtBrojTelefona.getText().trim())
				&& proveriEmail(DodajProfesoraDialog.txtEmailAdresa.getText().trim())
				&& proveriAdresu(DodajProfesoraDialog.txtAdresaKancelarije.getText().trim())
				&& proveriBrLicne(DodajProfesoraDialog.txtBrojLicneKarte.getText().trim())) {
			retVal = true;
		}
		if (DodajProfesoraDialog.txtPrezime.getText().trim().equals("Ime")
				|| DodajProfesoraDialog.txtIme.getText().trim().equals("Prezime")
				|| DodajProfesoraDialog.txtDatumRodjenja.getText().trim().equals("dd.mm.yyyy.")
				|| DodajProfesoraDialog.txtAdresaStanovanja.getText().trim().equals("Adresa, 123")
				|| DodajProfesoraDialog.txtBrojTelefona.getText().trim().equals("06123123123")
				|| DodajProfesoraDialog.txtEmailAdresa.getText().trim().equals("primer@primer.com")
				|| DodajProfesoraDialog.txtAdresaKancelarije.getText().trim().equals("Adresa, Kancelarija, 123")
				|| DodajProfesoraDialog.txtBrojLicneKarte.getText().trim().equals("111222333")) {
			retVal = false;
		}
		return retVal;
	}

	public boolean proveriBrLicne(String brojLicne) {
		if (brojLicne.isEmpty()) {
			return false;
		}
		boolean retVal = true;
		Pattern patern = Pattern.compile("^[0-9]{9}$");
		Matcher matcher = patern.matcher(brojLicne);
		retVal = matcher.matches();
		for (Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if (p.getBrojLicne().equals(brojLicne)) {
				retVal = false;
			}
		}
		return retVal;
	}

	public boolean proveriEmail(String eMail) {
		if (eMail.isEmpty()) {
			return false;
		}
		boolean retVal = true;
		Pattern patern = Pattern.compile(
				"^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
		Matcher matcher = patern.matcher(eMail);
		retVal = matcher.matches();
		return retVal;
	}

	public boolean proveriBrTelefona(String telefon) {
		if (telefon.isEmpty()) {
			return false;
		}
		boolean retVal = true;
		Pattern patern = Pattern.compile("\\+?\\d[\\d\\s]{6,15}\\d");
		Matcher matcher = patern.matcher(telefon);
		retVal = matcher.matches();
		return retVal;
	}

	public boolean proveriAdresu(String adresa) {
		if (adresa.isEmpty()) {
			return false;
		}
		boolean retVal = true;
		Pattern patern = Pattern.compile("[a-zA-ZšŠđĐčČćĆžŽ0-9',. -]+");
		Matcher matcher = patern.matcher(adresa);
		retVal = matcher.matches();
		return retVal;
	}
	
	public boolean proveriDatum(String datumRodjenja) {
		if (datumRodjenja.isEmpty()) {
			return false;
		}
		boolean retVal = true;
		Pattern patern = Pattern.compile("(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.((?:19|20)\\d{2})");
		Matcher matcher = patern.matcher(datumRodjenja);
		retVal = matcher.matches();
		return retVal;
	}
	
	public boolean proveriIme(String ime) {
		if (ime.isEmpty()) {
			return false;
		}
		boolean retVal = true;
		Pattern patern = Pattern.compile("^[a-zA-ZšŠđĐčČćĆžŽ]+(([',. -][a-zA-ZšŠđĐčČćĆžŽ ])?[a-zA-ZšŠđĐčČćĆžŽ]*)*$");
		Matcher matcher = patern.matcher(ime);
		retVal = matcher.matches();
		return retVal;
	}
}
