
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
public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	Property(){	}
	Property(Property p){
		this.propertyName=p.getPropertyName();
		this.city=p.getCity();
		this.rentAmount=p.getRentAmount();
		this.owner=p.getOwner();
		plot.setDepth(p.getPlot().getDepth());
		plot.setWidth(p.getPlot().getWidth());
		plot.setX(p.getPlot().getX());
		plot.setY(p.getPlot().getY());
	}
	Property(String propertyName,String city, double rentAmount, String owner){
		this.propertyName=propertyName;
		this.city=city;
		this.rentAmount=rentAmount;
		this.owner=owner;
		plot=new Plot(0,0,1,1);
	}
	Property(String propertyName,String city, double rentAmount, String owner,int x,
			int y,int depth,int width){
		this.propertyName=propertyName;
		this.city=city;
		this.rentAmount=rentAmount;
		this.owner=owner;
		plot=new Plot(x,y,width,depth);
	}
	public String getPropertyName() {
		return this.propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName=propertyName;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public Plot getPlot() {
		return this.plot;
	}
	public Plot setPlot(int x, int y, int width, int depth) {
		plot.setDepth(depth);
		plot.setWidth(width);
		plot.setX(x);
		plot.setY(y);
		return this.plot;
	}
	public String getOwner() {
		return this.owner;
	}
	public void setOwner(String owner) {
		this.owner=owner;
	}
	public double getRentAmount() {
		return this.rentAmount;
	}
	public void setRentAmount(double rentAmount) {
		this.rentAmount=rentAmount;
	}
	@Override
	public String toString() {
		return "Property Name: "+this.propertyName+"\nLocated in "+this.city+"\nBelonging to: "+this.owner
				+"\nRent Amount: "+this.rentAmount;
	}
}
