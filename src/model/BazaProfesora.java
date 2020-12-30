package model;

import java.util.ArrayList;
import java.util.Date;

import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class BazaProfesora {

	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private ArrayList<Profesor> profesori;
	private ArrayList<String> kolone;

	private BazaProfesora() {
		initProfesore();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}

	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getColumnCount() {
		return kolone.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			if (profesor.getTitula() == Titula.DoktorProfesor) {
				return "Doktor Profesor";
			}
			return profesor.getTitula().toString();
		case 3:
			if (profesor.getZvanje() == Zvanje.RedovniProfesor) {
				return "Redovni Profesor";
			}
			if (profesor.getZvanje() == Zvanje.VanredniProfesor) {
				return "Vanredni Profesor";
			}
			return profesor.getZvanje().toString();
		default:
			return null;
		}
	}

	public boolean dodajProfesora(Profesor profesor) {
		for (Profesor p : profesori) {
			if (p.getBrojLicne().equals(profesor.getBrojLicne())) {
				return false;
			}
		}
		profesori.add(profesor);
		return true;
	}

	public void izmeniProfesora(String ime, String prezime, Date datumRodjenja, String adresa, String telefon,
			String eMail, String adresaKancelarije, String brojLicne, Titula titula, Zvanje zvanje) {
		for (Profesor p : profesori) {
			if (p.getBrojLicne().equals(brojLicne)) {
				p.setIme(ime);
				p.setPrezime(prezime);
				p.setDatumRodjenja(datumRodjenja);
				p.setAdresa(adresa);
				p.setTelefon(telefon);
				p.seteMail(eMail);
				p.setAdresaKancelarije(adresaKancelarije);
				p.setTitula(titula);
				p.setZvanje(zvanje);
			}
		}
	}

}
