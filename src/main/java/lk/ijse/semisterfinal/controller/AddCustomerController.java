package lk.ijse.semisterfinal.controller;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.semisterfinal.Bo.BoFactory;
import lk.ijse.semisterfinal.Bo.Custom.CustomerBo;
import lk.ijse.semisterfinal.Bo.Custom.impl.CustomerBoImpl;
import lk.ijse.semisterfinal.Dao.Custom.AdminLoginDao;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.Tm.CustomerTm;
import lk.ijse.semisterfinal.dto.CusromerDTO;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import static java.awt.SystemColor.text;

public class AddCustomerController implements Initializable {

    public TableView <CustomerTm> CustomerAddTable;
    public TableColumn <?, ?> tbCid;
    public TableColumn <?, ?> tbCname;
    public TableColumn <?, ?> tbCaddress;
    public TableColumn <?, ?> tbCmobile;
    public TableColumn <?, ?> tbCpayment;
    public TableColumn <?, ?> tbCitemId;
    public TextField serachItem;
    @FXML
    public TextField txtCustMobile;
    @FXML
    public TextField txtCustName;
    @FXML
    public TextField txtCustPayment;
    @FXML
    public TextField txtCustAddress;
    @FXML
    public TextField txtCustitemId;
    @FXML
    public TextField txtCustId;

    CustomerBo customerBo = (CustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoTyps.CUSTOMER);

    private void clearField() {
        txtCustId.setText("");
        txtCustName.setText("");
        txtCustAddress.setText("");
        txtCustMobile.setText("");
        txtCustPayment.setText("");
        txtCustitemId.setText("");

    }


    private void tableListener() {
        CustomerAddTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);

        });
    }

    private void setData(CustomerTm row) {
        txtCustId.setText(row.getId());
        txtCustAddress.setText(row.getAddress());
        txtCustName.setText(row.getName());
        txtCustMobile.setText(row.getTel());
        txtCustitemId.setText(row.getItemId());
        txtCustPayment.setText(row.getPayment());

    }


    public void CustomerUpdateOnAction(ActionEvent event) throws IOException {
        String custId = txtCustId.getText();
        String custAddress = txtCustAddress.getText();
        String custName = txtCustName.getText();
        String custMobile = txtCustMobile.getText();
        String custItemid = txtCustitemId.getText();
        String custPayment = txtCustPayment.getText();

        try {
            if (!validateCustomer()){
                return;
            }

            CusromerDTO dto = new CusromerDTO(custId,custAddress,custName,custMobile,custItemid,custPayment);
            boolean isSave= customerBo.update(dto);
            if (isSave){

                new Alert(Alert.AlertType.CONFIRMATION,"Customer is Added").show();
                loadAllCustomer();
                clearField();
            }
            CustomerAddTable.getItems().add(new CustomerTm(custId,custAddress,custName,custMobile,custItemid,custPayment));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void CustomerDeleteOnAction(ActionEvent event) {
        String cid = txtCustId.getText();

        try{
            CusromerDTO id = new CusromerDTO(cid);
            boolean isDelete = customerBo.delete(id);

            if (isDelete){
                CustomerAddTable.getSelectionModel().clearSelection();

                new Alert(Alert.AlertType.CONFIRMATION,"Customer deleted").show();
                loadAllCustomer();
                clearField();
            }
            CustomerAddTable.getItems().remove(CustomerAddTable.getSelectionModel().getSelectedItem());
            loadAllCustomer();

        }catch (SQLException | ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void CustomerAddOnAction(ActionEvent event) {
        String custId = txtCustId.getText();
        String custAddress = txtCustAddress.getText();
        String custName = txtCustName.getText();
        String custMobile = txtCustMobile.getText();
        String custItemid = txtCustitemId.getText();
        String custPayment = txtCustPayment.getText();

        try {
            if (!validateCustomer()){
                return;
            }

            CusromerDTO dto = new CusromerDTO(custId,custAddress,custName,custMobile,custItemid,custPayment);
            boolean isSave= customerBo.Add(dto);
            if (isSave){

                new Alert(Alert.AlertType.CONFIRMATION,"Customer is Added").show();
                loadAllCustomer();
                clearField();
            }
            CustomerAddTable.getItems().add(new CustomerTm(custId,custAddress,custName,custMobile,custItemid,custPayment));
            loadAllCustomer();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void initialize() {
        setCellValueFactory();
        loadAllCustomer();
        clearField();
    }

    private void setCellValueFactory() {
        tbCid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbCname.setCellValueFactory(new PropertyValueFactory<>("name"));
        tbCaddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tbCmobile.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tbCpayment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        tbCitemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));

    }

    private void loadAllCustomer() {

        CustomerAddTable.getItems().clear();

        try {
            List <CusromerDTO> dtoList = customerBo.getAll();

            for (CusromerDTO dto : dtoList) {
                CustomerAddTable.getItems().addAll(
                        new CustomerTm(
                                dto.getTxtCustId(),
                                dto.getTxtCustName(),
                                dto.getTxtCustAddress(),
                                dto.getTxtCustMobile(),
                                dto.getTxtCustitemId(),
                                dto.getTxtCustPayment()
                        )
                );
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validateCustomer() {
        boolean isValidate = true;
        boolean address = Pattern.matches("[A-Za-z]{0,}",txtCustAddress.getText());
        if (!address){
            showErrorNotification("Invalid Address", "The Address you entered is invalid");
            isValidate = false;
        }
        boolean mobile = Pattern.matches("^([0-9]{9}|[0-9]{10})$",txtCustMobile.getText());
        if (!mobile){
            showErrorNotification("Invalid Mobile", "The Mobile Number you entered is invalid");
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllCustomer();
        setCellValueFactory();
        clearField();
        itemSerachOnAction();
        tableListener();
    }


    public void itemSerachOnAction() {
            FilteredList<CustomerTm> filteredData = new FilteredList<>(CustomerAddTable.getItems(), b -> true);
            serachItem.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(item -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String serchKey = newValue.toLowerCase();

                    if (item.getTel().toString().contains(serchKey)) {
                        return true;
                    } else if (item.getId().toLowerCase().contains(serchKey)) {
                        return true;
                    } else return false;
                });
            });
            
            SortedList<CustomerTm> sortedList = new SortedList<>(filteredData);
            sortedList.comparatorProperty().bind(CustomerAddTable.comparatorProperty());
            CustomerAddTable.setItems(sortedList);
    }
}


