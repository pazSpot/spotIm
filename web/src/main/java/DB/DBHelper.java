package DB;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import utilities.Log;

import java.sql.SQLException;
import java.util.List;

public class DBHelper {

    /**
     * Creates jdbc connection to mysql database server
     *
     * @return JdbcTemplate
     * @throws SQLException
     */
    public static JdbcTemplate getJdbcTemplate() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");

        String envToTest = System.getProperty("environment");
        String DB_URL = null;
        String DB_USER = null;
        String DB_PASSWORD = null;
        if (envToTest.equals("qa")) {
            DB_URL = "jdbc:postgresql://qa-postgresql-01.cc3erqbj5b6k.us-east-1.rds.amazonaws.com:5432/lmt";
            DB_USER = "LMTDBAdmin";
            DB_PASSWORD = "LMTPass10";

        } else if (envToTest.equals("stage")) {
            DB_URL = "jdbc:postgresql://stg-postgresql-1.cc3erqbj5b6k.us-east-1.rds.amazonaws.com:5432/lmt";
            DB_USER = "lmtdbread";
            DB_PASSWORD = "lmtread@852741@prod";

        }

        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        return new JdbcTemplate(dataSource);
    }

    /**
     * Returns result set of the query as list of string (Only SELECT)
     *
     * @param sql - SQL query to execute
     * @return List<String>
     * @throws SQLException
     */
    public static List<String> getList(String sql) throws SQLException {
        return getJdbcTemplate().queryForList(sql, String.class);
    }

    /**
     * Returns result set of the query as string (Only SELECT)
     *
     * @param sql - SQL query to execute
     * @return List<String>
     * @throws SQLException
     */

    public static String getString(String sql) throws SQLException {
        Log.info(("Run DB query: '" + sql + "'"));
        try {
            String result = getJdbcTemplate().queryForObject(sql, String.class);
            Log.info(("Value returned from DB: " + result));
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public static String getString_no_reporter(String sql) throws SQLException {
        try {
            String result = getJdbcTemplate().queryForObject(sql, String.class);
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}