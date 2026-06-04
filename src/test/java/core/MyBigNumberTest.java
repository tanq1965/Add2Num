package core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;

public class MyBigNumberTest {
    private static final Logger logger = Logger.getLogger(MyBigNumberTest.class.getName());

    @Test
    public void testSum_Normal() {
        MyBigNumber myBigNumber = new MyBigNumber();
        assertEquals("46", myBigNumber.sum2("12", "34"));
    }

    @Test
    public void testSum_differentLength_1() {
        MyBigNumber myBigNumber = new MyBigNumber();
        assertEquals("1023", myBigNumber.sum2("1000", "23"));
    }

    @Test
    public void testSum_differentLength_2() {
        MyBigNumber myBigNumber = new MyBigNumber();
        assertEquals("1023", myBigNumber.sum2("23", "1000"));
    }

    @Test
    public void testSum_withCarry() {
        MyBigNumber myBigNumber = new MyBigNumber();
        assertEquals("911", myBigNumber.sum2("899", "12"));
    }

    @Test
    public void testSum_finalCarry() {
        MyBigNumber myBigNumber = new MyBigNumber();
        assertEquals("100", myBigNumber.sum2("50", "50"));
    }

    @Test
    public void testSum_OneMillionDigits() {
        MyBigNumber mbn = new MyBigNumber();
        
        String largeNum = "9".repeat(1000000); 
        String singleDigit = "1";
        String expected = "1" + "0".repeat(1000000);
        
        long startTime1 = System.currentTimeMillis();
        String result1 = mbn.sum(largeNum, singleDigit);
        long endTime1 = System.currentTimeMillis();
        long duration1 = endTime1 - startTime1;

        long startTime2 = System.currentTimeMillis();
        String result2 = mbn.sum2(largeNum, singleDigit);
        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;

        assertEquals(expected, result1);
        assertEquals(expected, result2);

        logger.info(String.format("Thời gian sum: %d ms", duration1));
        logger.info(String.format("Thời gian sum2: %d ms", duration2));
    }
}