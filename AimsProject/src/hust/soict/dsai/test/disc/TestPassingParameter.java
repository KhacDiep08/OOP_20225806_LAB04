package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        // Tạo các đối tượng DigitalVideoDisc
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", null, null, 0, 0);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", null, null, 0, 0);

        // Hoán đổi các đối tượng (sử dụng phương thức swap mới)
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Thay đổi tiêu đề của jungleDVD
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // -----------------------------------------------
    // Phương thức swap cũ: Phương thức này không thay đổi đúng cách vì Java là pass by value
    // -----------------------------------------------
    // public static void swap(Object o1, Object o2) {
    //     Object temp = o1;
    //     o1 = o2;
    //     o2 = temp;
    // }

    // -----------------------------------------------
    // Phương thức swap mới: Hoán đổi đúng cách tiêu đề giữa hai đối tượng
    // -----------------------------------------------
    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        // Hoán đổi title của hai DVD
        String tempTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tempTitle);
    }

    // Phương thức thay đổi tiêu đề của dvd
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        dvd.setTitle(title); // Thay đổi tiêu đề của đối tượng
    }
}