package model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Predmet.Semestar;

import view.ToolBar;

import model.Profesor.Titula;
import model.Profesor.Zvanje;


public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private ArrayList<Predmet> predmeti;
	private ArrayList<Predmet> sacuvaniPredmeti;
	private ArrayList<String> kolone;

	private BazaPredmeta() {
		initPredmete();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
	}

	private void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet("123", "Aa", Semestar.Letnji, 1, null, 6, new ArrayList<Student>(), new ArrayList<Student>()));
		predmeti.add(new Predmet("124", "Ab", Semestar.Zimski, 2, null, 9, new ArrayList<Student>(), new ArrayList<Student>()));
		predmeti.add(new Predmet("125", "Aca", Semestar.Letnji, 3, null, 9, new ArrayList<Student>(), new ArrayList<Student>()));
		this.sacuvaniPredmeti = this.predmeti;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return kolone.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNaziv();
		case 2:
			return "" + predmet.getBrojESPB();
		case 3:
			return "" + predmet.getGodina();
		case 4:
			return predmet.getSemestar().toString();
		default:
			return null;
		}
	}
	
	
	public boolean dodajPredmet(Predmet predmet) {
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
				return false;
			}
		}
		predmeti.add(predmet);
		return true;
	}
	
	
	
	
	public void izmeniPredmet(String sifraPredmeta, String naziv, int brojESPB,
							int godina, Semestar semestar) {
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(sifraPredmeta)) {
				p.setNaziv(naziv);;
				p.setBrojESPB(brojESPB);
				p.setGodina(godina);
				p.setSemestar(semestar);
			
			}
		}
	}
	
	
	
	public void izbrisiStudenta(Student student) {
		for (Predmet p : predmeti) {
			for (Student s : p.getStudNisuPolozili()) { 
				if (s.getBrIndeksa().equals(student.getBrIndeksa())) {
					p.getStudNisuPolozili().remove(p);
					break;
				}
			}
			
			
			for (Student s : p.getStudPolozili()) { 
				if (s.getBrIndeksa().equals(student.getBrIndeksa())) {
					p.getStudPolozili().remove(p);
					break;
				}
			}
		}
		
	}
	
	
	
	
	
	
	public void izbrisiPredmet(Predmet predmet) {
		this.predmeti = this.sacuvaniPredmeti;
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
				predmeti.remove(p);
				break;
			}
		}
		this.sacuvaniPredmeti = this.predmeti;
		pretragaPredmeta();
	}

	public void pretragaPredmeta() {
		this.predmeti = this.sacuvaniPredmeti;
		String textPretrage = ToolBar.searchField.getText().trim().toLowerCase();
		ArrayList<Predmet> pretrazeniPredmeti = new ArrayList<Predmet>();
		
		if (textPretrage.isEmpty() == true) {
			return;
		}
		
		if (textPretrage.contains(" ") == false) {
			for (Predmet p : this.predmeti) {
				if (p.getNaziv().toLowerCase().contains(textPretrage)) {
					pretrazeniPredmeti.add(p);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Kriterijum pretrage je: \n'Naziv predmeta'", "GREŠKA", JOptionPane.ERROR_MESSAGE);
			return;
		}
		this.predmeti = pretrazeniPredmeti;
	}

}
