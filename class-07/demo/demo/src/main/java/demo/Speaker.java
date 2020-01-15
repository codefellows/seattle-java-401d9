package demo;

public class Speaker implements VolumeChangable {
    // instance variables
    int volume;
    String type;
    boolean isOn;
    boolean wireless;

    public Speaker(int volume, String type, boolean isOn, boolean wireless) {
        this.volume = volume;
        this.type = type;
        this.isOn = isOn;
        this.wireless = wireless;
    }

    public void volumeUp() {
        this.volume = this.volume + 1;
        // this.volume++;
    }

    public void volumeUpButtonPressed() {
        this.volumeUp();
    }

    public void volumeDownButtonPressed() {
        this.volume--;
        // this.volume = this.volume - 1;
    }

    public int compareTo(Speaker o) {
        return 0;
    }
}
