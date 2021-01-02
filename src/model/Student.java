package model;

import java.util.ArrayList;
import java.util.Date;

public class Student {
	
	public enum Status { B, S };
	public enum TrenutnaGodina { PRVA, DRUGA, TRECA, CETVRTA };

	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresa;
	private String telefon;
	private String eMail;
	private String brIndeksa;
	private String godUpisa;
	private TrenutnaGodina trenGodina;
	private Status statusStudenta;
	private double prosecnaOcjena;
	private ArrayList<Ocena> spisakPolozenihIspita;
	private ArrayList<Predmet> spisakNePolozenihIspita;
	

	public Student(String prezime, String ime, Date datumRodjenja, String adresa, String telefon, String eMail,
			String brIndeksa, String godUpisa, TrenutnaGodina trenGodina, Status statusStudenta, double prosecnaOcjena,
			ArrayList<Ocena> spisakPolozenihIspita, ArrayList<Predmet> spisakNePolozenihIspita) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.telefon = telefon;
		this.eMail = eMail;
		this.brIndeksa = brIndeksa;
		this.godUpisa = godUpisa;
		this.trenGodina = trenGodina;
		this.statusStudenta = statusStudenta;
		this.prosecnaOcjena = prosecnaOcjena;
		this.spisakPolozenihIspita = spisakPolozenihIspita;
		this.spisakNePolozenihIspita = spisakNePolozenihIspita;
		
		
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
	
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public void setDatumRodjenja(Date datumRodjenja) {
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
	
	public String getBrIndeksa() {
		return brIndeksa;
	}
	
	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}
	
	public String getGodUpisa() {
		return godUpisa;
	}
	
	public void setGodUpisa(String godUpisa) {
		this.godUpisa = godUpisa;
	}
	
	public TrenutnaGodina getTrenGodina() {
		return trenGodina;
	}
	
	public void setTrenGodina(TrenutnaGodina trenGodina) {
		this.trenGodina = trenGodina;
	}
	
	public Status getStatusStudenta() {
		return statusStudenta;
	}
	
	public void setStatusStudenta(Status statusStudenta) {
		this.statusStudenta = statusStudenta;
	}
	
	public double getProsecnaOcjena() {
		return prosecnaOcjena;
	}
	
	public void setProsecnaOcjena(double prosecnaOcjena) {
		this.prosecnaOcjena = prosecnaOcjena;
	}

	
	
	
	public ArrayList<Ocena> getSpisakPolozenihIspita() {
		return spisakPolozenihIspita;
	}

	public void setSpisakPolozenihIspita(ArrayList<Ocena> spisakPolozenihIspita) {
		this.spisakPolozenihIspita = spisakPolozenihIspita;
	}

	public ArrayList<Predmet> getSpisakNePolozenihIspita() {
		return spisakNePolozenihIspita;
	}

	public void setSpisakNePolozenihIspita(ArrayList<Predmet> spisakNePolozenihIspita) {
		this.spisakNePolozenihIspita = spisakNePolozenihIspita;
	}
	


}
