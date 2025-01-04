package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.media.Playable;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter và Setter cho title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter và Setter cho length
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Phương thức play() từ Playable interface
    @Override
    public void play() {
        System.out.println("Playing track: " + this.title);
        System.out.println("Track length: " + this.length + " minutes.");
    }

    // Phương thức toString để in thông tin của Track
    @Override
    public String toString() {
        return "Track - " + title + " - " + length + " mins";
    }
}
