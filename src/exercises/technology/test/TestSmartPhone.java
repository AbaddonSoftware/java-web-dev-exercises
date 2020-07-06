package exercises.technology.test;

import exercises.technology.SmartPhone;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSmartPhone {
    SmartPhone newSmartPhone = new SmartPhone("Apple", "", 4.2, "IoS", true);

    @Test
    public void constructorSetsIsTouchScreen() {
        assertTrue(newSmartPhone.isTouchScreen());
    }

}
