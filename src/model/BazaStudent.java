package model;


import java.sql.Date;
import java.util.ArrayList;

import model.Student.Status;
import model.Student.TrenutnaGodina;


public class BazaStudent {

	private static BazaStudent instance = null;

	public static BazaStudent getInstance() {
		if (instance == null) {
			instance = new BazaStudent();
		}
		return instance;
	}

	private ArrayList<Student> studenti;
	private ArrayList<String> kolone;
	private ArrayList<String> koloneNepolozeniPredmeti;

	private BazaStudent() {
		initStudente();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
		this.koloneNepolozeniPredmeti = new ArrayList<String>();
		koloneNepolozeniPredmeti.add("Šifra predmeta");
		koloneNepolozeniPredmeti.add("Naziv predmeta");
		koloneNepolozeniPredmeti.add("ESPB");
		koloneNepolozeniPredmeti.add("Godina studija");
		koloneNepolozeniPredmeti.add("Semestar");
	}
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	public int getColumnCount() {
		return kolone.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrIndeksa();
		case 1:
			return student.getIme();
		case 2:

			return student.getPrezime();
		case 3:
			
			if (student.getTrenGodina() == TrenutnaGodina.PRVA) {
				return "Prva";
			}
			if (student.getTrenGodina() == TrenutnaGodina.DRUGA) {
				return "Druga";
			}
			if (student.getTrenGodina() == TrenutnaGodina.TRECA) {
				return "Treca";
			}
			if (student.getTrenGodina() == TrenutnaGodina.CETVRTA) {
				return "Cetvrta";
			}
			
			
			return student.getTrenGodina().toString();
			
			
		case 4:
			if (student.getStatusStudenta() == Status.B) {
				return "Budzet";
			}
			if (student.getStatusStudenta() == Status.S) {
				return "Samofinansiranje";
			}
			return student.getStatusStudenta().toString();
			
		case 5:
			double d=student.getProsecnaOcjena(); 
			String s=String.valueOf(d);  
			return s;
		
		default:
			return null;
		}
	}
	
	public boolean dodajStudenta(Student student) {
		for (Student s : studenti) {
			if (s.getBrIndeksa().equals(student.getBrIndeksa())) {
				return false;
			}
		}
		
		studenti.add(student);
		return true;
	}
	
	// TODO: PROVERITI CASTOVANJE DA LI RADI
	public void izmeniStudenta(String ime, String prezime, java.util.Date datumRodjenja, String adresa, String telefon,
			String eMail, String brojIndeksa, String godUpisa, TrenutnaGodina trenGodina, Status status) {
		for (Student s : studenti) {
			if (s.getBrIndeksa().equals(brojIndeksa)) {
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setDatumRodjenja(datumRodjenja);
				s.setAdresa(adresa);
				s.setTelefon(telefon);
				s.seteMail(eMail);
				s.setBrIndeksa(brojIndeksa);
				s.setTrenGodina(trenGodina);
				s.setStatusStudenta(status);
				
			}
		}
	}
	
	public ArrayList<Predmet> getNepolozeniPredmeti(Student student) {
		return student.getSpisakNePolozenihIspita();
	}
	
	public int getColumnCountNepolozeniPredmeti() {
		return this.koloneNepolozeniPredmeti.size();
	}
	
	public String getColumnNameNepolozeniPredmeti(int index) {
		return this.koloneNepolozeniPredmeti.get(index);
	}
	
	public String getValueAtNepolozeniPredmeti(Student student, int row, int column) {
	Predmet predmet = student.getSpisakNePolozenihIspita().get(row);
	switch (column) {
	case 0:
		return predmet.getSifraPredmeta();
	case 1:
		return predmet.getNaziv();
	case 2:
		return "" + predmet.getBrojESPB();
	case 3:
		return predmet.getGodina().toString();
	case 4:
		return predmet.getSemestar().toString();
	default:
		return null;
	}
}
	
	public void izbrisiPredmet(Predmet predmet) {
		for (Student s : studenti) {
			for (Predmet p : s.getSpisakNePolozenihIspita()) { 
				if (p.getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
					s.getSpisakNePolozenihIspita().remove(p);
					break;
				}
			}
			for (Ocena o : s.getSpisakPolozenihIspita()) {
				if (o.getTrenutniPredmet().getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
					s.getSpisakPolozenihIspita().remove(o);
					break;
				}
			}
		}
	}
	
}
