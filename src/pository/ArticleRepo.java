package pository;

import entites.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ArticleRepo {
    public void createTable() throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "CREATE TABLE Article-tbl (id int,title varchar(25),brief varchar(25),content varchar(25),createDate varchar(25),isPublished varchar(25) )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void articleInsert(Article article) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "insert into Article-tbl  ( )values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, article.getId());
        preparedStatement.setString(2, article.getTitle());
        preparedStatement.setString(3, article.getBrief());
        preparedStatement.setString(4, article.getContent());
        preparedStatement.setDate(5, article.getCreateDate());
        preparedStatement.setInt(5, 0);
        preparedStatement.executeQuery();
    }

    public Article getAllArticle() throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "Select title,brief from Article-tbl  ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return buildUArticle(resultSet);
    }
    public Article showArticle() throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "Select * from Article-tbl  ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return buildUArticle(resultSet);
    }

    public Article getArticle(Article article) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "Select * from Article-tbl where title=? || brief=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return buildUArticle(resultSet);
    }

    public Article loadById(int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "Select * from UArticle-tbl where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        return buildUArticle(resultSet);
    }

    public void update(Article article) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "UPDATE Article-tbl SET article=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, article.getId());
        preparedStatement.setString(2, article.getTitle());
        preparedStatement.setString(3, article.getBrief());
        preparedStatement.setString(4, article.getContent());
        preparedStatement.setDate(5, article.getCreateDate());
        preparedStatement.setInt(6, 0);
        int i = preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "DELETE FROM Article-tbl WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int i = preparedStatement.executeUpdate();
    }

    public boolean contain(String email) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "SELECT count(email)FROM Article-tbl where email=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return true;
        }
        return false;
    }

    private Article buildUArticle(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Article article = new Article();
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String brief = resultSet.getString("brief");
            String content = resultSet.getString("content");
            Date createDate = resultSet.getDate("createDate");
            boolean isPublished = resultSet.getBoolean("isPublished");
            article.setId(id);
            article.setTitle(title);
            article.setBrief(brief);
            article.setContent(content);
            article.setCreateDate((java.sql.Date) createDate);
            article.setPublished(isPublished);
            return article;
        }
        return null;
    }
   }
