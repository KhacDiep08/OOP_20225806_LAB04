package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.exception.PlayerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;

public class CartScreenController {
    @FXML
    private TableView<Media> mediaTable;

    @FXML
    private TableColumn<Media, String> titleColumn;

    @FXML
    private TableColumn<Media, String> categoryColumn;

    @FXML
    private TableColumn<Media, Float> costColumn;

    @FXML
    private Label totalCostLabel;

    @FXML
    private TextField filterField;

    @FXML
    private ToggleGroup filterOptions;

    @FXML
    private RadioButton filterById;

    @FXML
    private RadioButton filterByTitle;

    @FXML
    private Button playButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button clearCartButton;

    @FXML
    private Button orderButton;

    private Cart cart;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        ObservableList<Media> mediaList = FXCollections.observableArrayList(cart.getItemsOrdered());
        mediaTable.setItems(mediaList);

        refreshTotalCost();
    }

    @FXML
    private void onPlayButtonPressed() throws PlayerException {
        Media selectedMedia = mediaTable.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            selectedMedia.play();
        } else {
            displayAlert("No Media Selected", "Please select a media item to play.");
        }
    }

    @FXML
    private void onRemoveButtonPressed() {
        Media selectedMedia = mediaTable.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            mediaTable.getItems().remove(selectedMedia);
            refreshTotalCost();
        } else {
            displayAlert("No Media Selected", "Please select a media item to remove.");
        }
    }

    @FXML
    private void onClearCartButtonPressed() {
        cart.clear();
        mediaTable.getItems().clear();
        refreshTotalCost();
    }

    @FXML
    private void onOrderButtonPressed() {
        if (!cart.getItemsOrdered().isEmpty()) {
            cart.placeOrder();
            mediaTable.getItems().clear();
            refreshTotalCost();
            displayAlert("Order Successful", "Your order has been placed successfully!");
        } else {
            displayAlert("Cart is Empty", "Please add items to the cart before placing an order.");
        }
    }

    private void refreshTotalCost() {
        totalCostLabel.setText(String.format("%.2f $", cart.totalCost()));
    }

    private void displayAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
