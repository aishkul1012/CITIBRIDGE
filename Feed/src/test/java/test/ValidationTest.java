package test;

import com.java.*;
import com.java.model.Parameters;

import static org.junit.Assert.*;
import org.junit.*;
//import org.junit.Test;
public class ValidationTest {

	private Parameters obj=null;
	
	@Before
	public void initiateTest() {
		obj=new Parameters();
	}
	
	@Test
	public void checkTRIDCorrect() {
		assertEquals(true,obj.TRID("123456789012", 12));
	}
	
	@Test
	public void checkTRIDIncorrect() {
		assertEquals(false,obj.TRID("123456789012", 15));
	}
	
	@Test
	public void checkPRNAMECorrect() {
		assertEquals(true,obj.PRNAME("William",35));
	}
	
	@Test
	public void checkPRNAMEIncorrect() {
		assertEquals(false,obj.PRNAME("Hippopotomonstrosesquippedaliophobia",35));
	}
	
	@Test
	public void checkPRACCCorrect() {
		assertEquals(true,obj.PRACC("200000102011",12));
	}
	
	@Test
	public void checkPRACCIncorrect() {
		assertEquals(false,obj.PRACC("200000ABC011",15));
	}
	
	
	@Test
	public void checkPNAMECorrect() {
		assertEquals(true,obj.PNAME("Parker",35));
	}
	
	@Test
	public void checkPNAMEIncorrect() {
		assertEquals(false,obj.PNAME("Hippopotomonstrosesquippedaliophobia",35));
	}
	
	@Test
	public void checkPACCCorrect() {
		assertEquals(true,obj.PACC("200000102011",12));
	}
	
	@Test
	public void checkPACCIncorrect() {
		assertEquals(false,obj.PRACC("200000ABC011",15));
	}

	
	@Test
	public void checkDateFormatTestCorrect() {
		assertEquals(false,obj.checkDateFormat(28,12,2018)); //correct format
	}
	
	@Test
	public void checkDateFormatTestIncorrectMonth() {
		assertEquals(false,obj.checkDateFormat(28,15,2018)); //incorrect month
	}
	
	@Test
	public void checkDateFormatTestIncorrectYear() {
		assertEquals(false,obj.checkDateFormat(28,12,1)); //incorrect year
	}
	
	@Test
	public void checkDayTestCorrect() {
		assertEquals(true,obj.checkDay(31,12,2018)); //correct day
	}
	
	@Test
	public void checkDayTestIncorrect() {
		assertEquals(false,obj.checkDay(56,12,2018)); //incorrect day
	}
	
	@Test
	public void checkTransactionDateOccurenceTestCorrect() {
		assertEquals(true,obj.checkTransactionOccuranceDate(26,07,2020)); 
	}
	
	@Test
	public void checkTransactionDateOccurenceTestIncorrect() {
		assertEquals(false,obj.checkTransactionOccuranceDate(17,03,2018)); //incorrect date occurence
	}
	
	@Test
	public void checkAmountTest() {
		assertEquals(true,obj.AMT(453648.789));
	}

}