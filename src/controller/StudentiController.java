package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.BazaStudent;
import model.Ocena;
import model.Predmet;
import model.Student;
import model.Student.Status;
import model.Student.TrenutnaGodina;
import view.StudentTable;
import view.dialogs.DodajProfesoraDialog;
import view.dialogs.DodajStudentaDialog;
import view.dialogs.IzmeniProfesoraDialog;

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
		Date datumRodjenja;
		String adresa;
		String telefon;
		String eMail;
		String brIndeksa;
		String godUpisa;
		double prosecnaOcjena = 0;
		TrenutnaGodina trenGodina;
		Status status;
		ArrayList<Ocena> spisakPolozenihIspita = new ArrayList<Ocena>();
		ArrayList<Predmet> spisakNePolozenihIspita = new ArrayList<Predmet>();
		

		prezime = DodajStudentaDialog.txtPrezime.getText().trim();
		ime = DodajStudentaDialog.txtIme.getText().trim();
		
		datumRodjenja = new Date();
		try {
			datumRodjenja = new SimpleDateFormat("dd.MM.yyyy")
					.parse(DodajStudentaDialog.txtDatumRodjenja.getText().trim());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "GREŠKA Proverite datum rođenja.\nFormat datuma je: dd.mm.yyyy",
					"GREŠKA", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		//datumRodjenja = DodajStudentaDialog.txtDatumRodjenja.getText().trim();
		
		adresa = DodajStudentaDialog.txtAdresaStanovanja.getText().trim();
		telefon = DodajStudentaDialog.txtBrojTelefona.getText().trim();
		eMail = DodajStudentaDialog.txtEmailAdresa.getText().trim();
		brIndeksa = DodajStudentaDialog.txtBrIndeksa.getText().trim();
		godUpisa = DodajStudentaDialog.txtGodUpisa.getText().trim();
		
		
		
		if (!proveriIme(ime + " " + prezime) || !proveriDatum(DodajStudentaDialog.txtDatumRodjenja.getText().trim()) || !proveriAdresu(adresa)
				|| !proveriBrTelefona(telefon) || !proveriEmail(eMail) || !proveriGodUpisa(godUpisa)) {
			retVal = false;
		}
		
		
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
		
		
		
		if (retVal == true) {
			Student student = new Student(prezime, ime, datumRodjenja, adresa, telefon, eMail,
							brIndeksa,  godUpisa,  trenGodina, status,  prosecnaOcjena,
							spisakPolozenihIspita,  spisakNePolozenihIspita);
			
			retVal = BazaStudent.getInstance().dodajStudenta(student);
			if (retVal == false) {
				JOptionPane.showMessageDialog(null, "Student sa unetim brojem indeksa već postoji.", "GREŠKA",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
		
		StudentTable.azurirajPrikazStudenata();
		return retVal;
	}

	
	
	public boolean proveriPopunjenostPolja() {
		boolean retVal = true;
		if (DodajStudentaDialog.txtPrezime.getText().trim().isEmpty()
				|| DodajStudentaDialog.txtIme.getText().trim().isEmpty()
				|| DodajStudentaDialog.txtDatumRodjenja.getText().trim().isEmpty()
				|| DodajStudentaDialog.txtAdresaStanovanja.getText().trim().isEmpty()
				|| DodajStudentaDialog.txtBrojTelefona.getText().trim().isEmpty()
				|| DodajStudentaDialog.txtEmailAdresa.getText().trim().isEmpty()
				|| DodajStudentaDialog.txtBrIndeksa.getText().trim().isEmpty()
				|| DodajStudentaDialog.txtGodUpisa.getText().trim().isEmpty()) {
			retVal = false;
		}
		return retVal;
	}
	
	
	
	/**REFERENCA: https://www.freeformatter.com/java-regex-tester.html#ad-output */
	


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
	
	
	
	
	//private boolean proveriBrIndeksa(String brIndeksa) {
	//	boolean retVal = true;
	//	Pattern patern = Pattern.compile("^\\d{5}$");
	//	Matcher matcher = patern.matcher(brIndeksa);
	//	retVal = matcher.matches();
	//	if (retVal == false) {
	//		JOptionPane.showMessageDialog(null, "GREŠKA Proverite unet broj indeksa.( MAX PET BROJEVA) \nSamo brojevi su dozvoljeni!",
	//				"GREŠKA", JOptionPane.ERROR_MESSAGE);
	//	}
	//	return retVal;
	//}
	
	
	
	private boolean proveriGodUpisa(String godUpisa) {
		boolean retVal = true;
		Pattern patern = Pattern.compile("^\\d{4}$");
		Matcher matcher = patern.matcher(godUpisa);
		retVal = matcher.matches();
		if (retVal == false) {
			JOptionPane.showMessageDialog(null, "GREŠKA Proverite unet broj godine upisa.( MAX CETIRI BROJA) \nSamo brojevi su dozvoljeni!",
					"GREŠKA", JOptionPane.ERROR_MESSAGE);
		}
		return retVal;
	}
	
	
	
}
