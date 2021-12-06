package entities;

import entities.ck.PurchasesCk;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(PurchasesCk.class)
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Id
    @Column(name = "user_id")
    private int userID;
    @Id
    @Column(name = "product_id")
    private int productID;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",insertable = false, updatable = false)
    private User user;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", userID=" + userID +
                ", productID=" + productID +
                ", timeStamp=" + timeStamp +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
