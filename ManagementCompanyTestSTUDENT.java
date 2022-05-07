
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany m;
	Property p1 ,p2,p3;
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m =new ManagementCompany(); 
		//student add three properties, with plots, to mgmt co
		p1 = new Property ("Am", "wood tree", 434.00, "Sam ran",1,3,1,2);
		p2 = new Property ("en", "fores lake", 416, "slick slug",2,1,3,2);
		p3 = new Property ("riS", "apple snow", 105, "chicken duck",4,1,6,2);
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		p1=p2=p3=null;
		m=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		Property p4 = new Property ("Sunny side", "Betty", 2613, "Build Bob");
		Property p5 = new Property ("dreary lane", "Laurel", 5327, "Doe nuts",2,5,3,4);
		Property p6 = new Property ("Maximillion", "Too", 5327, "Much",6,5,2,3);
		 
		assertEquals(m.addProperty(p4),3,0);
		assertEquals(m.addProperty(p5),4,0);
		assertEquals(m.addProperty(p6),-1,0);
		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
	}
 
	@Test
	public void testMaxRentProp() {
		assertEquals(m.maxRentProp(),434.0,0);
		//student should test if maxRentProp contains the maximum rent of properties
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(m.totalRent(),955.0,0);
		//student should test if totalRent returns the total rent of properties
	}

 }
