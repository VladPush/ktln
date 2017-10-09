package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import operators.Entity.StatisticEntity;
import operators.blocks.SessionFactorySinglton;
import operators.blocks.Validation;
import operators.service.StatisticServiceImpl;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;

public class Controller {

    @FXML()
    public Label warningLabel ;

    @FXML()
    public TextField Product;

    @FXML()
    public TextField ProductNumber;

    @FXML()
    public ChoiceBox Stage;

    @FXML()
    public TextArea Comment;

    @FXML()
    public Button AdoptionButton;

    @FXML()
    public Button DeclineButton;

    @FXML()
    public Button StatisticButton;

    private Session session;
    private StatisticServiceImpl statisticService = new StatisticServiceImpl();
   /*  session.close();
       SessionFactorySinglton.closeSessionFactory();*/

    public void initialize() {
        session = SessionFactorySinglton.getSessionFactory().openSession();
        if (session.isOpen())
            warningLabel.setText("Соединение с БД установлено.");
            else
            warningLabel.setText("Нет связи с БД.");

        Comment.setTooltip(new Tooltip("В случае возврата - обязательно\n заполнить причину возврата."));
        Stage.setItems(FXCollections.observableArrayList("Сборка", "Проверка ОТК-1", "Прожиг ПО", "Регулировка",
                "Проверка ОТК-2", "Испытания", "Проверка ОТК-3"));

    }

    public void AdoptionClicked(MouseEvent mouseEvent) {
        StatisticEntity statisticEntity = new StatisticEntity();
        statisticEntity.setComment(Comment.getText().trim()+" ");
        statisticEntity.setDate(Timestamp.from(Instant.from( Instant.now().atZone(ZoneId.of("Europe/Moscow")))));
        statisticEntity.setProduct(Product.getText().trim());
        statisticEntity.setProductNumber(ProductNumber.getText().trim());
        statisticEntity.setStatus((byte)1);
        statisticEntity.setUser("Иванов И.И.");

        if (Stage.getSelectionModel().isEmpty())
            warningLabel.setText("Выберите этап.");
        else
            statisticEntity.setStage(Stage.getValue().toString());


        if (new Validation().val(statisticEntity,warningLabel)){
            statisticService.add(statisticEntity);
            clearInput();
        }

    }

    public void DeclineClicked(MouseEvent mouseEvent) {
        StatisticEntity statisticEntity = new StatisticEntity();
        statisticEntity.setComment(Comment.getText().trim());
        statisticEntity.setDate(Timestamp.from(Instant.from( Instant.now().atZone(ZoneId.of("Europe/Moscow")))));
        statisticEntity.setProduct(Product.getText().trim());
        statisticEntity.setProductNumber(ProductNumber.getText().trim());

        if (Stage.getSelectionModel().isEmpty())
            warningLabel.setText("Выберите этап.");
        else
            statisticEntity.setStage(Stage.getValue().toString());

        statisticEntity.setStatus((byte)0);
        statisticEntity.setUser("Иванов И.И.");


        if (new Validation().val(statisticEntity,warningLabel)){
            statisticService.add(statisticEntity);
            clearInput();
        }
    }

    public void StatisticClicked(MouseEvent mouseEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/ShowStatistics.fxml"));
        javafx.stage.Stage primaryStage  = new Stage();
        primaryStage.setTitle("Таблица статистика");
        Scene scene = new Scene(root/*, 750, 400*/);
        scene.getStylesheets().add(getClass().getResource("/views/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setMaxWidth(1200);
        primaryStage.setMinWidth(850);
      //  primaryStage.setResizable(false);
     //   primaryStage.sizeToScene();
        primaryStage.show();
    }

    private void clearInput(){
        Comment.clear();
        Product.clear();
        ProductNumber.clear();
        warningLabel.setText("");
        // Stage.getSelectionModel().clearSelection();
    }
}



/*
 // format TO string
        ZonedDateTime z = Instant.now().atZone(ZoneId.of("Europe/Moscow"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        String formatted = z.format(formatter);

        // format FROM string
        DateTimeFormatter Parser = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        ZonedDateTime a = LocalDateTime.parse(formatted, Parser).atZone(ZoneId.of("Europe/Moscow"));

        Timestamp timestamp = Timestamp.from(Instant.from( Instant.now().atZone(ZoneId.of("Europe/Moscow"))));

        */