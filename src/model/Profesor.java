package model;

import java.util.ArrayList;

public class Profesor {
	
	public enum Titula { ProfDr, Dr, Ms };
	public enum Zvanje { Asistent, Docent, VanredniProfesor, RedovniProfesor };
	
	private String prezime;
	private String ime;
	private String datumRodjenja;
	private String adresa;
	private String telefon;
	private String eMail;
	private String adresaKancelarije;
	private String brojLicne;
	private Titula titula;
	private Zvanje zvanje;
	private ArrayList<Predmet> spisakPredmeta;

	public Profesor() {
		super();
	}

	public Profesor(String ime, String prezime, String datumRodjenja, String adresa, String telefon, String eMail,
			String adresaKancelarije, String brojLicne, Titula titula, Zvanje zvanje, ArrayList<Predmet> spisakPredmeta) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.telefon = telefon;
		this.eMail = eMail;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicne = brojLicne;
		this.titula = titula;
		this.zvanje = zvanje;
		this.spisakPredmeta = spisakPredmeta;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrojLicne() {
		return brojLicne;
	}

	public void setBrojLicne(String brojLicne) {
		this.brojLicne = brojLicne;
	}

	public Titula getTitula() {
		return titula;
	}

	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<Predmet> getSpisakPredmeta() {
		return spisakPredmeta;
	}

	public void setSpisakPredmeta(ArrayList<Predmet> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}

}
