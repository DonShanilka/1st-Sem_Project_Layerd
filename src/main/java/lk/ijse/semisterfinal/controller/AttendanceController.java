package lk.ijse.semisterfinal.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.semisterfinal.Bo.BoFactory;
import lk.ijse.semisterfinal.Bo.Custom.AttendanceBo;
import lk.ijse.semisterfinal.Bo.Custom.EmployeeBo;
import lk.ijse.semisterfinal.Bo.Custom.impl.AttendanceBoImpl;
import lk.ijse.semisterfinal.Bo.Custom.impl.EmployeeBoImpl;
import lk.ijse.semisterfinal.dto.Tm.AtendanceTm;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
import lk.ijse.semisterfinal.dto.AtendanceDTO;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class AttendanceController implements Initializable {

    public AnchorPane root;

    public DatePicker date;
    public ComboBox comEmpId;
    public TextField lblName;
    public TableView <AtendanceTm> atendanceTm;
    public TableColumn <?,?> colId;
    public TableColumn <?,?> colName;
    public TableColumn <?,?> colDate;
    public TableColumn <?,?> colAction;
    public Label newCustomer;
    public DatePicker AttDate;
    public ChoiceBox <String> presentAbsent;
    public TableColumn <?,?> colPa;



    AttendanceBo attendanceBo = (AttendanceBo) BoFactory.getBoFactory().getBo(BoFactory.BoTyps.ATTENDANCE);
    EmployeeBo employeeBo = (EmployeeBo) BoFactory.getBoFactory().getBo(BoFactory.BoTyps.EMPLOYEE);

    private String[] pA = {"Present" , "Absent"};

    public void initialize() {
        AttDate.setPromptText(String.valueOf(LocalDate.now()));
        loadAllEmployee();
        setCellValueFactory();
        loadallAttendance();

    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colPa.setCellValueFactory(new PropertyValueFactory<>("Present"));
    }

    private void tableListener() {
        atendanceTm.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData(newValue);

        });
    }

    private void setData(AtendanceTm row) {
        comEmpId.setValue(row.getEmployeeId());
        lblName.setText(row.getEmployeeName());
        date.setValue(LocalDate.parse(row.getDate()));
        presentAbsent.setValue(row.getPresent());

    }

    private void loadAllEmployee() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            ArrayList<AtendanceDTO> teacherDtos = attendanceBo.getAll();

            for (AtendanceDTO dto : teacherDtos) {
                obList.add(dto.getEmployeeId());
            }
            comEmpId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public void markAtendanseOnAction(ActionEvent event) {
        String date = String.valueOf(AttDate.getValue());
        String id = String.valueOf(comEmpId.getValue());
        String name = lblName.getText();
        String pOra = presentAbsent.getValue();

        try {
            AtendanceDTO dto = new AtendanceDTO(date,id,name,pOra);

            boolean isaddite = attendanceBo.add(dto);
            if (isaddite) {
                new Alert(Alert.AlertType.CONFIRMATION, "Add Successful").show();
                loadAllEmployee();
            }
            atendanceTm.getItems().add(new AtendanceTm(date,id,name,pOra));

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void cmbEmpIdOnAction(ActionEvent event) {
        String id = (String) comEmpId.getValue();
        try {
            AddEmployeeDTO dto = employeeBo.searchEmployee(id);
            lblName.setText(dto.getEmployeeName());
        } catch (SQLException e) {
            //new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void loadallAttendance(){

        atendanceTm.getItems().clear();

        try{
            List<AtendanceDTO> dtoList = attendanceBo.getAll();

            for (AtendanceDTO dto: dtoList) {
                atendanceTm.getItems().addAll(new AtendanceTm(
                        dto.getDate(),
                        dto.getEmployeeId(),
                        dto.getEmployeeName(),
                        dto.getPOra()
                ));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void BackOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AttDate.setPromptText(String.valueOf(LocalDate.now()));
        loadAllEmployee();
        setCellValueFactory();
        presentAbsent.getItems().addAll(pA);
        loadallAttendance();
        tableListener();
    }
}
