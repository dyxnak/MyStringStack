import java.lang.IndexOutOfBoundsException;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyStringStackTest {
	private String s1,s2;
	private MyStringStack stack;
	
	@BeforeEach
	public void setUp() throws Exception{
		s1 = "Hello";
		s2 = "World!";
		stack = new MyStringStack();		
	}
	@Test
	public void pushTest(){
		assertTrue(stack.isEmpty());
		stack.push(s1);
		stack.push(s2);
		assertFalse(stack.isEmpty());	
	}
	
	@Test
	public void popTest(){
		String o1 = null;
		assertTrue("Initial Stack state: ",stack.isEmpty());
		try {
			o1= stack.pop();
			fail();			
		}catch (IndexOutOfBoundsException e) {}		
		stack.push(s1);
		assertFalse("Stack should not be empty after push", 
				stack.isEmpty());
		try {
			o1= stack.pop();			
		}catch (IndexOutOfBoundsException e) {
			fail();
		}
		assertSame (s1,o1);
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void isEmptyTest(){
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
	public void clearTest(){
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
	public void stackNullTest(){
		String o1 = null;	
		assertTrue(stack.isEmpty());
		stack.push(null);
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
	public void stackSequenceTest(){
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
	

	@AfterEach
	public void tearDown() throws Exception {
	}



}
