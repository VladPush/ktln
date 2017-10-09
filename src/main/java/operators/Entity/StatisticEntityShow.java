package operators.Entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StatisticEntityShow {
    private StringProperty user;
    private StringProperty product;
    private StringProperty productNumber;
    private StringProperty stage;
    private StringProperty status;
    private StringProperty comment;
    private StringProperty date;

    public StatisticEntityShow(String userS, String productS, String productNumberS, String stageS, String statusS, String commentS, String dateS) {
        this.user = new SimpleStringProperty(userS);
        this.product = new SimpleStringProperty(productS);
        this.productNumber = new SimpleStringProperty(productNumberS);
        this.stage = new SimpleStringProperty(stageS);
        this.status = new SimpleStringProperty(statusS);
        this.comment = new SimpleStringProperty(commentS);
        this.date = new SimpleStringProperty(dateS);
    }

    public String getUser() {
        return user.get();
    }

    public StringProperty userProperty() {
        return user;
    }

    public void setUser(String user) {
        this.user.set(user);
    }

    public String getProduct() {
        return product.get();
    }

    public StringProperty productProperty() {
        return product;
    }

    public void setProduct(String product) {
        this.product.set(product);
    }

    public String getProductNumber() {
        return productNumber.get();
    }

    public StringProperty productNumberProperty() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber.set(productNumber);
    }

    public String getStage() {
        return stage.get();
    }

    public StringProperty stageProperty() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage.set(stage);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getComment() {
        return comment.get();
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    @Override
    public String toString() {
        return "StatisticEntityShow{" +
                "user=" + user +
                ", product=" + product +
                ", productNumber=" + productNumber +
                ", stage=" + stage +
                ", status=" + status +
                ", comment=" + comment +
                ", date=" + date +
                '}';
    }
}
