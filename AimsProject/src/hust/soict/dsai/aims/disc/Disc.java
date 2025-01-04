package hust.soict.dsai.aims.disc;


import hust.soict.dsai.aims.media.Media;

public class Disc extends Media {
    private String director;
    private int length;

    // Constructor mặc định
    public Disc() {
        super(0, "", "", 0.0f);  // Gọi constructor của Media với giá trị mặc định
    }

    // Constructor đầy đủ
    public Disc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);  // Gọi constructor của Media
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

    // Phương thức toString để in thông tin Disc
    @Override
    public String toString() {
        return "Disc - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + " mins: " + getCost() + " $";
    }

	@Override
	public boolean isMatch(String title2) {
		// TODO Auto-generated method stub
		return false;
	}
}
