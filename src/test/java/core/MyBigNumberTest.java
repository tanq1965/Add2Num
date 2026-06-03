package core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyBigNumberTest {
    @Test
    public void testSum_Normal() {
        MyBigNumber myBigNumber = new MyBigNumber();
        assertEquals("123", myBigNumber.sum("100", "23"));
    }

    @Test
    public void testSum_WithCarry() {
        MyBigNumber myBigNumber = new MyBigNumber();
        assertEquals("2131", myBigNumber.sum("1234", "897"));
    }

    @Test
    public void testSum_DifferentLength() {
        MyBigNumber myBigNumber = new MyBigNumber();
        assertEquals("1000", myBigNumber.sum("999", "1"));
    }

    @Test
    public void testSum_Zero() {
        MyBigNumber myBigNumber = new MyBigNumber();
        assertEquals("999", myBigNumber.sum("999", "0"));
    }
}