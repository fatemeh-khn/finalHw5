package pository;

import entites.User;

import java.sql.*;

public class UserRepo {

//    public void  createTable() throws SQLException {
//        Connection connection = pository.MyConnection.getConnection();
//        String sql = "CREATE TABLE User_tbl (id int,username varchar(25),password varchar(25),nationalCode varchar(25),birthday varchar(25))";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.executeUpdate();
//        connection.close();
//    }

    public void userInsert(User user) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "insert into User-tbl  (username,password,nationalCode,birthday)values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getNationalCode());
        preparedStatement.setDate(4, user.getBirthday());
        preparedStatement.executeUpdate();
//        connection.close();
    }

    public boolean findByUserName(User user ) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "Select username , password from User-tbl where username=? && password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet==null){
            return false;
        }else return true;

    }

    public User loadById(int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "Select * from User-tbl where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return buildUser(resultSet);
    }

    public void update(String firstName, int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "UPDATE User-tbl SET username=? WHERE  id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, firstName);
        preparedStatement.setInt(2, id);
        int i = preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "DELETE FROM User-tbl WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int i = preparedStatement.executeUpdate();
    }

//    public boolean contain(String email) throws SQLException {
//        Connection connection = MyConnection.getConnection();
//        String sql = "SELECT count(email)FROM User-tbl where email=?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, email);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            return true;
//        }
//        return false;
//    }

    private User buildUser(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            User user = new User();
//            int id=resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String nationalCode = resultSet.getString("nationalCode");
            String birthday = resultSet.getString("birthday");
//            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setNationalCode(nationalCode);
            user.setBirthday(Date.valueOf(birthday));
            return user;
        }
        return null;
    }
}
