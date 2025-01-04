package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();  // Danh sách các media trong giỏ hàng

    // Phương thức thêm Media vào giỏ hàng
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("+1");
        } else {
            System.out.println("Cart is full, cannot add: " + media.getTitle());
        }
    }

    // Phương thức thêm danh sách Media vào giỏ hàng
    public void addMedia(Media[] mediaList) {
        for (Media media : mediaList) {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(media);
                System.out.println("+1");
            } else {
                System.out.println("Cart is full, cannot add: " + media.getTitle());
                break;
            }
        }
    }

    // Phương thức xóa một Media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("-1");
        } else {
            System.out.println("404 - Media not found in cart.");
        }
    }

    // Tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // In giỏ hàng
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + media.toString());
            totalCost += media.getCost();
        }
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }

    // Tìm kiếm Media theo ID
    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;  // Không tìm thấy Media với ID đó
    }

	public void addDigitalVideoDisc(DigitalVideoDisc digitalVideoDisc) {
		// TODO Auto-generated method stub
		
	}

	public void searchById(String string) {
		// TODO Auto-generated method stub
		
	}

    
}
