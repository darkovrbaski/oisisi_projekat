package model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Profesor.Titula;
import model.Profesor.Zvanje;
import view.ToolBar;

public class BazaProfesora {

	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private ArrayList<Profesor> profesori;
	private ArrayList<Profesor> sacuvaniProfesori;
	private ArrayList<String> kolone;
	private ArrayList<String> kolonePredmeta;

	private BazaProfesora() {
		initProfesore();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
		this.kolonePredmeta = new ArrayList<String>();
		this.kolonePredmeta.add("Šifra");
		this.kolonePredmeta.add("Naziv");
		this.kolonePredmeta.add("Godina studija");
		this.kolonePredmeta.add("Semestar");
	}

	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		Date d = new Date();
		profesori.add(new Profesor("AA", "AP", d, "afsa", "41253463663", "q@q", "faefwggw", "123456789", Titula.DoktorProfesor, Zvanje.RedovniProfesor, new ArrayList<Predmet>()));
		profesori.add(new Profesor("AB", "AP", d, "afsa", "41253463663", "q@q", "faefwggw", "123426789", Titula.DoktorProfesor, Zvanje.RedovniProfesor, new ArrayList<Predmet>()));
		profesori.add(new Profesor("P", "P", d, "bfsa", "41253463662", "q@q", "faefwggw", "123456788", Titula.Doktor, Zvanje.VanredniProfesor, new ArrayList<Predmet>()));
		profesori.add(new Profesor("BP", "BP", d, "cfsa", "31253463663", "q@q", "faefwggw", "123456787", Titula.Master, Zvanje.Asistent, new ArrayList<Predmet>()));
		this.sacuvaniProfesori = this.profesori;
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public ArrayList<Predmet> getPredmeti(Profesor profesor) {
		return profesor.getSpisakPredmeta();
	}

	public void setPredmeti(Profesor profesor, ArrayList<Predmet> predmeti) {
		profesor.setSpisakPredmeta(predmeti);
	}
	
	public int getColumnCount() {
		return kolone.size();
	}
	
	public int getColumnCountPredmeti() {
		return kolonePredmeta.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public String getColumnNamePredmeti(int index) {
		return this.kolonePredmeta.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	public Predmet getRowPredmet(Profesor profesor, int rowIndex) {
		return profesor.getSpisakPredmeta().get(rowIndex);
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
	
	public String getValueAtPredmeti(Profesor profesor, int row, int column) {
		Predmet predmet = profesor.getSpisakPredmeta().get(row);
		switch (column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNaziv();
		case 2:
			return "" + predmet.getGodina();
		case 3:
			return predmet.getSemestar().toString();
		default:
			return null;
		}
	}

	public boolean dodajProfesora(Profesor profesor) {
		this.profesori = this.sacuvaniProfesori;
		for (Profesor p : profesori) {
			if (p.getBrojLicne().equals(profesor.getBrojLicne())) {
				return false;
			}
		}
		profesori.add(profesor);
		this.sacuvaniProfesori = this.profesori;
		pretragaProfesora();
		return true;
	}
	
	
	public void izbrisiPredmetSaP(Profesor profesor, Predmet predmet) {
		for (Profesor p : profesori) {
			if (p.getBrojLicne().equals(profesor.getBrojLicne())) {
				p.getSpisakPredmeta().remove(predmet);
				break;
			}
		}
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
		pretragaProfesora();
	}
	
	public void izbrisiPredmet(Predmet predmet) {
		for (Profesor prof : profesori) {
			for (Predmet p : prof.getSpisakPredmeta()) {
				if (p.getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
					prof.getSpisakPredmeta().remove(p);
					break;
				}
			}
		}
	}
	
	
	public void izbrisiProfesora(Profesor profesor) {
		for (Profesor p : profesori) {
			if (p.getBrojLicne().equals(profesor.getBrojLicne())) {
				profesori.remove(p);
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	public ArrayList<Predmet> getPredmetiKojeNePredaje(Profesor profesor) {
		ArrayList<Predmet> predmeti = new ArrayList<Predmet>(BazaPredmeta.getInstance().getPredmeti());
		predmeti.removeAll(profesor.getSpisakPredmeta());
		return predmeti;
	}
	
	public void dodajPredmetePofesoru(Profesor profesor, ArrayList<Predmet> predmeti) {
		profesor.getSpisakPredmeta().addAll(predmeti);
	}

	public void pretragaProfesora() {
		this.profesori = this.sacuvaniProfesori;
		String textPretrage = ToolBar.searchField.getText().trim().toLowerCase();
		ArrayList<Profesor> pretrazeniProfesori = new ArrayList<Profesor>();
		
		if (textPretrage.isEmpty() == true) {
			return;
		}
		
		if (textPretrage.contains(" ") == false) {
			for (Profesor p : this.profesori) {
				if (p.getPrezime().toLowerCase().contains(textPretrage)) {
					pretrazeniProfesori.add(p);
				}
			}
		} else {
			String[] parts = textPretrage.split(" ", 2);
			String prezime = parts[0];
			String ime = parts[1];
			if (ime.contains(" ")) {
				JOptionPane.showMessageDialog(null, "Kriterijum pretrage je: \n'Prezime' 'Ime'", "GREŠKA", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				for (Profesor p : this.profesori) {
					if (p.getPrezime().toLowerCase().contains(prezime)) {
						if (p.getIme().toLowerCase().contains(ime)) {
							pretrazeniProfesori.add(p);
						}
					}
				}
			}
		}
		this.profesori = pretrazeniProfesori;
	}

}
