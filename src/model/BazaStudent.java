package model;


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

	private BazaStudent() {
		initStudente();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
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
			return student.getProsecnaOcjena();
		
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
	
	public void izbrisiPredmet(Predmet predmet) {
		for (Student s : studenti) {
//			for (Predmet p : s.getSpisakNePolozenihIspita()) { TODO: OTKOMENTARISATI KAD KOLEGA ISPRAVI GRESKU!
//				if (p.getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
//					s.getSpisakNePolozenihIspita().remove(p);
//					break;
//				}
//			}
			for (Ocena o : s.getSpisakPolozenihIspita()) {
				if (o.getTrenutniPredmet().getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
					s.getSpisakPolozenihIspita().remove(o);
					break;
				}
			}
		}
	}
	
}
