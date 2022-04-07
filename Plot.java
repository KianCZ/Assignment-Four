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
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	Plot(){	}
	Plot(Plot p){
		this.x=p.getX();
		this.y=p.getY();
		this.width=p.getWidth();
		this.depth=p.getDepth();
	}
	Plot(int x,int y, int width, int depth){
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
	}
	//false		plot3 = new Plot(11,11,3,2);		plot9 = new Plot(11,14,2,1);

	public boolean overlaps(Plot plot) {
		if(this.encompasses(plot)||plot.encompasses(this)) {
			return true;
		}
		if(this.x>plot.getX()||this.x<(plot.getX()+plot.getX())) {
			if(this.y>plot.getY()||this.y<(plot.getY()+plot.getDepth())) {
				return true;
			}
		}
		return false;
	}
	public boolean encompasses(Plot plot) {
		if(this.x<=plot.getX()&&(plot.getX()+plot.getWidth())<=(this.x+this.width)&&
				this.y<=plot.getY()&&(plot.getY()+plot.getDepth())<=(this.y+this.depth)) {
			return true;
		}
		return false;
	}
	public void setX(int x) {
		this.x=x;
	}
	public int getX() {
		return this.x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public int getY() {
		return this.y;
	}
	public void setWidth(int width) {
		this.width=width;
	}
	public int getWidth() {
		return this.width;
	}
	public void setDepth(int depth) {
		this.depth=depth;
	}
	public int getDepth() {
		return this.depth;
	}
	public String toString() {
		return "Upper left: ("+x+","+y+"); Width: "+width+" Depth: "+depth;
	}
}
