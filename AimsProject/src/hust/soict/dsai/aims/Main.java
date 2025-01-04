package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.StoreScreen;



public class Main {
    public static void main(String[] args) {
        // Khởi tạo Store
        Store store = new Store();

        // Thêm sản phẩm vào store (ví dụ: DVD)
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladin", "Animation", null, 0, 18.99f));

        // Khởi tạo và hiển thị StoreScreen
        StoreScreen storeScreen = new StoreScreen(store);
    }
}
