package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.BazaPredmeta;
import model.BazaStudent;
import model.Ocena;
import model.Predmet;
import model.Student;
import model.Student.Status;
import model.Student.TrenutnaGodina;
import view.TabbedPanel;
import view.dialogs.DodajStudentaDialog;
import view.dialogs.IzmeniStudentaDialog;
import view.dialogs.UpisOceneDialog;
import view.dialogs.UpitPotvrdeDialog;

public class StudentiController {
	// izmm
	private static StudentiController instance;

	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}

	private StudentiController() {}
	
	
	
	
	// TODO: ZAVRSITI OVU METODU 
	public void dodajNepolozeniPredmet(Student student) {
			
				
	}
	
	
	
	public void ponistiPolozenuOcijenu(Student student){
		UpitPotvrdeDialog dialog = new UpitPotvrdeDialog("Ponisti Predmet",
				"Da li ste sigurni da želite da ponistite predmet?");
		if (dialog.isYes() == true) {
			
			 Predmet predmet = BazaPredmeta.getInstance().getRow(IzmeniStudentaDialog.tabelaPolozenihPredmeta.getCurrentSelectedRow()); 
			 int index = IzmeniStudentaDialog.tabelaPolozenihPredmeta.getCurrentSelectedRow();
			 
			 BazaStudent.getInstance().ponistiPolozenPredmet(student, predmet, index);
			 IzmeniStudentaDialog.tabelaPolozenihPredmeta.azurirajPrikaz();
			 IzmeniStudentaDialog.tabelaNepolozenihPredmeta.azurirajPrikaz();

		}
	}
	
		
	
	
	public void izbrisiNepolozeniPredmet(Student student) {
		UpitPotvrdeDialog dialog = new UpitPotvrdeDialog("Ukloni Nepolozeni predmet",
				"Da li ste sigurni da želite da uklonite predmet?");
		if (dialog.isYes() == true) {
		
			Predmet predmet = BazaPredmeta.getInstance().getRow(IzmeniStudentaDialog.tabelaNepolozenihPredmeta.getCurrentSelectedRow());
			
			 BazaStudent.getInstance().izbrisiNePolozenPredmet(student, predmet);
			 IzmeniStudentaDialog.tabelaNepolozenihPredmeta.azurirajPrikaz();
		
	
		}
		
	}
	
	
	
	
	public void izbrisiStudenta() {
		UpitPotvrdeDialog dialog = new UpitPotvrdeDialog("Brisanje studenta",
				"Da li ste sigurni da želite da obrišete studenta?");
		if (dialog.isYes() == true) {
			Student student = BazaStudent.getInstance().getRow(TabbedPanel.tabelaStudenata.getCurrentSelectedRow());
			BazaStudent.getInstance().izbrisiStudenta(student);
			TabbedPanel.tabelaStudenata.azurirajPrikazStudenta();
			BazaPredmeta.getInstance().izbrisiStudenta(student);
	
		}
	}
	
	
	
	
	public void pretragaStudenta() {
		BazaStudent.getInstance().pretragaStudenta();
		TabbedPanel.tabelaStudenata.azurirajPrikazStudenta();
	}
	
	
	

	public void dodajStudenta() {
		@SuppressWarnings("unused")
		DodajStudentaDialog dialog = new DodajStudentaDialog();
	}
	
	public void izmeniStudenta() {
		@SuppressWarnings("unused")
		IzmeniStudentaDialog dialog = new IzmeniStudentaDialog();
	}
	
	public void upisOcene(JDialog parent, Student student) {
		@SuppressWarnings("unused")
		UpisOceneDialog dialog = new UpisOceneDialog(parent, student);
	}
	
	public boolean proveriUpisOcene(Student student, Predmet predmet) {
		int ocena;
		Date datum;
		
		switch (UpisOceneDialog.cbOcena.getSelectedItem().toString()) {
		case "6":
			ocena =  6;
			break;
		case "7":
			ocena =  7;
			break;
		case "8":
			ocena =  8;
			break;
		case "9":
			ocena =  9;
			break;
		case "10":
			ocena =  10;
			break;
		default:
			return false;
		}
		datum = new Date();
		try {
			datum = new SimpleDateFormat("dd.MM.yyyy").parse(UpisOceneDialog.txtDatum.getText().trim());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Proverite datum.\nFormat datuma je: dd.mm.yyyy",
					"GREŠKA", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		Ocena o = new Ocena(student, predmet, ocena, datum);
		if (BazaStudent.getInstance().dodajOcenu(student, o) == false) {
			return false;
		}
		student.getSpisakNePolozenihIspita().remove(predmet);
		predmet.getStudNisuPolozili().remove(student);
		predmet.getStudPolozili().add(student);
		IzmeniStudentaDialog.tabelaNepolozenihPredmeta.azurirajPrikaz();
		IzmeniStudentaDialog.tabelaPolozenihPredmeta.azurirajPrikaz();
		
		return true;
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
			JOptionPane.showMessageDialog(null, "GREÅ KA Proverite datum roÄ‘enja.\nFormat datuma je: dd.mm.yyyy",
					"GREÅ KA", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		//datumRodjenja = DodajStudentaDialog.txtDatumRodjenja.getText().trim();
		
		adresa = DodajStudentaDialog.txtAdresaStanovanja.getText().trim();
		telefon = DodajStudentaDialog.txtBrojTelefona.getText().trim();
		eMail = DodajStudentaDialog.txtEmailAdresa.getText().trim();
		brIndeksa = DodajStudentaDialog.txtBrIndeksa.getText().trim();
		godUpisa = DodajStudentaDialog.txtGodUpisa.getText().trim();
		
		
		
//		if (!proveriIme(ime + " " + prezime) || !proveriDatum(DodajStudentaDialog.txtDatumRodjenja.getText().trim()) || !proveriAdresu(adresa)
//				|| !proveriBrTelefona(telefon) || !proveriEmail(eMail) || !proveriGodUpisa(godUpisa)) {
//			retVal = false;
//		}
		
		
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
			
			retVal = BazaStudent.getInstance().dodajStudenta(student);
			if (retVal == false) {
				JOptionPane.showMessageDialog(null, "Student sa unetim brojem indeksa veÄ‡ postoji.", "GREÅ KA",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		
		
		
		
		//StudentTable.azurirajPrikazStudenata();
		TabbedPanel.tabelaStudenata.azurirajPrikazStudenta(); 
			
		return true;
	}
	
	
	
	
	public boolean proveriIzmenuStudenta() {
		String ime;
		String prezime;
		Date datumRodjenja;
		String adresa;
		String telefon;
		String eMail;
		String brIndeksa;
		String godUpisa;
		TrenutnaGodina trenGodina;
		Status status;

		prezime = IzmeniStudentaDialog.txtPrezime.getText().trim();
		ime = IzmeniStudentaDialog.txtIme.getText().trim();
		
		datumRodjenja = new Date();
		try {
			datumRodjenja = new SimpleDateFormat("dd.MM.yyyy")
					.parse(IzmeniStudentaDialog.txtDatumRodjenja.getText().trim());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "GREÅ KA Proverite datum roÄ‘enja.\nFormat datuma je: dd.mm.yyyy",
					"GREÅ KA", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		//datumRodjenja = DodajStudentaDialog.txtDatumRodjenja.getText().trim();
		
		adresa = IzmeniStudentaDialog.txtAdresaStanovanja.getText().trim();
		telefon = IzmeniStudentaDialog.txtBrojTelefona.getText().trim();
		eMail = IzmeniStudentaDialog.txtEmailAdresa.getText().trim();
		brIndeksa = IzmeniStudentaDialog.txtBrIndeksa.getText().trim();
		godUpisa = IzmeniStudentaDialog.txtGodUpisa.getText().trim();
		
		
		switch (IzmeniStudentaDialog.cbTrenutnaG.getSelectedItem().toString()) {
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
			return false;
		}
		
		
		switch (IzmeniStudentaDialog.cbStatus.getSelectedItem().toString()) {
		case "B":
			status = Status.B;
			break;
		case "S":
			status = Status.S;
			break;
		default:
			status = null;
			return false;
		}
		

		BazaStudent.getInstance().izmeniStudenta(ime, prezime,  datumRodjenja, adresa, telefon, eMail, brIndeksa, godUpisa, trenGodina, status);
		TabbedPanel.tabelaStudenata.azurirajPrikazStudenta();

		return true;
	}
	
	
	
	
	
	
	
	public boolean proveriPopunjenostPolja() {
		
		boolean retVal = false;
		if (proveriIme(DodajStudentaDialog.txtPrezime.getText().trim())
				&& proveriIme(DodajStudentaDialog.txtIme.getText().trim())
				&& proveriDatum(DodajStudentaDialog.txtDatumRodjenja.getText().trim())
				&& proveriAdresu(DodajStudentaDialog.txtAdresaStanovanja.getText().trim())
				&& proveriBrTelefona(DodajStudentaDialog.txtBrojTelefona.getText().trim())
				&& proveriEmail(DodajStudentaDialog.txtEmailAdresa.getText().trim())
				&& proveriGodUpisa(DodajStudentaDialog.txtGodUpisa.getText().trim())
				&& proveriBrIndeksa(DodajStudentaDialog.txtBrIndeksa.getText().trim())
				) {
			retVal = true;
		}
		if (DodajStudentaDialog.txtPrezime.getText().trim().equals("Ime")
				|| DodajStudentaDialog.txtIme.getText().trim().equals("Prezime")
				|| DodajStudentaDialog.txtDatumRodjenja.getText().trim().equals("dd.mm.yyyy.")
				|| DodajStudentaDialog.txtAdresaStanovanja.getText().trim().equals("Adresa, 123")
				|| DodajStudentaDialog.txtBrojTelefona.getText().trim().equals("06123123123")
				|| DodajStudentaDialog.txtEmailAdresa.getText().trim().equals("primer@primer.com")
				|| DodajStudentaDialog.txtGodUpisa.getText().trim().equals("1900") 
				|| DodajStudentaDialog.txtBrIndeksa.getText().trim().equals("NZ123") 
				) {
			retVal = false;
		}
		return retVal;		
		
	
	  }
	
	
	public boolean proveriPopunjenostIzmenjenihPolja() {
		
		boolean retVal = false;
		if (proveriIme(IzmeniStudentaDialog.txtPrezime.getText().trim())
				&& proveriIme(IzmeniStudentaDialog.txtIme.getText().trim())
				&& proveriDatum(IzmeniStudentaDialog.txtDatumRodjenja.getText().trim())
				&& proveriAdresu(IzmeniStudentaDialog.txtAdresaStanovanja.getText().trim())
				&& proveriBrTelefona(IzmeniStudentaDialog.txtBrojTelefona.getText().trim())
				&& proveriEmail(IzmeniStudentaDialog.txtEmailAdresa.getText().trim())
				&& proveriGodUpisa(IzmeniStudentaDialog.txtGodUpisa.getText().trim())
				&& proveriBrIndeksa(IzmeniStudentaDialog.txtBrIndeksa.getText().trim())
				) {
			retVal = true;
		}
		if (IzmeniStudentaDialog.txtPrezime.getText().trim().equals("Ime")
				|| IzmeniStudentaDialog.txtIme.getText().trim().equals("Prezime")
				|| IzmeniStudentaDialog.txtDatumRodjenja.getText().trim().equals("dd.mm.yyyy.")
				|| IzmeniStudentaDialog.txtAdresaStanovanja.getText().trim().equals("Adresa, 123")
				|| IzmeniStudentaDialog.txtBrojTelefona.getText().trim().equals("06123123123")
				|| IzmeniStudentaDialog.txtEmailAdresa.getText().trim().equals("primer@primer.com")
				|| IzmeniStudentaDialog.txtGodUpisa.getText().trim().equals("1900") 
				|| IzmeniStudentaDialog.txtBrIndeksa.getText().trim().equals("NZ123") 
				) {
			retVal = false;
		}
		return retVal;		
	}
	
	
	
	
	/**REFERENCA: https://www.freeformatter.com/java-regex-tester.html#ad-output */
	


	public boolean proveriEmail(String eMail) {
		if( eMail.isEmpty() ) {
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
		if( telefon.isEmpty() ) {
			return false;
		}
		
		boolean retVal = true;
		Pattern patern = Pattern.compile("\\+?\\d[\\d\\s]{6,15}\\d");
		Matcher matcher = patern.matcher(telefon);
		retVal = matcher.matches();

		return retVal;
	}
	
	


	public boolean proveriAdresu(String adresa) {
		if( adresa.isEmpty() ) {
			
			return false;
		}
		boolean retVal = true;
		Pattern patern = Pattern.compile("[a-zA-ZÅ¡Å Ä‘Ä�Ä�ÄŒÄ‡Ä†Å¾Å½0-9',. -]+");
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
		if ( ime.isEmpty() ) {
			return false;
		}
		
		boolean retVal = true;
		Pattern patern = Pattern.compile("^[a-zA-ZÅ¡Å Ä‘Ä�Ä�ÄŒÄ‡Ä†Å¾Å½]+(([',. -][a-zA-ZÅ¡Å Ä‘Ä�Ä�ÄŒÄ‡Ä†Å¾Å½ ])?[a-zA-ZÅ¡Å Ä‘Ä�Ä�ÄŒÄ‡Ä†Å¾Å½]*)*$");
		Matcher matcher = patern.matcher(ime);
		retVal = matcher.matches();

		return retVal;
	}
	
	
	
	public boolean proveriBrIndeksa(String brIndeksa) {
		if ( brIndeksa.isEmpty() ) {
			return false;
		}
		
		
		boolean retVal = true;
		Pattern patern = Pattern.compile("^[A-Z]{1,4}[0-9]{1,4}"); 
		Matcher matcher = patern.matcher(brIndeksa);
		retVal = matcher.matches();

		return retVal;
	}
	
	
	
	public boolean proveriGodUpisa(String godUpisa) {
		if ( godUpisa.isEmpty() ) {
			return false;
		}
		
		
		boolean retVal = true;
		Pattern patern = Pattern.compile("^\\d{4}$");
		Matcher matcher = patern.matcher(godUpisa);
		retVal = matcher.matches();

		return retVal;
	}
	
	
	
}
