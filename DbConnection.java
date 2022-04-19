
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.FileHandler;

public class DbConnection {
    private static DbConnection dbConnection = null;
    private Connection conn;
    FileHandler fh;

    public DbConnection() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("qorganics");
        ds.setUser("root");
        ds.setPort(3306);
        ds.setPassword("");
        try {
            this.conn = ds.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



    public Connection getConnection() {
        return this.conn;
    }

    public static void main(String[] args){
        System.out.println(new DbConnection().getConnection());
    }
}
