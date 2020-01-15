package demo;

import java.util.LinkedList;
import java.util.List;

public class UniversalRemote {

    private List<VolumeChangable> volumeChangables;
    private int currentDevice;

    public UniversalRemote() {
        this.volumeChangables = new LinkedList<>();
        this.currentDevice = 0;
    }

    public void setCurrentDevice(int newDevice) {
        this.currentDevice = newDevice;
    }

    public void volumeUpButtonPressed() {
        this.volumeChangables.get(currentDevice).volumeUpButtonPressed();
    }

    public void volumeDownButtonPressed() {
        this.volumeChangables.get(currentDevice).volumeDownButtonPressed();
    }

    public void addDevice(VolumeChangable volumeChangable) {
        volumeChangables.add(volumeChangable);
    }
}
