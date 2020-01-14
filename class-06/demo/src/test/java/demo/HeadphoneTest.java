package demo;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class HeadphoneTest {
    @Test
    public void testHeadphone() {
        Headphone h = new Headphone(2, "Sony", false, true, true);
        assertEquals("Sony", h.type);
        assertTrue(h.isNoiseCancelling);

        Speaker s = h;
        assertTrue(s.wireless);
//        assertTrue(s.isNoiseCancelling);

//        Headphone newHeadphone = new Speaker(4, "lg", true, true);

        Phone myPhone = new Phone();
        myPhone.connect(h);
        // myPhone.output.isNoiseCancelling;
    }

    @Test
    public void testHowInterfacesWork() {
        LinkedList<String> snows = new LinkedList<>();
        snows.add("flurry");
        snows.add("powder");
        snows.add("blizzard");

        snows.addFirst("dusting");

        for (String snow : snows) {
            System.out.println(snow);
        }

        // this is how exceptions happen
        throw new RuntimeException("you can't do that");
        // NoSuchElementException
    }
}