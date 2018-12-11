package chapter10;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Properties;


/**
 * Created by shira on 01/12/2018.
 */
public class MainChap10Test {

    @Test
    public void readDurationTest() throws Exception {
        MainChap10 mainChap10 = new MainChap10();
        Properties param = new Properties();
        param.setProperty("a", "5");    // ok
        param.setProperty("b", "true"); // NaN
        param.setProperty("c", "-3");   // -ve
        assertEquals(5, mainChap10.readDuration(param, "a"));
        assertEquals(0, mainChap10.readDuration(param, "b"));
        assertEquals(0, mainChap10.readDuration(param, "c"));
        assertEquals(0, mainChap10.readDuration(param, "d"));
    }
}