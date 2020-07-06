package exercises.technology.test;

import exercises.technology.Laptop;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;



public class TestLaptop {
    ArrayList<String> beos = new ArrayList<>(Arrays.asList("BeOS"));
    Laptop myLaptop = new Laptop("test", "test502", 1200, beos, 14.1, 2.4);

    @Test
    public void testConstructorSetsScreenSize() {
        assertEquals(14.1, myLaptop.getScreenSize(), .001);
    }

    @Test
    public void testConstructorSetsBatteryLife() {
        assertEquals(2.4, myLaptop.getBatteryLifeInHours(), .001);
    }
}
