package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {

    private Store store; // Store object as member variable

    public StoreScreen(Store store) {
        this.store = store; // Assign store object

        // Get main container
        Container cp = getContentPane();
        // Set BorderLayout for container
        cp.setLayout(new BorderLayout());

        // Add panels to corresponding positions
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        // Display window and set properties
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    public JMenuBar createMenuBar() {
        // Create main menu "Options"
        JMenu menu = new JMenu("Options");

        // Create submenu "Update Store" and add sub-menu items
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        // Add submenu "Update Store" and other menu items to main menu
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        // Create JMenuBar and set layout
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        // Return JMenuBar
        return menuBar;
    }

    public JPanel createHeader() {
        // Create a new JPanel for the header
        JPanel header = new JPanel();
        // Set horizontal layout for JPanel
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        // Create title label "AIMS" and format
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        // Create "View cart" button and format
        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        // Add components to JPanel, including spacing, label, and button
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        // Return the created JPanel
        return header;
    }

    private JPanel createCenter() {
        // Create a new JPanel for the center section
        JPanel center = new JPanel();
        
        // Get list of products from store
        ArrayList<Media> mediaInStore = (ArrayList<Media>) store.getItemsInStore(); // Get the list of media items
        
        // Calculate number of rows based on the number of items in store
        int rows = (int) Math.ceil(mediaInStore.size() / 3.0); // Calculate number of rows dynamically
        
        // Set the layout for the center panel
        center.setLayout(new GridLayout(rows, 3, 2, 2));

        // Create MediaStore objects and add to center panel
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        // Return the created JPanel
        return center;
    }

}
