package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
    public MediaStore(Media media) {
        // Thiết lập bố cục theo chiều dọc
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Tạo nhãn tiêu đề và định dạng
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // Tạo nhãn giá và định dạng
        JLabel cost = new JLabel(media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        // Tạo panel chứa các nút
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Thêm nút "Add to cart"
        container.add(new JButton("Add to cart"));
        // Nếu media có thể phát được, thêm nút "Play"
        if (media instanceof Playable) {
            container.add(new JButton("Play"));
        }

        // Thêm các thành phần vào panel chính
        add(Box.createVerticalGlue());
        add(title);
        add(cost);
        add(Box.createVerticalGlue());
        add(container);

        // Thêm viền cho panel
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}