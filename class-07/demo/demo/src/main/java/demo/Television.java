package demo;

public class Television implements VolumeChangable {
    int volume;

    public Television() {
        this.volume = 20;
    }
    public void volumeUpButtonPressed() {
        volume = volume + 5;
    }
    public void volumeDownButtonPressed() {
        volume = volume - 5;
    }
}
