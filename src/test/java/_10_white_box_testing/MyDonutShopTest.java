package _10_white_box_testing;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import _08_mocking.models.DeliveryDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

class MyDonutShopTest {

    MyDonutShop myDonutShop;
    
    @Mock
    PaymentService ps;
    @Mock
    BakeryService bs;
    @Mock
    DeliveryService ds;
    
    @BeforeEach
    void setUp() {
    	
    	MockitoAnnotations.openMocks(this);
    	myDonutShop = new MyDonutShop(ps, ds, bs);
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
//*		
    	
    	Order order = new Order("Daniel Z",
    			"8589437293",
    			12,
    			30,
    			"489583857398",
    			true);
        
    	//when
    	
    	when (bs.getDonutsRemaining()).thenReturn(55);
    	when (ps.charge(order)).thenReturn(true);
    	
    	myDonutShop.openForTheDay();  
    	
    	myDonutShop.takeOrder(order);
    	
    	
        //then
    	
    	verify(ds, times(1)).scheduleDelivery(order);;
    	
    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() {
        //given
    	
    	myDonutShop.openForTheDay();
    	
    	Order order = new Order("Daniel Z",
    			"8589437293",
    			12,
    			30,
    			"489583857398",
    			false);
    	
        //when
    	
    	when (ps.charge(order)).thenReturn(true);
    	when (bs.getDonutsRemaining()).thenReturn(0);
    	
    	//then
    	System.out.println("hi");
    	Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> myDonutShop.takeOrder(order));
    	System.out.println("asdjfkl;");
    	assertEquals(exceptionThrown.getMessage(), "Insufficient donuts remaining");
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given

    	myDonutShop.closeForTheDay();
    	Order order = new Order("Daniel Z",
    			"8589437293",
    			12,
    			30,
    			"489583857398",
    			false);
    	
        //when
        //then
    	
    	Throwable exceptionThrown = assertThrows(IllegalStateException.class, () -> myDonutShop.takeOrder(order));
    	assertEquals(exceptionThrown.getMessage(), "Sorry we're currently closed");
    	//help
    	
    }

}