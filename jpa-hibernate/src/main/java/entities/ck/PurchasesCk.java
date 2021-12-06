package entities.ck;

import java.io.Serializable;

public class PurchasesCk implements Serializable{
    private int id;


    private int userID;
    private int productID;

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getClass() != obj.getClass()) return false;
        PurchasesCk other = (PurchasesCk) obj;
        return other.getId() == this.getId();
    }

    public int getId() {
        return id;
    }
}
