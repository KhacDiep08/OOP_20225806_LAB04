package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.awt.Component;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();  // Danh sách các media trong cửa hàng

    // Phương thức thêm Media vào cửa hàng
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Media added: " + media.getTitle());
    }

    // Phương thức xóa Media khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media removed: " + media.getTitle());
        } else {
            System.out.println("404 - Media not found in store.");
        }
    }

    // Tìm kiếm Media theo ID
    public Media searchById(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;  // Không tìm thấy Media với ID đó
    }

    

    // In danh sách Media trong cửa hàng
    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in Store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            Media media = itemsInStore.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }
        System.out.println("***************************************************");
    }

	public void addDVD(DigitalVideoDisc dvd1) {
		// TODO Auto-generated method stub
		
	}

	public void removeDVD(DigitalVideoDisc dvd2) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Media> getItemsInStore() {
		// TODO Auto-generated method stub
		return null;
	}
}
