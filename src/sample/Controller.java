package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import sample.Model.Employee;

import java.util.ArrayList;

public class Controller {

    @FXML
    private TextField entryName;

    @FXML
    private TextField entryId;

    @FXML
    private TextField entrySalary;

    @FXML
    private VBox employeeListView;

    @FXML
    private Button btnSubmit;

    ArrayList<Employee> employeeList = new ArrayList();


    public void onSubmitClick(ActionEvent actionEvent){
        String employeeNameString = entryName.getText();
        String employeeIdString = entryId.getText();
        String employeeSalaryString = entrySalary.getText();

        int employeeIdInt = Integer.parseInt(employeeIdString);
        double employeeSalaryDouble = Double.parseDouble(employeeSalaryString);

        Employee newEmployee = new Employee(employeeNameString, employeeIdInt, employeeSalaryDouble);
        employeeList.add(newEmployee);

        entryName.clear();
        entryId.clear();
        entrySalary.clear();

        updateEmployeeView();

    }

    public void updateEmployeeView(){
        employeeListView.getChildren().clear();

        for (Employee employee : employeeList){
            Text newTextNode = new Text();
            String employeeLine = employee.name + " - " + employee.id + " - $" + employee.salary;

            newTextNode.setText(employeeLine);
            employeeListView.getChildren().add(newTextNode);
        }

    }
}
