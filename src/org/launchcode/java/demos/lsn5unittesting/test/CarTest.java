package org.launchcode.java.demos.lsn5unittesting.test;

import org.junit.Test;
import org.launchcode.java.demos.lsn5unittesting.main.Car;

import static org.junit.Assert.*;

public class CarTest {
    Car test_car = new Car("Toyota", "Prius", 10, 50);

    @Test
    public void testInitialGasTank() {
        assertEquals(10, test_car.getGasTankLevel(), .001);
    }
    //TODO: gasTankLevel is accurate after driving within tank range
    @Test
    public void tankLevelAccurateAfterDrive() {
        test_car.drive(100);
        assertEquals(8, test_car.getGasTankLevel(), .001);
    }
    //TODO: gasTankLevel is accurate after attempting to drive past tank range
    @Test
    public void accurateAfterDrivingPastTankRange() {
        test_car.drive(520);
        assertEquals(0, test_car.getGasTankLevel(), .001);
    }
    //TODO: can't have more gas than tank size, expect an exception
    @Test(expected = IllegalArgumentException.class)
    public void testGasOverfillException() {
        test_car.addGas(5);
        fail("Shouldn't get here, car cannot have more gas in tank than the size of the tank");
    }

}
