package ma.saifdine.hd.tp_javafx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.saifdine.hd.tp_javafx.models.Product;

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
    }

    @FXML
    private void handleAddProduct() {
        try {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());

            Product product = new Product(name, price);
            products.add(product);

            // Clear fields
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