package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int length;

    private static int nbDigitalVideoDiscs = 0;

    // Constructor mặc định
    public DigitalVideoDisc() {
    }

    // Constructor đầy đủ
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost); // Tự động tạo id
        this.director = director;
        this.length = length;
    }

    // Getter và Setter cho director
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Getter và Setter cho length
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Phương thức kiểm tra tiêu đề khớp (isMatch)
    public boolean isMatch(String title) {
        if (title == null || title.trim().isEmpty()) {
            return false;
        }
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    // Phương thức kiểm tra độ dài DVD
    public boolean isLongerThan(DigitalVideoDisc other) {
        return this.length > other.length;
    }

    // Phương thức triển khai play từ interface Playable
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " minutes.");
    }

    // Phương thức so sánh hai DVD
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        DigitalVideoDisc other = (DigitalVideoDisc) obj;
        return this.getId() == other.getId();
    }

    // Phương thức in thông tin DVD
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + " mins: " + getCost() + " $";
    }
}
