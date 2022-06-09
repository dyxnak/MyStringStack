import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyStringStackTest {

	private String s1,s2, s3, o1, o2;
	private MyStringStack stack;
	
	@Before
	public void setUp() throws Exception{
		s1 = "Hello";
		s2 = "World";
		s3 = "!";
		o1 = null;
		o2 = null;		
	}
	
	@Test
	public void testPushWithNullObj(){
		//Empty stack is still empty after pushing a null element 
		stack = new MyStringStack();
		assertTrue(stack.isEmpty());
		
		stack.push(o1);
		assertTrue(stack.isEmpty());
	}
	@Test
	public void testPushWithObj() {
		//new empty a stack, push a Not Null element, the stack is not empty
		stack = new MyStringStack();
		stack.push(s1);
		assertFalse(stack.isEmpty());	
		// push another not null element s1, the stack size is 2
		stack.push(s1);
		assertEquals("the stack shall have 2 elements", 2, stack.size());
		//  push a null element and the pop the element,  it is the previously not null elements pushed in, its s1
		stack.push(o1);
		String o2= stack.pop();
		assertNotNull(o2);
		assertSame(s1, o2);
		assertEquals(s1, o2);
	}
	
	@Test
	public void testPop(){
		stack = new MyStringStack();
		assertTrue("Initial Stack state: ",stack.isEmpty());
		try {
			o1= stack.pop();
			fail();			
		}catch (IndexOutOfBoundsException e) {}	
		//New stack is empty, after pushing one element s1, stack is no longer empty
		stack.push(s1);
		assertFalse("Stack should not be empty after push", stack.isEmpty());
		try {
			o1= stack.pop();			
		}catch (IndexOutOfBoundsException e) {
			fail();
		}
		//check the popped up element o1 should be same as s1, the last element pushed
		assertSame (s1,o1);
		// after pop up, the stack becomes empty
		assertTrue(stack.isEmpty());
	}	
	@Test
	public void testIsEmpty(){
		stack = new MyStringStack();

		assertTrue(stack.isEmpty());
		stack.push(s1);
		assertFalse(stack.isEmpty());	
		try{
			o2 = stack.pop();
		}catch (IndexOutOfBoundsException e){
			fail();
		}
		assertSame(s1, o2);
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testClear(){
		stack = new MyStringStack();

		assertTrue("stack should be empty", stack.isEmpty());
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		// after push two elements the stack is not empty
		assertFalse("stack should not be empty",stack.isEmpty());
		stack.clear();
		// after call the clear() method, check if the stack is empty
		assertTrue(stack.isEmpty());
		try{
			o1= stack.pop();
			fail();			
		} catch(IndexOutOfBoundsException e){}
	}
	
	@Test
	public void testStackNull(){
		stack = new MyStringStack();

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
		stack = new MyStringStack();

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
