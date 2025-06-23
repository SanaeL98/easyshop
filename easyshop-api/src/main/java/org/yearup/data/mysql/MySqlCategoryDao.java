package org.yearup.data.mysql;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{
    public MySqlCategoryDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories()
    {
        String sql = "SELECT * FROM categories";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public Category getById(int categoryId)
    {
        String sql = "SELECT * FROM categories WHERE category_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Category.class), categoryId);
    }

    @Override
    public Category create(Category category)
    {
        String sql = "INSERT INTO categories (name, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, category.getName(), category.getDescription());

        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        category.setCategoryId(newId);
        return category;
    }

    @Override
    public void update(int categoryId, Category category)
    {
        String sql = "UPDATE categories SET name = ?, description = ? WHERE category_id = ?";
        jdbcTemplate.update(sql, category.getName(), category.getDescription(), categoryId);
    }

    @Override
    public void delete(int categoryId)
    {
        String sql = "DELETE FROM categories WHERE category_id = ?";
        jdbcTemplate.update(sql, categoryId);
    }
}

