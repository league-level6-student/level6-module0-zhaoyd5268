package _08_mocking.models;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.*;

import _07_intro_to_mocking.models.Car;
import _07_intro_to_mocking.models.Engine;
import _07_intro_to_mocking.models.GasTank;
import _09_intro_to_white_box_testing.models.Order;

public class DeliveryDriverTest {
	
	GasTank gt = mock(GasTank.class);
	Engine e = mock(Engine.class);
	Car car = mock(Car.class);
	CellPhone cp = mock(CellPhone.class);
	


		
		


//		when(car.getFuelLevel()).thenReturn((double) 5);
//		when(car.start()).thenReturn(true);
//		when(cp.browseCatMemes()).thenReturn(true);
//		when(cp.call("8586721488")).thenReturn(true);
//		when(e.start()).thenReturn(true);
//		when(gt.fill(5)).thenReturn(true);
//		when(gt.getFuelLevel()).thenReturn((double) 5);
		
	
	
	
	@Test 
	public void testFillTank() {
		when(car.fillTank(5)).thenReturn(true);
		assertEquals(car.getFuelLevel(), 5);
	}
}
