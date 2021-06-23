import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyStringStackTest {

	private String s1,s2;
	private MyStringStack stack;
	
	@Before
	public void setUp() throws Exception{
		s1 = "Hello";
		s2 = "World!";
		stack = new MyStringStack();		
	}
	
	@Test
	public void testPush(){
		//Empty stack is still empty after pushing a null element 
		assertTrue(stack.isEmpty());
		String o1 = null;
		stack.push(o1);
		assertTrue(stack.isEmpty());
		
		//New stack is empty, after pushing an s1 element, stack is no longer empty
		assertTrue(stack.isEmpty());
		stack.push(s1);
		assertFalse(stack.isEmpty());	
	}
	
	@Test
	public void testPop(){
		String o1 = null;
		assertTrue("Initial Stack state: ",stack.isEmpty());
		try {
			o1= stack.pop();
			fail();			
		}catch (IndexOutOfBoundsException e) {}		
		stack.push(s1);
		assertFalse("Stack should not be empty after push", stack.isEmpty());
		try {
			o1= stack.pop();			
		}catch (IndexOutOfBoundsException e) {
			fail();
		}
		assertSame (s1,o1);
		assertTrue(stack.isEmpty());
	}	
	@Test
	public void testIsEmpty(){
		String s3 = null;
		assertTrue(stack.isEmpty());
		stack.push(s1);
		assertFalse(stack.isEmpty());	
		try{
			s3 = stack.pop();
		}catch (IndexOutOfBoundsException e){
			fail();
		}
		assertSame(s1, s3);
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testClear(){
		String o1 = null;		
		assertTrue("stack should be empty", stack.isEmpty());
		stack.push(s1);
		stack.push(s2);
		assertFalse("stack should not be empty",stack.isEmpty());
		stack.clear();
		assertTrue(stack.isEmpty());
		try{
			o1= stack.pop();
			fail();			
		} catch(IndexOutOfBoundsException e){}
	}
	
	@Test
	public void testStackNull(){
		String o1 = null;	
		assertTrue(stack.isEmpty());
		stack.push(o1);
		assertTrue(stack.isEmpty());
		stack.push(null);
		stack.push(s1);
		stack.push(null);		
		try{
			o1= stack.pop();
			assertSame(o1,s1);
			
		} catch(IndexOutOfBoundsException e){
			fail();
		}
		assertTrue(stack.isEmpty());	
		try{
			o1= stack.pop();
			fail();
			
		} catch(IndexOutOfBoundsException e){

		}
	}

	
	@Test
	public void testStackSequence(){
		String o1 = null;

		assertTrue(stack.isEmpty());
		stack.push(s1);
		try{
			o1= stack.pop();
			assertSame(o1,s1);
			
		} catch(IndexOutOfBoundsException e){
			fail();
		}
		stack.push(s1);
		stack.push(s2);
		try{
			o1= stack.pop();
			assertSame(o1, s2);
			o1= stack.pop();
			assertSame(o1, s1);
			
		} catch(IndexOutOfBoundsException e){
			fail();
		}
		assertTrue(stack.isEmpty());
	}
	

	@After
	public void tearDown() throws Exception {
	}


}
