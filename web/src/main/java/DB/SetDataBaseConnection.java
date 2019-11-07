package DB;

import utilities.Log;

import java.sql.*;

public class SetDataBaseConnection {

        public static Statement stmt;
        public static Connection connection;

        /**
         * Set up DB
         */
        public static void setUp() {
            try {
                String envToTest = System.getProperty("environment");
                String DB_URL = null;
                String DB_USER = null;
                String DB_PASSWORD = null;

                if (envToTest.equals("qa")||(envToTest.equals("local"))) {
                    DB_URL = "jdbc:postgresql://qa-postgresql-01.cc3erqbj5b6k.us-east-1.rds.amazonaws.com:5432/lmt";
                    DB_USER = "LMTDBAdmin";
                    DB_PASSWORD = "LMTPass10";

                } else if (envToTest.equals("stage")) {
                    DB_URL = "jdbc:postgresql://stg-postgresql-1.cc3erqbj5b6k.us-east-1.rds.amazonaws.com:5432/lmt";
                    DB_USER = "lmtdbread";
                    DB_PASSWORD = "lmtread@852741@prod";
                }

                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        DB_URL, DB_USER,
                        DB_PASSWORD);
                stmt = connection.createStatement();
                Log.info("DB is connected (" + DB_URL + ")");
            } catch (Exception e) {
                Log.info("DB is not connected!");
                e.printStackTrace();
            }
        }

        /**
         * For executing a command: Not Update MySql
         *
         * @param query
         * @return
         */
        public static String executeQuery(String query) {
            Log.info("Executing query: " + query);
            String result = null;
            try {
                ResultSet res = stmt.executeQuery(query);
                while (res.next()) {
                    result = res.getString(1);
                }
            } catch (SQLException e) {
                Log.info("Unable to execute MySql query." + e);
                e.printStackTrace();
                return String.valueOf(false);
            }
            Log.info("Result = " + result);
            return result;
        }


        /**
         * For update MySql
         *
         * @param query
         * @return
         */
        public static Boolean executeUpdate(String query) {
            try {
                Log.info("MySql query: " + query);
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                System.out.print(("Unable to execute MySql Update." + e));
                e.printStackTrace();
                return false;
            }
            return true;
        }

        /**
         * TearDown DB
         */
        public static void dbTearDown() {
            try {
                if (connection != null) {
                    Log.info("Closing down DB connection.");
                    connection.close();
                }
            } catch (Exception e) {
                System.out.print("Unable to close MySql connection." + e);
                e.printStackTrace();
            }
        }
}