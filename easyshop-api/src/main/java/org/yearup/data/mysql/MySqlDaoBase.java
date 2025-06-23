package org.yearup.data.mysql;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class MySqlDaoBase
{
    protected JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public MySqlDaoBase(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected Connection getConnection() throws SQLException
    {
        return dataSource.getConnection();
    }
}
