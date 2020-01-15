package demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniversalRemoteTest {

    @Test
    public void addDevice() {
        UniversalRemote remote = new UniversalRemote();

        Television myTv = new Television();
        remote.addDevice(myTv);

        remote.setCurrentDevice(0);
        remote.volumeUpButtonPressed();
        assertEquals(25, myTv.volume);
        System.out.println("the assert worked!");

        Speaker speaker = new Speaker(3, "Ultimate Ears", true, true);
        remote.addDevice(speaker);
        remote.setCurrentDevice(1);
        remote.volumeUpButtonPressed();
        assertEquals(4, speaker.volume);
//        System.out.println(remote.devices);
        // lol i'm an evil user lol
//        remote.devices.remove(0);
    }

    @Test
    public void testInterface() {
        // can't instantiate an interface--we need a class for that!
//        VolumeChangable v = new VolumeChangable();
    }

}