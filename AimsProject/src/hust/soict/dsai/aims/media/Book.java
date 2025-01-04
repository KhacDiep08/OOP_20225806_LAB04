package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    // Constructor mặc định
    public Book() {
    }

    // Constructor với các tham số
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);  // Gọi constructor của lớp cha Media
    }

    // Getter cho danh sách tác giả
    public List<String> getAuthors() {
        return authors;
    }

    // Thêm tác giả vào danh sách (nếu chưa có)
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists in the list.");
        }
    }

    // Xóa tác giả khỏi danh sách (nếu có)
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found in the list.");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", cost=" + getCost() +
                ", authors=" + authors +
                '}';
    }

	@Override
	public boolean isMatch(String title2) {
		// TODO Auto-generated method stub
		return false;
	}
}
