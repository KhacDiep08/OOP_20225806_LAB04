package hust.soict.dsai.test.cart.CartTest;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Tạo giỏ hàng mới
        Cart cart = new Cart();

        // Thêm các DVD vào giỏ hàng
        cart.addDigitalVideoDisc(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        cart.addDigitalVideoDisc(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        cart.addDigitalVideoDisc(new DigitalVideoDisc("Aladdin", "Animation","a",1, 18.99f));

        // In giỏ hàng
        cart.printCart();

        // Kiểm tra tìm kiếm theo ID
        DigitalVideoDisc foundById = (DigitalVideoDisc) cart.searchById(2);
        if (foundById != null) {
            System.out.println("Found by ID 2: " + foundById);
        } else {
            System.out.println("No DVD found with ID 2.");
        }

        // Kiểm tra tìm kiếm theo tiêu đề
        System.out.println("\nSearching by title 'Lion':");
        cart.searchById("Lion");

        System.out.println("\nSearching by title 'Star':");
        cart.searchById("Star");

        System.out.println("\nSearching by title 'Harry Potter':");
        cart.searchById("Harry Potter");
    }
}
