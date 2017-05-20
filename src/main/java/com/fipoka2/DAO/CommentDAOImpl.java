package com.fipoka2.DAO;

import com.fipoka2.Entity.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


@Repository
public class CommentDAOImpl implements CommentDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class CommentRowMapper implements RowMapper<Comment>
    {
        @Override
        public Comment mapRow(ResultSet resultSet, int i) throws SQLException
        {
            Comment comment = new Comment();
            comment.setIdComment((resultSet.getLong("id_comment")));
            comment.setIdCommentator(resultSet.getLong("id_commentator"));
            comment.setIdQuest(resultSet.getLong("id_quest"));
            comment.setMessage(resultSet.getString("message"));
            return comment;
        }
    }

    final String allColumns = "SELECT id_comment,id_commentator,id_quest,message FROM comment";

    @Override
    public Collection<Comment> getAllComments()
    {
        final String sql = allColumns;
        List<Comment> comments = jdbcTemplate.query(sql, new CommentDAOImpl.CommentRowMapper());
        return comments;
    }

    @Override
    public Comment getCommentById(long id)
    {
        final String sql = allColumns + "WHERE id = ?";
        Comment comment = jdbcTemplate.queryForObject(sql, new CommentDAOImpl.CommentRowMapper(), id);
        return comment;
    }

    @Override
    public void removeCommentById(long id)
    {
        final String sql = "DELETE FROM comment WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void insertCommentToDb(Comment comment)
    {
        final String sql = "INSERT INTO comment (id_commentator,id_quest,message) VALUES (?,?,?)";
        jdbcTemplate.update(sql,
                comment.getIdCommentator(),
                comment.getIdQuest(),
                comment.getMessage());
    }

    @Override
    public void updateComment(Comment comment)
    {
        final String sql = "UPDATE comment SET id_commentator = ?, id_quest = ?, WHERE id_comment = ?";
        final long id = comment.getIdComment();
        final long id_commentator = comment.getIdCommentator();
        final long id_quest = comment.getIdQuest();
        final String message = comment.getMessage();
        jdbcTemplate.update(sql, id_commentator,id_quest,message,id);
    }
    
}
