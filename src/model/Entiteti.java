package model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.TimeZone;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Entiteti {

	private static Entiteti instance = null;

	public static Entiteti getInstance() {
		if (instance == null) {
			instance = new Entiteti();
		}
		return instance;
	}

	ArrayList<Predmet> predmeti;
	ArrayList<Profesor> profesori;
	ArrayList<Student> studenti;

	private Entiteti() {
	}

	public void serializeToXML() throws IOException {
		this.predmeti = BazaPredmeta.getInstance().getPredmeti();
		this.profesori = BazaProfesora.getInstance().getProfesori();
		this.studenti = BazaStudent.getInstance().getStudenti();
		File f = new File("data" + File.separator + "entiteti.xml");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
		try {
			XStream xs = new XStream();
			xs.registerConverter(new DateConverter(TimeZone.getDefault()));
			xs.alias("ENTITETI", Entiteti.class);
			xs.alias("predmet", Predmet.class);
			xs.alias("profesor", Profesor.class);
			xs.alias("student", Student.class);
			xs.toXML(this, os);
		} finally {
			os.close();
		}
	}

	public void desrializeToXML() throws IOException {
		File f = new File("data" + File.separator + "entiteti.xml");
		XStream xsd = new XStream();
		XStream.setupDefaultSecurity(xsd);
		xsd.addPermission(AnyTypePermission.ANY);
		xsd.alias("ENTITETI", Entiteti.class);
		xsd.alias("predmet", Predmet.class);
		xsd.alias("profesor", Profesor.class);
		xsd.alias("student", Student.class);

		Entiteti e = (Entiteti) xsd.fromXML(new FileInputStream(f));

		this.profesori = e.profesori;
		this.predmeti = e.predmeti;
		this.studenti = e.studenti;

	}

}
