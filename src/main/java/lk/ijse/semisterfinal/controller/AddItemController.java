package lk.ijse.semisterfinal.controller;

import com.google.zxing.WriterException;
import com.jfoenix.controls.JFXButton;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.CustomerDao;
import lk.ijse.semisterfinal.Dao.Custom.ItemDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.CustomerDaoImpl;
import lk.ijse.semisterfinal.Dao.Custom.impl.ItemDaoImpl;
import lk.ijse.semisterfinal.Tm.CustomerTm;
import lk.ijse.semisterfinal.Tm.ItemTm;
import lk.ijse.semisterfinal.Tm.SupplierTm;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import lk.ijse.semisterfinal.model.ItemModel;
import lk.ijse.semisterfinal.model.SupplierModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.Notifications;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import static java.awt.SystemColor.text;

public class AddItemController implements Initializable {
    public TextField txtItemCode;
    public TextField txtItemPrice;
    public TextField txtWarrantyPeriod;
    public TextArea txtitemDetails;
    public ComboBox  comsupid;

    public Pane root;
    public TableView<lk.ijse.semisterfinal.Tm.ItemTm> ItemTm;
    public TableColumn <?,?> tmItemCode;
    public TableColumn <?,?> tmItemDetails;
    public TableColumn <?,?> tmItemPrice;
    public TableColumn <?,?> tmSupplierId;
    public TableColumn <?,?> tmWarranty;
    public TextField txtQty;
    public TextField serachItem;
    @FXML
    public Label lblTotalItem;
    public TableColumn <?,?> tmQty;
    public JFXButton btnWarrantyQr;
    public ChoiceBox <String> itemCatagory;
    public TableColumn <?,?> tmCatogory;

    private String[] cata = {"Electrical", "Furniture", "Toys", "Exercise equipment", "Office equipment", "Other"};

    ItemDao itemDao = new ItemDaoImpl();

    public void initialize() throws SQLException {
        totalItem();
        setCellValueFactory();
        tableListener();
        loadAllItem();
        itemSerachOnAction();
    }

    private void tableListener() {
        ItemTm.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);

        });
    }

    private void setData(ItemTm row) {
        txtItemCode.setText(row.getItemCode());
        txtitemDetails.setText(row.getItemDetails());
        txtItemPrice.setText(String.valueOf(row.getItemPrice()));
        comsupid.setValue(row.getSupplierId());
        txtWarrantyPeriod.setText(row.getWarrantyPeriod());
        txtQty.setText(String.valueOf(row.getItemQty()));
        itemCatagory.setValue(String.valueOf(row.getCato()));

    }

    private void clearField() {
        txtItemCode.setText("");
        comsupid.setValue("");
        txtItemPrice.setText("");
        txtWarrantyPeriod.setText("");
        txtitemDetails.setText("");
        txtQty.setText("");

    }

    private void setCellValueFactory() {
        tmItemCode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        tmItemDetails.setCellValueFactory(new PropertyValueFactory<>("itemDetails"));
        tmItemPrice.setCellValueFactory(new PropertyValueFactory<>("ItemPrice"));
        tmSupplierId.setCellValueFactory(new PropertyValueFactory<>("SupplierId"));
        tmWarranty.setCellValueFactory(new PropertyValueFactory<>("WarrantyPeriod"));
        tmQty.setCellValueFactory(new PropertyValueFactory<>("ItemQty"));
        tmCatogory.setCellValueFactory(new PropertyValueFactory<>("cato"));

    }

    public void AddItemOnAction(ActionEvent event) throws SQLException {

        String ItemCode = txtItemCode.getText();
        String ItemName = txtitemDetails.getText();
        double ItemPrice = Double.parseDouble(txtItemPrice.getText());
        String SupplierId = (String) comsupid.getValue();
        String WarrantyPeriod = txtWarrantyPeriod.getText();
        int qty  = Integer.parseInt(txtQty.getText());
        String cat = itemCatagory.getValue();

        try {
            /*if (!validateCustomer()){
                return;
            }*/

            ItemDTO dto = new ItemDTO(ItemCode,ItemName,ItemPrice,SupplierId,WarrantyPeriod,qty,cat);
            boolean isaddite = itemDao.addItem(dto);

            if (isaddite) {
                new Alert(Alert.AlertType.CONFIRMATION, "Add Successful").show();
                loadAllItem();
                clearField();
                itemSerachOnAction();
                totalItem();
            }
            ItemTm.getItems().add(new ItemTm(ItemCode,ItemName,ItemPrice,SupplierId,WarrantyPeriod,qty,cat));


        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }


    private void loadAllItem() {

        ItemTm.getItems().clear();

        try {
            ArrayList<ItemDTO> dtoList = itemDao.getAllItem();

            for (ItemDTO i : dtoList) {
                ItemTm.getItems().add(new ItemTm(i.getItemCode(),i.getItemDetails(),i.getItemPrice(),i.getSupplierId(),i.getWarrantyPeriod(),i.getItemQty(),i.getCato()));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void UpdateOnAction(ActionEvent event) throws IOException {
        String id = txtItemCode.getText();
        String name = txtitemDetails.getText();
        double price = Double.parseDouble(txtItemPrice.getText());
        String supid = (String) comsupid.getValue();
        String warranty = txtWarrantyPeriod.getText();
        int Qty = Integer.parseInt(txtQty.getText());
        String cat = itemCatagory.getValue();

        try{
            /*if (!validateEmployee()){
                return;
            }*/
            ItemDTO dto = new ItemDTO(id,name,price,supid,warranty,Qty,cat);
            boolean isUpdate = itemDao.updateItem(dto);

            if (isUpdate){
                ItemTm.getSelectionModel().clearSelection();
                new Alert(Alert.AlertType.CONFIRMATION,"Employee is updated").show();
                loadAllItem();
                clearField();
            }
            ItemTm.getItems().addAll(new ItemTm(id, name, price, supid, warranty, Qty, cat));

        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void deleteOnAction(ActionEvent event) {
        String id = txtItemCode.getText();

        try {
            boolean isDeleted = itemDao.deleteItem(id);

            if(isDeleted) {
                ItemTm.getSelectionModel().clearSelection();

                new Alert(Alert.AlertType.CONFIRMATION, "Item has deleted!").show();
                loadAllItem();
                totalItem();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Item not deleted!").show();
            }
            ItemTm.getItems().remove(ItemTm.getSelectionModel().getSelectedItem());

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    public void cmbSupplierOnAction(ActionEvent event) {
        String id = (String) comsupid.getValue();

        try {
            SupplierDTO dto = SupplierModel.searchsupplier(id);
            comsupid.setValue(dto.getSupNic());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

public void loadAllSupplier() {

    ObservableList<String> obList = FXCollections.observableArrayList();
    try {
        ArrayList<SupplierDTO> teacherDtos = itemDao.getAllSupplier();

        for (SupplierDTO dto : teacherDtos) {
            obList.add(dto.getSupNic());
        }
        comsupid.setItems(obList);

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}


    public void itemSerachOnAction() {
        FilteredList<ItemTm> filteredData = new FilteredList<>(ItemTm.getItems(), b -> true);

        serachItem.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(item -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String serchKey = newValue.toLowerCase();

                if (item.getItemCode().toString().contains(serchKey)) {
                    return true;
                } else if (item.getItemDetails().toLowerCase().contains(serchKey)){
                    return true;
                } else return false;
            });
        });

        SortedList <ItemTm> sortedList = new SortedList<>(filteredData);
        sortedList.comparatorProperty().bind(ItemTm.comparatorProperty());
        ItemTm.setItems(sortedList);
    }

    public void totalItem() throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();

        String sql = "SELECT COUNT(item_code) FROM item";

        String totalItem = null;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                totalItem = resultSet.getString("COUNT(item_code)");
            }
            lblTotalItem.setText(totalItem);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadAllSupplier();
            itemCatagory.getItems().addAll(cata);
            totalItem();
            setCellValueFactory();
            tableListener();
            loadAllItem();
            itemSerachOnAction();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validateCustomer() {
        boolean isValidate = true;
        boolean id = Pattern.matches("[A-Za-z]{0,}",txtItemCode.getText());

        if (!id){
            showErrorNotification("Invalid id", "The id you entered is invalid");
            isValidate = false;
        }

        boolean details = Pattern.matches("[A-Za-z]{0,}",txtitemDetails.getText());
        if (!details){
            showErrorNotification("Invalid details", "The details you entered is invalid");
            isValidate = false;
        }

        boolean qty = Pattern.matches("[0-9]{0,}",txtQty.getText());
        if (!qty){
            showErrorNotification("Invalid Qty", "The Qty Number you entered is invalid");
            isValidate = false;
        }
        return isValidate;
    }

    private void showErrorNotification(String title, String txtt) {
        Notifications.create()
                .title(title)
                .text(String.valueOf(text))
                .showError();
    }

    public void btnWarrantyOnAction(ActionEvent actionEvent) throws SQLException, JRException {
        InputStream inputStream = getClass().getResourceAsStream("../reports/Warranty.jrxml");
        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,
                DbConnetion.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint,false);

            /*JasperDesign jasDesign = JRXmlLoader.load("src/main/resources/report/Warranty.jrxml");
            JasperReport jasReport = JasperCompileManager.compileReport(jasDesign);
            JasperPrint jasPrint = JasperFillManager.fillReport(jasReport, null,DbConnetion.getInstance().getConnection());
            JasperViewer.viewReport(jasPrint,false);*/

    }

    public void btnWarrantyQRonAction(ActionEvent actionEvent) throws WriterException, SQLException {
        String values = txtItemCode.getText() + "," + txtitemDetails.getText() + "," + txtWarrantyPeriod + "," +txtItemPrice.getText() ;//QR code ekata watenna oone details tika..

        String filepath = "C:\\Users\\Shanilka\\Documents\\QR"+ "qr"+ txtItemCode.getText() +".png"; //Save wenna oone folder eke path eka..
        boolean isGenerated = QR.generateQrCode(values, 1250, 1250, filepath);

        if (isGenerated){
            new Alert(Alert.AlertType.CONFIRMATION, "Generated QR Code WARRANTY").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();;
        }
    }
}



