package demo;

public class Headphone extends Speaker {

    boolean isNoiseCancelling;
    public Headphone(int volume, String type, boolean isOn, boolean wireless, boolean isNoiseCancelling) {
        super(volume, type, isOn, wireless);
        this.isNoiseCancelling = isNoiseCancelling;
    }
}
