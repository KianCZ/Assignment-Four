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
	private int MAX_PROPERTY=5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MGMT_WIDTH=10;
	private int MGMT_DEPTH=10;
	private Plot plot;
	ManagementCompany(){
		this.properties=new Property[MAX_PROPERTY];
	}
	ManagementCompany(String name, String taxID, double mgmFee){
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
	}
	ManagementCompany(String name, String taxID, double mgmFee,int x,int y, int width, int depth){
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
		this.plot.setWidth(width);
		this.plot.setDepth(depth);
		this.plot.setX(x);
		this.plot.setY(y);
	}
	ManagementCompany(ManagementCompany otherCompany){
		
	}
	public int getMAX_PROPERTY() {
		return this.MAX_PROPERTY;
	}
	public int addProperty(Property property) {
		if(property==null) {
			return -2;
		}
		if(!plot.equals(property.getPlot())) {
			return -3;
		}
		for(int i=0;i<MAX_PROPERTY;i++) {
			if(this.properties[i].getPlot().equals(property.getPlot())) {
				return -4;
			}
			if(this.properties[i]==null) {
				this.properties[i]=property;
				return i;
			}
		}
		return -1;
	}
	public int addProperty(String name,String city,double rent, String owner) {
		Property p=new Property(name,city,rent,owner);
		if(name==null||city==null||owner==null||p==null) {
			return -2;
		}
		if(!plot.equals(p.getPlot())) {
			return -3;
		}
		for(int i=0;i<MAX_PROPERTY;i++) {
			if(this.properties[i].getPlot().equals(p.getPlot())){
				return -4;
			}
			if(this.properties[i]==null) {
				this.properties[i]=new Property(p);
				return i;
			}
		}
		return -1;
	}
	public int addProperty(String name,String city,double rent, String owner,int x,int y,
			int width,int depth) {
		Property p=new Property(name,city,rent,owner,x,y,depth,width);
		if(name==null||city==null||owner==null||p==null) {
			return -2;
		}
		if(!plot.equals(p.getPlot())) {
			return -3;
		}
		for(int i=0;i<MAX_PROPERTY;i++) {
			if(this.properties[i].getPlot().equals(p.getPlot())){
				return -4;
			}
			if(this.properties[i]==null) {
				this.properties[i]=new Property(p);
				return i;
			}
		}
		return -1;
		
	}
	public double totalRent() {
		double d=0;
		for(int i=0;i<this.MAX_PROPERTY;i++) {
			d+=this.properties[i].getRentAmount();
		}
		return d;
	}
	public double maxRentProp() {
		double d=this.properties[0].getRentAmount();
		int a=0;
		for(int i=0;i<this.MAX_PROPERTY;i++) {
			if(d<this.properties[i].getRentAmount()) {
				d=this.properties[i].getRentAmount();
				a=i;
			}
		}
		return d;
	}
	private int maxRentPropertyIndex() {
		double d=this.properties[0].getRentAmount();
		int a=0;
		for(int i=0;i<this.MAX_PROPERTY;i++) {
			if(d<this.properties[i].getRentAmount()) {
				d=this.properties[i].getRentAmount();
				a=i;
			}
		}
		return a;
	}
	private String displayPropertyAtIndex(int i) {
		return this.properties[i].toString();
	}
	@Override
	public String toString() {
		String s="";
		for(int i=0;i<this.MAX_PROPERTY;i++) {
			s+=displayPropertyAtIndex(i);
		}
		return "List of the properties for "+this.name+", taxID: "+this.taxID+
				"\n ______________________________________________________\n"+s+
				"\n ______________________________________________________\ntotal management Fee: "
				+(totalRent()*this.mgmFeePer);
	}
	public String getName() {
		return this.name;
	}
	public Plot getPlot() {
		return this.plot;
	}
}
