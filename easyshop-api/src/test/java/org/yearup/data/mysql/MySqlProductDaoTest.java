package org.yearup.data.mysql;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.yearup.models.Product;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest

class MySqlProductDaoTest extends BaseDaoTestClass
{
    private MySqlProductDao dao;

    @BeforeEach
    public void setup()
    {
        dao = new MySqlProductDao(dataSource);
    }

    @Test
    public void getById_shouldReturn_theCorrectProduct()
    {
        // arrange
        int productId = 1;
        Product expected = new Product()
        {{
            setProductId(1);
            setName("Smartphone");
            setPrice(new BigDecimal("499.99"));
            setCategoryId(1);
            setDescription("A powerful and feature-rich smartphone for all your communication needs.");
            setColor("Black");
            setStock(50);
            setFeatured(false);
            setImageUrl("smartphone.jpg");
        }};

        // act
        var actual = dao.getById(productId);

        // assert
        assertEquals(expected.getPrice(), actual.getPrice(), "Because I tried to get product 1 from the database.");
    }

    @Test
    public void search_shouldReturnProductsMatchingFilters() throws SQLException
    {
        // arrange
        int categoryId = 1;
        BigDecimal minPrice = new BigDecimal("400.00");
        BigDecimal maxPrice = new BigDecimal("600.00");
        String color = "Black";

        // act
        var results = dao.search(categoryId, minPrice, maxPrice, color);

        // assert
        assertEquals(1, results.size(), "Should return 1 product matching all filters");
        assertEquals("Smartphone", results.get(0).getName());
    }

    @Test
    public void update_shouldModifyExistingProduct_notCreateNew()
    {
        // arrange
        int productId = 1;
        Product product = dao.getById(productId);
        product.setName("Updated Smartphone");

        // act
        dao.update(product);

        // assert
        Product updated = dao.getById(productId);
        assertEquals("Updated Smartphone", updated.getName());

        // confirm no duplicate was created
        var allProducts = dao.getAll();
        long count = allProducts.stream()
                .filter(p -> "Updated Smartphone".equals(p.getName()))
                .count();

        assertEquals(1, count, "Should only be one product with the updated name, no duplicates");
    }


}