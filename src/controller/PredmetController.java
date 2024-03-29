package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudent;
import model.Predmet;
import model.Predmet.Semestar;
import model.Profesor.Titula;
import model.Profesor.Zvanje;
import model.Student.Status;
import model.Student.TrenutnaGodina;
import model.Profesor;
import model.Student;
import view.TabbedPanel;
import view.dialogs.DodajPredmetDialog;
import view.dialogs.DodajStudentaDialog;
import view.dialogs.IzmeniPredmetDialog;
import view.dialogs.IzmeniProfesoraDialog;
import view.dialogs.IzmeniStudentaDialog;
import view.dialogs.UpitPotvrdeDialog;

public class PredmetController {

	private static PredmetController instance;

	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}

	private PredmetController() {
	}
	
	public void dodajPredmet() {
		@SuppressWarnings("unused")
		DodajPredmetDialog dialog = new DodajPredmetDialog();
	}
	
	public void izmeniPredmet() {
		@SuppressWarnings("unused")
		IzmeniPredmetDialog dialog = new IzmeniPredmetDialog();
	}

	public void izbrisiPredmet() {
		UpitPotvrdeDialog dialog = new UpitPotvrdeDialog("Brisanje predmeta",
				"Da li ste sigurni da želite da obrišete predmet?");
		if (dialog.isYes() == true) {
			Predmet predmet = BazaPredmeta.getInstance().getRow(TabbedPanel.tabelaPredmeta.getCurrentSelectedRow());
			BazaPredmeta.getInstance().izbrisiPredmet(predmet);
			TabbedPanel.tabelaPredmeta.azurirajPrikaz();
			BazaProfesora.getInstance().izbrisiPredmet(predmet);
			// TODO: azuriraj predmete u profesoru
			BazaStudent.getInstance().izbrisiPredmet(predmet);
			// TODO: azuriraj predmete u studentu
		}
	}

	public boolean proveriPredmet() {
		boolean retVal = true;
		String sifraPredmeta;
		String naziv;
		int brojESPB;
		int godina;
	
		Profesor predmetniProfesor = null;
		
		Semestar semestar;
		
	    ArrayList<Student> studPolozili = new ArrayList<Student>();
		ArrayList<Student> studNisuPolozili = new ArrayList<Student>();
		
		
		
		sifraPredmeta = DodajPredmetDialog.txtSifraPredmeta.getText().trim();
		naziv = DodajPredmetDialog.txtNaziv.getText().trim();
	
		
		String brojESPBStr = DodajPredmetDialog.txtBrojESPB .getText().trim();
		String godinaStr = DodajPredmetDialog.txtGodina .getText().trim();
		
		brojESPB = Integer.parseInt(brojESPBStr);  
		godina = Integer.parseInt(godinaStr);
		
		
		


		 //{ "Letnji", "Zimski" };
		switch (DodajPredmetDialog.cbSemestar.getSelectedItem().toString()) {
		case "Letnji":
			semestar = Semestar.Letnji;
			break;
		case "Zimski":
			semestar = Semestar.Zimski;
			break;
		default:
			semestar = null;
			retVal = false;
			break;
		}
		
			
			Predmet predmet = new Predmet(sifraPredmeta, naziv, semestar, godina, predmetniProfesor, brojESPB, studPolozili, studNisuPolozili);

			
			retVal = BazaPredmeta.getInstance().dodajPredmet(predmet);
			if (retVal == false) {
				JOptionPane.showMessageDialog(null, "Predmet sa unetom sifrom vec postoji. ", "GREÃ…Â KA",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		
	
		TabbedPanel.tabelaPredmeta.azurirajPrikaz();
			
		return true;
	}
	
	
	
	
	// TODO: napisati ovu metodu
	public boolean proveriIzmenuPredmeta() {
		String sifraPredmeta;
		String naziv;
		int brojESPB;
		int godina;
		Semestar semestar;
		
		sifraPredmeta = IzmeniPredmetDialog.txtSifraPredmeta.getText().trim();
		naziv = IzmeniPredmetDialog.txtNaziv.getText().trim();
		
		
		// konverzija
		String brojESPBStr = IzmeniPredmetDialog.txtBrojESPB .getText().trim();
		String godinaStr = IzmeniPredmetDialog.txtGodina .getText().trim();
		
		brojESPB = Integer.parseInt(brojESPBStr);  
		godina = Integer.parseInt(godinaStr);
		//---------------
		 
		switch (IzmeniPredmetDialog.cbSemestar.getSelectedItem().toString()) {
		case "Letnji":
			semestar = Semestar.Letnji;
			break;
		case "Zimski":
			semestar = Semestar.Zimski;
			break;
		default:
			semestar = null;
			return false;
		}
		
		
		BazaPredmeta.getInstance().izmeniPredmet(sifraPredmeta, naziv, brojESPB, godina, semestar);
		
		
		TabbedPanel.tabelaPredmeta.azurirajPrikaz();

		return true;	
	}
	
	
	

	
	
	public boolean proveriPopunjenostIzmenjenihPoljaPredmeta() {
		boolean retVal = false;
		if (proveriNaziv(IzmeniPredmetDialog.txtNaziv.getText().trim())
				&& proveriSifruPredmeta(IzmeniPredmetDialog.txtSifraPredmeta.getText().trim())
				&& proveriBrojESPB(IzmeniPredmetDialog.txtBrojESPB.getText().trim())
				&& proveriGodina(IzmeniPredmetDialog.txtGodina.getText().trim())) {
			retVal = true;
		}
		if (IzmeniPredmetDialog.txtNaziv.getText().trim().equals("Naziv")
				|| IzmeniPredmetDialog.txtSifraPredmeta.getText().trim().equals("Sifra predmeta")
				|| IzmeniPredmetDialog.txtBrojESPB.getText().trim().equals("Broj ESPB")
				
				|| IzmeniPredmetDialog.txtGodina.getText().trim().equals("Godina")
				
				) {
			retVal = false;
		}
		return retVal;
	}
	
	
		
	
	public boolean proveriPopunjenostPolja() {
		boolean retVal = false;
		if (proveriNaziv(DodajPredmetDialog.txtNaziv.getText().trim())
				&& proveriSifruPredmeta(DodajPredmetDialog.txtSifraPredmeta.getText().trim())
				&& proveriBrojESPB(DodajPredmetDialog.txtBrojESPB.getText().trim())
				&& proveriGodina(DodajPredmetDialog.txtGodina.getText().trim())

				) {
			retVal = true;
		} 
		if (DodajPredmetDialog.txtNaziv.getText().trim().equals("Naziv")
				|| DodajPredmetDialog.txtSifraPredmeta.getText().trim().equals("Sifra predmeta")
				|| DodajPredmetDialog.txtBrojESPB.getText().trim().equals("Broj ESPB")
				|| DodajPredmetDialog.txtGodina.getText().trim().equals("Godina")

				) {
			retVal = false;
		}
		return retVal;	
	}
	
	
	
	
	
	public boolean proveriNaziv(String naziv) {
		if ( naziv.isEmpty() ) {
			return false;
		}
		
		boolean retVal = true;
		Pattern patern = Pattern.compile("^[a-zA-ZÅ¡Å Ä‘Ä�Ä�ÄŒÄ‡Ä†Å¾Å½]+(([',. -][a-zA-ZÅ¡Å Ä‘Ä�Ä�ÄŒÄ‡Ä†Å¾Å½ ])?[a-zA-ZÅ¡Å Ä‘Ä�Ä�ÄŒÄ‡Ä†Å¾Å½]*)*$");
		Matcher matcher = patern.matcher(naziv);
		retVal = matcher.matches();

		return retVal;
	}
	
	
	
	public boolean proveriSifruPredmeta(String sifraPredmeta) {
		if( sifraPredmeta.isEmpty() ) {
			
			return false;
		}
		boolean retVal = true;
		Pattern patern = Pattern.compile("[a-zA-ZÅ¡Å Ä‘Ä�Ä�ÄŒÄ‡Ä†Å¾Å½0-9',. -]+");
		Matcher matcher = patern.matcher(sifraPredmeta);
		retVal = matcher.matches();

		return retVal;
	}
	
	
	
	
	
	public boolean proveriBrojESPB(String brojESPB) {
		if( brojESPB.isEmpty() ) {
			return false;
		}
		
		boolean retVal = true;
		Pattern patern = Pattern.compile("^[0-9]{1,3}");
		Matcher matcher = patern.matcher(brojESPB);
		retVal = matcher.matches();

		return retVal;
	}
	
	
	
	public boolean proveriGodina(String godina) {
		if( godina.isEmpty() ) {
			return false;
		}
		
		boolean retVal = true;
		Pattern patern = Pattern.compile("^[0-9]{1,2}");
		Matcher matcher = patern.matcher(godina);
		retVal = matcher.matches();

		return retVal;
	}
	
	public void pretragaPredmeta() {
		BazaPredmeta.getInstance().pretragaPredmeta();
		TabbedPanel.tabelaPredmeta.azurirajPrikaz();
	}

	public void uklanjanjeProfesoraPredmetu(Predmet predmet) {
		if (predmet.getPredmetniProfesor() == null) {
			return;
		}
		UpitPotvrdeDialog dialog = new UpitPotvrdeDialog("Ukloni Profesora", "Da li ste sigurni?");
		if (dialog.isYes() == true) {
			predmet.getPredmetniProfesor().getSpisakPredmeta().remove(predmet);
			predmet.setPredmetniProfesor(null);
		}
	}
	
}
