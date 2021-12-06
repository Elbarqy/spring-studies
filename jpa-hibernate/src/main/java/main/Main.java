package main;

import entities.Price;
import entities.Product;
import entities.User;
import entities.enums.Currency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();
        User myuser = em.find(User.class,1);
        System.out.println(myuser);
//        Product p = new Product();
//        p.setId(1);
//        p.setProductName("first product");
//        p.setPrice(50.0);
//        p.setExpirationDate(LocalDate.now());
//        Price p = new Price();
//        p.setCurrency(Currency.EGP);
//        p.setAmount(15.6);
//        try{
//            em.getTransaction().begin(); // Starting the transaction
//            em.persist(p);
//            em.getTransaction().commit(); // mirroring the context in the dataBase
//        }catch(Exception e){
//            em.getTransaction().rollback();
//        }
//        em.close();
        System.out.println("no errors so far");
    }
}
