import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @org.junit.jupiter.api.Test
    void goodString() {
        assertEquals(false, urinals.goodString("myfile"));
        assertEquals(false, urinals.goodString("111000"));
        assertEquals(true, urinals.goodString("1000010"));
        System.out.println("====== Swetha Ganapathy == TEST ONE EXECUTED =======");
    }

    @Test
    void maxNumOfFreeUrinals() {
        assertEquals(3, urinals.maxNumOfFreeUrinals("00000"));
        assertEquals(-1, urinals.maxNumOfFreeUrinals("011"));
        System.out.println("====== Swetha Ganapathy == TEST TWO EXECUTED =======");
    }
}