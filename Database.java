import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
    private final Connection dbConnection;
    private PreparedStatement insertPrepStmt;
    private PreparedStatement updatePrepStmt;
    private PreparedStatement deletePrepStmt;
    private PreparedStatement selectPrepStmt;

    public Database(){
        dbConnection = new DbConnection().getConnection();
    }

    public int insertUser(UserModel userModel){
        int result = 0;
        String insertSQL = "INSERT INTO emp(id, name, age) VALUES(?,?,?)";
        try {
            insertPrepStmt = dbConnection.prepareStatement(insertSQL);
            insertPrepStmt.setInt(1, userModel.getId());
            insertPrepStmt.setString(2, userModel.getName());
            insertPrepStmt.setInt(3, userModel.getAge());
            result = insertPrepStmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public ArrayList<UserModel> getUsers(){
        ArrayList<UserModel> userModels = new ArrayList<>();
        String selectQuery = "SELECT id, name, age FROM emp";
        try {
            selectPrepStmt = dbConnection.prepareStatement(selectQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = selectPrepStmt.executeQuery();
            while(rs.next()){
                UserModel userModel =  new UserModel();
                userModel.setId(rs.getInt(1));
                userModel.setName(rs.getString(2));
                userModel.setAge(rs.getInt(3));
                userModels.add(userModel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userModels;
    }

    public int updateUser(UserModel userModel){
        int result = 0;
        String insertSQL = "UPDATE emp SET name=?, age=? WHERE id=?";
        try {
            updatePrepStmt = dbConnection.prepareStatement(insertSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            updatePrepStmt.setInt(3, userModel.getId());
            updatePrepStmt.setString(1, userModel.getName());
            updatePrepStmt.setInt(2, userModel.getAge());
            result = updatePrepStmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public int deleteUser(UserModel userModel){
        int result = 0;
        String insertSQL = "DELETE FROM emp WHERE id=?";
        try {
            deletePrepStmt = dbConnection.prepareStatement(insertSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            deletePrepStmt.setInt(1, userModel.getId());
            result = deletePrepStmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
