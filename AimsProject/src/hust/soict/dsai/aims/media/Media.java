package hust.soict.dsai.aims.media;
import java.util.Comparator;
public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Media [ID=" + id + ", Title=" + title + ", Category=" + category + ", Cost=" + cost + "]";
    }

    public abstract boolean isMatch(String title2);
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
            Comparator.comparing(Media::getTitle)
                      .thenComparing(Comparator.comparing(Media::getCost).reversed());

        public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
            Comparator.comparing(Media::getCost).reversed()
                      .thenComparing(Media::getTitle);
}
