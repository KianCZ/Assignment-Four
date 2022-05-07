
/*
 * Class: CMSC203 CRN 36406
 Program: Assignment 4
 Instructor: Farnaz Eivazi
 Summary of Description: Encrypts and decrypts text using two different methods
 Due Date: 4/6/2022
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kian Charkhabi
 */
import javafx.scene.layout.Region;

public class ManagementCompany {
	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;

	ManagementCompany() {
		this.properties = new Property[MAX_PROPERTY];
	}

	ManagementCompany(String name, String taxID, double mgmFee) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot=new Plot(0,0,10,10);
	}

	ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot=new Plot(width,depth,x,y);
		this.plot.setWidth(width);
		this.plot.setDepth(depth);
		this.plot.setX(x);
		this.plot.setY(y);
	}

	ManagementCompany(ManagementCompany otherCompany) {

	}

	public int getMAX_PROPERTY() {
		return this.MAX_PROPERTY;
	}

	public int addProperty(Property property) {
		int f = 0;

		if (property == null) {
			return -2;
		}
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if(property!=null&&properties[i]!=null) {
				if (properties[i].getPlot().encompasses(property.getPlot())) {
					return -4;
				}
			}
		}
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] == null) {
				properties[i] = property;
				return i;
			}
		}
		if (properties[MAX_PROPERTY - 1] != null) {
			return -1;
		}
		if (plot.encompasses(property.getPlot())) {
			return -3;
		}
		return f;
	}

	public int addProperty(String name, String city, double rent, String owner) {
		Property p=new Property(name,city,rent,owner);
		return addProperty(p);
	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property p = new Property(name, city, rent, owner, x, y, depth, width);
		return addProperty(p);
	}

	public double totalRent() {
		double d = 0;
		for (int i = 0; i < this.MAX_PROPERTY; i++) {
			if(properties[i]==null) {
				return d;
			}
			d += this.properties[i].getRentAmount();
		}
		return d;
	}

	public double maxRentProp() {
		double d = this.properties[0].getRentAmount();
		int a = 0;
		for (int i = 0; i < this.MAX_PROPERTY; i++) {
			if(properties[i]==null) {
				return d;
			}
			if (d < this.properties[i].getRentAmount()) {
				d = this.properties[i].getRentAmount();
				a = i;
			}
		}
		return d;
	}

	private int maxRentPropertyIndex() {
		double d = this.properties[0].getRentAmount();
		int a = 0;
		for (int i = 0; i < this.MAX_PROPERTY; i++) {
			if (d < this.properties[i].getRentAmount()) {
				d = this.properties[i].getRentAmount();
				a = i;
			}
		}
		return a;
	}

	private String displayPropertyAtIndex(int i) {
		return this.properties[i].toString();
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < this.MAX_PROPERTY; i++) {
			s += displayPropertyAtIndex(i)+"\n";
		}
		return "List of the properties for " + this.name + ", taxID: " + this.taxID
				+ "\n ______________________________________________________\n" + s
				+ "\n ______________________________________________________\ntotal management Fee: "
				+ (totalRent() * this.mgmFeePer);
	}

	public String getName() {
		return this.name;
	}

	public Plot getPlot() {
		return this.plot;
	}
}
