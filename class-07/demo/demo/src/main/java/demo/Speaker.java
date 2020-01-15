package demo;

public class Speaker {
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
    }
}
