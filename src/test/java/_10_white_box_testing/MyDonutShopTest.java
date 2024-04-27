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

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

class MyDonutShopTest {

    MyDonutShop myDonutShop;
    PaymentService ps;
    BakeryService bs;
    @BeforeEach
    void setUp() {
    	
    	MockitoAnnotations.openMocks(this);
    	ps = mock(PaymentService.class);
    	bs = mock(BakeryService.class);
    	myDonutShop = mock(MyDonutShop.class);
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
//*		
    	myDonutShop.openForTheDay();
    	
    	Order order = mock(Order.class);
        
    	//when

    	myDonutShop.takeOrder(order);
    	
        //then
    	
    	verify(myDonutShop, times(1)).takeOrder(order);
    	
    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() throws Exception {
        //given
    	
    	myDonutShop.openForTheDay();
    	
    	Order order = new Order("Daniel Z",
    			"8682938672",
    			15,
    			40,
    			"29486723810487566",
    			false);
    	
        //when
    	
    	when (ps.charge(order)).thenReturn(true);
    	when (bs.getDonutsRemaining()).thenReturn(0);
    	
    	//then
    	
    	Throwable ExceptionThrown = assertThrows(IllegalArgumentException.class, () -> myDonutShop.takeOrder(order));

    	
    	//help
  
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given

    	myDonutShop.closeForTheDay();
    	Order order = mock(Order.class);
    	
        //when
        //then
    	
    	//help
    	
    }

}