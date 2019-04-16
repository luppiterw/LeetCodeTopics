package test.com.hughie.leet.algorithm; 

import com.hughie.leet.algorithm.P0002_AddTwoNumbers;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* P0002_AddTwoNumbers Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 16, 2019</pre> 
* @version 1.0 
*/ 
public class P0002_AddTwoNumbersTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: toText() 
* 
*/ 
@Test
public void testToText() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addTwoNumbers(ListNode l1, ListNode l2) 
* 
*/ 
@Test
public void testAddTwoNumbers() throws Exception { 
//TODO: Test goes here...
    P0002_AddTwoNumbers.ListNode a,b;
    a = new P0002_AddTwoNumbers.ListNode(0);
    b = new P0002_AddTwoNumbers.ListNode(7);
    b.next = new P0002_AddTwoNumbers.ListNode(3);
    System.out.println(P0002_AddTwoNumbers.addTwoNumbers(a, b).toText());;
} 

/** 
* 
* Method: f1_addTwoNumbers(ListNode l1, ListNode l2) 
* 
*/ 
@Test
public void testF1_addTwoNumbers() throws Exception { 
//TODO: Test goes here... 
} 


} 
