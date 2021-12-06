package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    private int id;
    private String productName;
    private double price;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @OneToMany(
            mappedBy = "product",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Set<Purchase> purchases;


    public Product(){}
    public Product(int id, String name, double price, LocalDate expirationDate) {
        this.id = id;
        this.productName = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
