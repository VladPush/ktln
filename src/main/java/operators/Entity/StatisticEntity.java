package operators.Entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "statistic", schema = "kotlin")
public class StatisticEntity {
    private int id;

    private String user;
    @NotEmpty(message = "Заполните имя продукта.")
    private String product;
    @NotEmpty(message = "Заполните номер продукта.")
    private String productNumber;
    @NotEmpty(message = "Выберите этап.")
    private String stage;
    private byte status;
    @NotEmpty(message = "Заполните комментарий.")
    private String comment;
    private Timestamp date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "User", nullable = false, length = 45)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Column(name = "Product", nullable = false, length = 150)
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Column(name = "Product_number", nullable = false, length = 45)
    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    @Column(name = "Stage", nullable = false, length = 80)
    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @Column(name = "Status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Column(name = "Comment", nullable = true, length = 250)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "Date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatisticEntity that = (StatisticEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (productNumber != null ? !productNumber.equals(that.productNumber) : that.productNumber != null)
            return false;
        if (stage != null ? !stage.equals(that.stage) : that.stage != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (productNumber != null ? productNumber.hashCode() : 0);
        result = 31 * result + (stage != null ? stage.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StatisticEntity{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", product='" + product + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", stage='" + stage + '\'' +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}' + "\n";
    }
}
