import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {
    @Test
    void readFile() throws IOException {
        assertEquals(null, urinals.readFile("src/Swetha.txt"));
        System.out.println("====== Swetha Ganapathy == TEST ONE EXECUTED =======");
    }

    @Test
    void writeFile() throws IOException {
        assertEquals(null, urinals.writeFile("src/Swetha.txt"));
        System.out.println("====== Swetha Ganapathy == TEST TWO EXECUTED =======");
    }
    @org.junit.jupiter.api.Test
    void goodString() {
        assertEquals(false, urinals.goodString("myfile"));
        assertEquals(false, urinals.goodString("111000"));
        assertEquals(true, urinals.goodString("1000010"));
        System.out.println("====== Swetha Ganapathy == TEST THREE EXECUTED =======");
    }

    @Test
    void maxNumOfFreeUrinals() {
        assertEquals(1, urinals.maxNumOfFreeUrinals("10001"));
        assertEquals(0, urinals.maxNumOfFreeUrinals("1001"));
        assertEquals(3, urinals.maxNumOfFreeUrinals("00000"));
        assertEquals(2, urinals.maxNumOfFreeUrinals("0000"));
        assertEquals(-1, urinals.maxNumOfFreeUrinals("011"));
        System.out.println("====== Swetha Ganapathy == TEST FOUR EXECUTED =======");
    }
    @Test
    void validateChoice() {
        assertEquals(true, urinals.validateChoice("1"));
        assertEquals(false, urinals.validateChoice("3"));
        System.out.println("====== Swetha Ganapathy == TEST FIVE EXECUTED =======");
    }
}