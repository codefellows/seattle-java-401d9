package demo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpeakerTest {

    Speaker speaker;
    @Before
    public void setUp() throws Exception {
        speaker = new Speaker(5, "Bose", true, true);
    }

    @Test
    public void testConstructor() {
        assertEquals("Bose", speaker.type);
        assertEquals(5, speaker.volume);
        assertEquals(true, speaker.isOn);
        assertEquals(true, speaker.wireless);
    }

    @Test
    public void testIncreaseVolume() {
        speaker.volumeUp();
        assertEquals(6, speaker.volume);
    }
}