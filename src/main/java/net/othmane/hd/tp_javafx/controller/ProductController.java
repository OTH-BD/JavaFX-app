package net.othmane.hd.tp_javafx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import net.othmane.hd.tp_javafx.models.Product;

public class ProductController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private ListView<Product> productList;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;

    private ObservableList<Product> products = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        productList.setItems(products);

        // 🎨 Custom cell factory
        productList.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);
                if (empty || product == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    VBox content = new VBox();
                    content.setSpacing(5);

                    // Détection d’un emoji selon le nom du produit
                    String emoji = getEmojiForProduct(product.getName());

                    Label nameLabel = new Label(emoji + " " + product.getName());
                    nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: white;");

                    Label priceLabel = new Label("💰 " + String.format("%.2f MAD", product.getPrice()));
                    priceLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #dcdde1;");

                    content.getChildren().addAll(nameLabel, priceLabel);
                    content.setStyle("-fx-background-color: #2f3640; -fx-padding: 10; -fx-background-radius: 8;");

                    setGraphic(content);
                }
            }
        });



    }

    private String getEmojiForProduct(String name) {
        String lower = name.toLowerCase();
        if (lower.contains("phone") || lower.contains("smartphone")) return "📱";
        if (lower.contains("laptop") || lower.contains("pc") || lower.contains("ordinateur")) return "💻";
        if (lower.contains("tv") || lower.contains("télé")) return "📺";
        if (lower.contains("headphone") || lower.contains("écouteur") || lower.contains("casque")) return "🎧";
        if (lower.contains("watch") || lower.contains("montre")) return "⌚";
        if (lower.contains("dog") || lower.contains("chien")) return "🐶";
        if (lower.contains("cat") || lower.contains("chat")) return "🐱";
        if (lower.contains("camera") || lower.contains("caméra")) return "📷";
        return "📦"; // emoji par défaut
    }

    @FXML
    private void handleAddProduct() {
        try {
            String name = nameField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());

            Product product = new Product(name, price);
            products.add(product);

            nameField.clear();
            priceField.clear();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie");
            alert.setContentText("Le prix doit être un nombre valide");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleDeleteProduct() {
        Product selectedProduct = productList.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            products.remove(selectedProduct);
        }
    }
}
