package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.media.Playable;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks;

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
        super(id, title, category, cost, director, length); // Gọi constructor của Disc
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Getter cho tracks
    public List<Track> getTracks() {
        return tracks;
    }

    // Phương thức thêm track vào danh sách
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists in the list.");
        }
    }

    // Phương thức xóa track khỏi danh sách
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found in the list.");
        }
    }

    // Phương thức tính tổng độ dài của CD (tổng độ dài của tất cả các track)
    @Override
    public int getLength() {
        int totalLength = super.getLength();  // Độ dài của Disc (nếu có)
        for (Track track : tracks) {
            totalLength += track.getLength();  // Cộng độ dài của các track
        }
        return totalLength;
    }

    // Phương thức play() từ Playable interface
    @Override
    public void play() {
        System.out.println("Playing CompactDisc: " + this.getTitle());
        System.out.println("Artist: " + this.artist);
        System.out.println("CompactDisc length: " + this.getLength() + " minutes.");
        
        // Lặp qua từng track và gọi phương thức play của track
        for (Track track : tracks) {
            track.play();
        }
    }

    // Phương thức in thông tin của CompactDisc
    @Override
    public String toString() {
        return "CompactDisc - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " mins - " + artist + " - " + getCost() + " $";
    }
}
