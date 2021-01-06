package model;

import java.util.ArrayList;

public class Predmet {

	public enum Semestar { Letnji, Zimski };

	private String sifraPredmeta;
	private String naziv;
	private Semestar semestar;
	private int godina;
	private Profesor predmetniProfesor;
	private int brojESPB;
	private ArrayList<Student> studPolozili;
	private ArrayList<Student> studNisuPolozili;
	
	public Predmet() {
		super();
	}

	public Predmet(String sifraPredmeta, String naziv, Semestar semestar, int godina, Profesor predmetniProfesor,
			int brojESPB, ArrayList<Student> studPolozili, ArrayList<Student> studNisuPolozili) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		this.predmetniProfesor = predmetniProfesor;
		this.brojESPB = brojESPB;
		this.studPolozili = studPolozili;
		this.studNisuPolozili = studNisuPolozili;
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	public int getBrojESPB() {
		return brojESPB;
	}

	public void setBrojESPB(int brojESPB) {
		this.brojESPB = brojESPB;
	}

	public ArrayList<Student> getStudPolozili() {
		return studPolozili;
	}

	public void setStudPolozili(ArrayList<Student> studPolozili) {
		this.studPolozili = studPolozili;
	}

	public ArrayList<Student> getStudNisuPolozili() {
		return studNisuPolozili;
	}

	public void setStudNisuPolozili(ArrayList<Student> studNisuPolozili) {
		this.studNisuPolozili = studNisuPolozili;
	}
	
}
