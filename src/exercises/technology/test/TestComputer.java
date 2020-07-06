package exercises.technology.test;

import exercises.technology.Computer;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestComputer {
    Computer newComputer = new Computer("AbaddonSoft", "Arm7tdmi", 16.78);

    @Test
    public void testConstructorSetsProcessorSpeed() {
        assertEquals(16.78, newComputer.getProcessorSpeedInMHZ(), .001);
    }

    @Test
    public void testConstructorSetsManufacturer() {
        assertEquals("AbaddonSoft", newComputer.getManufacturer());
    }

    @Test
    public void testConstructorSetsProcessorType() {
        assertEquals("Arm7tdmi", newComputer.getProcessorType());
    }

    @Test
    public void testEachComputerReceivesUniqueId() {
        Computer anotherNewComputer = new Computer("BrenCorTrevTedGregPaulDonCo", "Apple Silicon", 6000);
        assertNotEquals("1stComputerId=" +newComputer.getId()+ "\n2ndComputerId=" +anotherNewComputer.getId(), newComputer.getId(), anotherNewComputer.getId());
    }
}
