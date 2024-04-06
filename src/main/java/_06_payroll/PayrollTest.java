package _06_payroll;

import org.junit.Test;
import static org.junit.Assert.*;

public class PayrollTest {

	@Test
	public void testCalculatePaycheck() {
		double hourlyWage = 20;
		int numHours = 7;
		assertEquals(Payroll.calculatePaycheck(hourlyWage, numHours), 140);
		
	}
	
	@Test
	public void testCalculateMileageReimbursement() {
		assertEquals(Payroll.calculateMileageReimbursement(15), 8.625);
	}
	
	@Test
	public void testCreateOfferLetter() {
		assertEquals(Payroll.createOfferLetter("Daniel", 90), "Hello Daniel, We are pleased to offer you an hourly wage of 90");
	}
	
}
