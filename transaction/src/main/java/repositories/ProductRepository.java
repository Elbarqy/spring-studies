package repositories;

import models.Product;
import models.mappers.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PostConstruct
    public void init(){
    }
    /*
    * the downside of serializable is that it's a slower operation but accurate
    * We use nested to ensure roll back on runtime exception
     */
    @Transactional(
            rollbackFor = RuntimeException.class ,
            propagation = Propagation.NESTED,
            isolation = Isolation.SERIALIZABLE)
    public void addProduct(String name){
        String sql = "INSERT INTO product(name) VALUES ('"+name+"')";
        try{
            jdbcTemplate.update(sql);
        }catch(Exception e){
            System.out.println(e.toString());
            throw new RuntimeException(":)");
        }
    }
    @Transactional(readOnly = true)
    public List<Product> getProducts(){
        String sql = "SELECT * from product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }
}
