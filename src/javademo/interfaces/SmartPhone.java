package javademo.interfaces;

public class SmartPhone implements Camera, MusicPlayer, Phone {

    @Override
    public void takePhoto() {
        System.out.println("takePhoto");
    }

    @Override
    public void recordVideo() {
        System.out.println("recordVideo");
    }

    @Override
    public void playMusic() {
        System.out.println("playMusic");
    }

    @Override
    public void stopMusic() {
        System.out.println("stopMusic");
    }

    @Override
    public void makeCall() {
        System.out.println("makeCall");
    }

    @Override
    public void endCall() {
        System.out.println("endCall");
    }
}
