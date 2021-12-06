package models.mappers;

import models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product myProd = new Product();
        myProd.setId(rs.getInt("id"));
        myProd.setName(rs.getString("name"));
        return myProd;
    }
}
