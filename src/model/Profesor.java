package model;

import java.util.List;

public class Profesor {

	private String prezime;
	private String ime;
	private String datumRodjenja;
	private String adresa;
	private String telefon;
	private String eMail;
	private String adresaKancelarije;
	private String brojLicne;
	private String titula;
	private String zvanje;
	private List<Predmet> spisakPredmeta;

	public Profesor() {
		super();
		this.prezime = "";
		this.ime = "";
		this.datumRodjenja = "";
		this.adresa = "";
		this.telefon = "";
		this.eMail = "";
		this.adresaKancelarije = "";
		this.brojLicne = "";
		this.titula = "";
		this.zvanje = "";
		this.spisakPredmeta = null;
	}

	public Profesor(String ime, String prezime, String datumRodjenja, String adresa, String telefon, String eMail,
			String adresaKancelarije, String brojLicne, String titula, String zvanje, List<Predmet> spisakPredmeta) {
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

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public List<Predmet> getSpisakPredmeta() {
		return spisakPredmeta;
	}

	public void setSpisakPredmeta(List<Predmet> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}

}
