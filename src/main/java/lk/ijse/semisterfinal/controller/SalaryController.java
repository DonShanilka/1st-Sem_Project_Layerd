package lk.ijse.semisterfinal.controller;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.semisterfinal.Bo.BoFactory;
import lk.ijse.semisterfinal.Bo.Custom.EmployeeBo;
import lk.ijse.semisterfinal.Bo.Custom.SalaryBo;
import lk.ijse.semisterfinal.Bo.Custom.impl.EmployeeBoImpl;
import lk.ijse.semisterfinal.Bo.Custom.impl.SalaryBoImpl;
import lk.ijse.semisterfinal.dto.Tm.SalaryTm;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.dto.SalaryDTO;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;


public class SalaryController implements Initializable {

    public AnchorPane root;
    public DatePicker date;
    public ComboBox<String> comEmpId;
    public TextField lblName;
    public TextArea txtMsg;
    public TableColumn <?, ?> colId;
    public TableColumn <?, ?> colName;
    public TableColumn <?, ?> colDate;
    public TableColumn <?, ?> colSalary;
    public TableColumn <?, ?> colAction;
    public TextField salary;
    public TableView<SalaryTm> salaryTm;
    public TextField txtTo;
    public TextField txtSubject;
    public Text Sending;
    public TableColumn <?,?> colOtH;
    public TableColumn <?,?> colPay1ot;
    public TableColumn <?,?> colBonase;
    public TableColumn <?,?> colEpf;
    public TableColumn <?,?> colEtf;
    public TableColumn <?,?> colPresentDay;
    public TableColumn <?,?> colAbsentDay;
    public TableColumn <?,?> colTotalSalary;
    public TextField pay1HourOt;
    public TextField txtBonase;
    public TextField txtEpf;
    public TextField txtEtf;
    public TextField absent;
    public TextField prsent;
    public TextField oTinH;
    public Label lblTotalSalary;

    SalaryBo salaryBo = (SalaryBo) BoFactory.getBoFactory().getBo(BoFactory.BoTyps.SALARY);
    EmployeeBo employeeBo = (EmployeeBo) BoFactory.getBoFactory().getBo(BoFactory.BoTyps.EMPLOYEE);

    public void initialize() {
        date.setPromptText(String.valueOf(LocalDate.now()));
        loadEmployeeId();
        clearField();
        tableListener();
        setCellValueFactory();
        loadAllSalary();

    }

    private void tableListener() {
        SalaryTm.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
            setData((SalaryTm) newValue);

        });
    }

    private void setData(SalaryTm row) {
        comEmpId.setValue(row.getEmployeeId());
        colName.setText(row.getEmployeeName());
        salary.setText(String.valueOf(row.getSalary()));
        date.setValue(LocalDate.parse(row.getDate()));

    }

    private void clearField() {
        comEmpId.setValue("");
        lblName.setText("");
        salary.setText("");

    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("date"));
        colName.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOtH.setCellValueFactory(new PropertyValueFactory<>("otcount"));
        colPay1ot.setCellValueFactory(new PropertyValueFactory<>("pay1h"));
        colBonase.setCellValueFactory(new PropertyValueFactory<>("bonase"));
        colEpf.setCellValueFactory(new PropertyValueFactory<>("epf"));
        colEtf.setCellValueFactory(new PropertyValueFactory<>("etf"));
        colPresentDay.setCellValueFactory(new PropertyValueFactory<>("prCount"));
        colAbsentDay.setCellValueFactory(new PropertyValueFactory<>("abcount"));
        colTotalSalary.setCellValueFactory(new PropertyValueFactory<>("totalsalary"));

    }


    private void loadEmployeeId() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<AddEmployeeDTO> idList = employeeBo.getAll();

            for (AddEmployeeDTO dto : idList) {
                obList.add(dto.getEmployeeId());
            }

            comEmpId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void comEmpIdOnAction(ActionEvent event) {
        String id = comEmpId.getValue();
        try {
            AddEmployeeDTO dto = employeeBo.searchEmployee(id);
            lblName.setText(dto.getEmployeeName());
            salary.setText(String.valueOf(dto.getBasicSalary()));
            txtTo.setText(dto.getEmail());

        } catch (SQLException e) {
            //new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAllSalary() {

        salaryTm.getItems().clear();

        try {
            List<SalaryDTO> dtoList = salaryBo.getAll();

            for (SalaryDTO dto : dtoList) {

                salaryTm.getItems().add(
                        new SalaryTm(
                                dto.getEmployeeId(),
                                dto.getEmployeeName(),
                                dto.getDate(),
                                dto.getSalary(),
                                dto.getOtcount(),
                                dto.getPay1h(),
                                dto.getBonase(),
                                dto.getEpf(),
                                dto.getEtf(),
                                dto.getPrCount(),
                                dto.getAbcount(),
                                dto.getTotalsalary()

                        )
                );
            }
           
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    int lastSalary;

    public void calTotalSalary() {

        double amount = Double.parseDouble(salary.getText());
        int otHcount = Integer.parseInt(oTinH.getText());
        double pay1h = Double.parseDouble(pay1HourOt.getText());
        double bonase = Double.parseDouble(txtBonase.getText());
        int epf = Integer.parseInt(txtEpf.getText());
        int etf = Integer.parseInt(txtEtf.getText());
        int prCount = Integer.parseInt(prsent.getText());
        int abcount = Integer.parseInt(absent.getText());

        double totSalary =  (amount + bonase + (pay1h * otHcount));
        System.out.println(totSalary);

        int ep = (int) (totSalary * epf / 100);
        System.out.println(ep);

        int et = (int) (totSalary * etf / 100);
        System.out.println(et);

        if (abcount < 24) {
            System.out.println("Hi");
            lastSalary = (int) (totSalary - (ep + et));

            System.out.println("Hello");
            System.out.println("Last Salary Amount" + lastSalary);
            lblTotalSalary.setText(String.valueOf(lastSalary));

        } else if (abcount > 26) {
            System.out.println("26 +");
            int ab = abcount - 24;

            System.out.println("ab" + ab);
            double noPay = ab * (amount / 23);
            System.out.println(noPay);

            lastSalary = (int) (totSalary - ((ep + et) + (noPay)));
            System.out.println(lastSalary);
            lblTotalSalary.setText(String.valueOf(lastSalary));

        }
    }

    public void sendEmailOnAction(ActionEvent event) {

        double amount = Double.parseDouble(salary.getText());
        String id = comEmpId.getValue();
        String Name = lblName.getText();
        String date1 = String.valueOf(date.getValue());
        int otHcount = Integer.parseInt(oTinH.getText());
        double pay1h = Double.parseDouble(pay1HourOt.getText());
        double bonase = Double.parseDouble(txtBonase.getText());
        int epf = Integer.parseInt(txtEpf.getText());
        int etf = Integer.parseInt(txtEtf.getText());
        int prCount = Integer.parseInt(prsent.getText());
        int abcount = Integer.parseInt(absent.getText());
        double totalsalary = Double.parseDouble(lblTotalSalary.getText());

        try {
            SalaryDTO dto = new SalaryDTO(amount,id,Name,date1,otHcount,pay1h,bonase,epf,etf,prCount,abcount,totalsalary);
            boolean isaddite = salaryBo.add(dto);

            if (isaddite) {
                salaryTm.getItems().add(new SalaryTm(dto.getDate(),dto.getEmployeeId(),dto.getEmployeeName(),dto.getSalary(),dto.getOtcount(),dto.getPay1h(), dto.getBonase(),dto.getEpf(),dto.getEtf(),dto.getPrCount(),dto.getAbcount(),dto.getTotalsalary()));

                new Alert(Alert.AlertType.CONFIRMATION, "Add Successful").show();
                clearField();
                loadAllSalary();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        System.out.println("Start");
        Sending.setText("sending...");
        Mail mail = new Mail(); //creating an instance of Mail class
        mail.setMsg(txtMsg.getText());//email message
        mail.setTo(txtTo.getText()); //receiver's mail
        mail.setSubject(txtSubject.getText()); //email subject

        Thread thread = new Thread(mail);
        thread.start();

        System.out.println("end");
        Sending.setText("sended");

        calTotalSalary();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //attendanseP_AB();
        date.setPromptText(String.valueOf(LocalDate.now()));
        loadEmployeeId();
        clearField();
        tableListener();
        setCellValueFactory();
        loadAllSalary();

    }

    public void calSalaryOnAction(ActionEvent actionEvent) {

        calTotalSalary();

    }

    public class Mail implements Runnable {
        private String msg;
        private String to;
        private String subject;

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public boolean outMail() throws MessagingException {
            String from = "nshanilka999@gmail.com"; //sender's email address
            String host = "localhost";

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", 587);
            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("nshanilka999@gmail.com", "bnsy wdyx uyop fbrc");  // email and password
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject(this.subject);
            mimeMessage.setText(this.msg);
            Transport.send(mimeMessage);
            return true;
        }

        public void run() {
            if (msg != null) {
                try {
                    outMail();
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("not sent. empty msg!");
            }
        }
    }
}



