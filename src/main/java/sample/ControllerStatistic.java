package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import operators.Entity.StatisticEntity;
import operators.Entity.StatisticEntityShow;
import operators.service.StatisticServiceImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class ControllerStatistic {

    @FXML
    public TableView<StatisticEntityShow> tableView;

    @FXML
    public TableColumn<StatisticEntityShow, String> columnUser;

    @FXML
    public TableColumn<StatisticEntityShow, String> columnProduct;

    @FXML
    public TableColumn<StatisticEntityShow, String> columnProductNumber;

    @FXML
    public TableColumn<StatisticEntityShow, String> columnStage;

    @FXML
    public TableColumn<StatisticEntityShow, String> columnStatus;

    @FXML
    public TableColumn<StatisticEntityShow, String> columnComment;

    @FXML
    public TableColumn<StatisticEntityShow, String> dateTime;

    private ObservableList<StatisticEntityShow> data = FXCollections.observableArrayList();

    public void initialize() {
        List<StatisticEntity> resultList =  new StatisticServiceImpl().getAll();

        resultList.forEach(p-> data.add(new StatisticEntityShow(p.getUser(),p.getProduct(),p.getProductNumber(),
        p.getStage(), getStatus(p.getStatus()),p.getComment(), getTime(p.getDate()))));

        columnUser.setCellValueFactory(new PropertyValueFactory<>("user"));
        columnProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
        columnProductNumber.setCellValueFactory(new PropertyValueFactory<>("productNumber"));
        columnStage.setCellValueFactory(new PropertyValueFactory<>("stage"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        columnComment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        dateTime.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.setItems(data);
    }

    private String getStatus(byte value){
        if (value==0)
            return "Возврат";
        else
            return "Выполнено";
    }

    private String getTime(Timestamp timestamp){
        SimpleDateFormat dateFormat = new SimpleDateFormat(" HH:mm:ss dd.MM.yyyy");
        return dateFormat.format(timestamp);
    }
}
