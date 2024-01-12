package lk.ijse.semisterfinal.controller;


import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.semisterfinal.Bo.BoFactory;
import lk.ijse.semisterfinal.Bo.Custom.SupplierBo;
import lk.ijse.semisterfinal.Bo.Custom.impl.SupplierBoImpl;
import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.dto.Tm.SupplierTm;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddSupplierControlller  {
    public TextField txtSupName;
    public TableColumn <?,?> tmSupId;
    public TableColumn <?,?> tmSupName;
    public TextField txtSupQty;
    public TextField txtSupMobile;
    public AnchorPane rood;
    public TableView <SupplierTm> supplierAddTable;
    public Label lbltotalSup;
    public TextField txtEmail;
    public ChoiceBox <String> itemCatagoryBox;
    public TextField txtCompAddress;
    public TextField txtCompName;
    public TableColumn <?,?> tmMobile;
    public TableColumn <?,?> tmEmail;
    public TableColumn <?,?> tmcompName;
    public TableColumn <?,?> tmCompAddress;
    public TableColumn <?,?> tmItemCode;
    public TableColumn <?,?> tmItemDis;
    public TableColumn <?,?> tmQty;
    public TableColumn <?,?> tmBacthNum;
    public TableColumn <?,?> tmCatagory;
    public TextField txtItemDis;
    public TextField txtBnuM;
    public TextField txtItemCode;
    public TextField txtSupNic;

    //SupplierDao supplierDao = new SupplierDaoImpl();
    SupplierBo supplierBo = (SupplierBo) BoFactory.getBoFactory().getBo(BoFactory.BoTyps.SUPPLIER);

    String[] ca = { "Electrical", "Furniture", "Toys", "Exercise equipment", "Office equipment", "Other"};

    public void initialize() throws SQLException {
        setCellValueFactory();
        loadAllSupplier();
        tableListener();
        totalSupplier();
        itemCatagoryBox.getItems().addAll(ca);

    }

    private void tableListener() {
        supplierAddTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);
        });
    }

    private void clearField() {
        txtSupNic.setText("");
        txtSupName.setText("");
        txtItemDis.setText("");
        txtSupQty.setText("");
        txtSupMobile.setText("");

    }

    private void setCellValueFactory() {
        tmSupId.setCellValueFactory(new PropertyValueFactory<>("supId"));
        tmSupName.setCellValueFactory(new PropertyValueFactory<>("supName"));
        tmMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        tmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tmcompName.setCellValueFactory(new PropertyValueFactory<>("coName"));
        tmCompAddress.setCellValueFactory(new PropertyValueFactory<>("coAddress"));
        tmItemCode.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        tmItemDis.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tmQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tmBacthNum.setCellValueFactory(new PropertyValueFactory<>("bNum"));
        tmCatagory.setCellValueFactory(new PropertyValueFactory<>("catagory"));

    }

    private void setData(SupplierTm row) {
        txtSupNic.setText(row.getSupId());
        txtSupName.setText(row.getSupName());
        txtSupMobile.setText(String.valueOf(row.getMobile()));
        txtEmail.setText(String.valueOf(row.getEmail()));
        txtCompName.setText(row.getCoName());
        txtCompAddress.setText(row.getCoAddress());
        txtItemCode.setText(String.valueOf(row.getItemcode()));
        txtItemDis.setText(row.getItemName());
        txtSupQty.setText(String.valueOf(row.getQty()));
        txtBnuM.setText(String.valueOf(row.getBNum()));
        itemCatagoryBox.setValue(String.valueOf(row.getCatagory()));
    }

    public void addSupplierOnAction(ActionEvent event) {
            String supId = txtSupNic.getText();
            String supName = txtSupName.getText();
            int mobile = Integer.parseInt(txtSupMobile.getText());
            String email = txtEmail.getText();
            String coName = txtCompName.getText();
            String coAddress = txtCompAddress.getText();
            int itemcode = Integer.parseInt(txtItemCode.getText());
            String itemName = txtItemDis.getText();
            int qty = Integer.parseInt(txtSupQty.getText());
            String bNum = txtBnuM.getText();
            String catagory = itemCatagoryBox.getValue();

            try {
                SupplierDTO dto = new SupplierDTO(supId,supName,mobile,email,coName,coAddress,itemcode,itemName,qty,bNum,catagory);
                boolean addSup = supplierBo.add(dto);

                if (addSup) {
                    supplierAddTable.getItems().add(new SupplierTm(supId,supName,mobile,email,coName,coAddress,itemcode,itemName,qty,bNum,catagory));
                    new Alert(Alert.AlertType.CONFIRMATION, "Supplier Added").show();
                    loadAllSupplier();
                    clearField();
                }

            } catch (SQLException | ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            }
        }


    public void deleteSupplierOnAction(ActionEvent event) {
        String sid = txtSupNic.getText();

        try {
            SupplierDTO id = new SupplierDTO(sid);
            boolean isDeleted = supplierBo.delete(id);
            if(isDeleted) {
                supplierAddTable.getSelectionModel().clearSelection();

                new Alert(Alert.AlertType.CONFIRMATION, "Supplier has deleted!").show();
                loadAllSupplier();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier not deleted!").show();
            }
            supplierAddTable.getItems().remove(supplierAddTable.getSelectionModel().getSelectedItem());

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateSupplierOnAction(ActionEvent event) throws IOException {

        String supId = txtSupNic.getText();
        String supName = txtSupName.getText();
        int mobile = Integer.parseInt(txtSupMobile.getText());
        String email = txtEmail.getText();
        String coName = txtCompName.getText();
        String coAddress = txtCompAddress.getText();
        int itemcode = Integer.parseInt(txtItemCode.getText());
        String itemName = txtItemDis.getText();
        int qty = Integer.parseInt(txtSupQty.getText());
        String bNum = txtBnuM.getText();
        String catagory = itemCatagoryBox.getValue();

        try {
            SupplierDTO dto = new SupplierDTO(supName,mobile,email,coName,coAddress,itemcode,itemName,qty,bNum,catagory,supId);
            boolean updateSup = supplierBo.update(dto);

            if (updateSup) {
                supplierAddTable.getItems().add(new SupplierTm(supId,supName,mobile,email,coName,coAddress,itemcode,itemName,qty,bNum,catagory));

                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Update").show();
                loadAllSupplier();
                clearField();
            }


        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void loadAllSupplier() {

        supplierAddTable.getItems().clear();
        try {
            ArrayList <SupplierDTO> allSup = supplierBo.getAll();
            for (SupplierDTO i : allSup){
                supplierAddTable.getItems().add(new SupplierTm(i.getSupNic(), i.getSupName(), i.getMobile(),i.getEmail(),i.getCoName(),i.getCoAddress(),i.getItemcode(),i.getItemName(),i.getQty(),i.getBNum(),i.getCatagory()));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

        public void totalSupplier() throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();
        String sql = "SELECT COUNT(supplier_id) FROM supplier";

        String totalSup = null;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                totalSup = resultSet.getString("COUNT(supplier_id)");
            }
            lbltotalSup.setText(totalSup);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

