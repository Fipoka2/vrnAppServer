package com.fipoka2.DAO;

import com.fipoka2.Entity.Quest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Дима on 05.05.2017.
 */
@Repository
public class QuestDAOImpl implements  QuestDAO
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class QuestRowMapper implements RowMapper<Quest>
    {
        @Override
        public Quest mapRow(ResultSet resultSet, int i) throws SQLException
        {
            Quest quest = new Quest();
            quest.setIdQuest((resultSet.getLong("id_quest")));
            quest.setName(resultSet.getString("name"));
            quest.setDescription(resultSet.getString("description"));
            quest.setIdAdministrator(resultSet.getLong("id_administrator"));
            quest.setAble(resultSet.getBoolean("is_able"));
            quest.setIdPlace(resultSet.getLong("id_place"));
            quest.setReward(resultSet.getLong("reward"));
            quest.setLaunchDate(resultSet.getTime("launch_date"));
            return quest;
        }
    }

    final String allColumns = "SELECT id_quest,name,description,id_place,id_administrator," +
            "launch_date,reward,is_able FROM quest";

    @Override
    public Collection<Quest> getAllQuests()
    {
        final String sql = allColumns;
        List<Quest> quests = jdbcTemplate.query(sql, new QuestRowMapper());
        return quests;
    }

    @Override
    public Quest getQuestById(long id)
    {
        final String sql = allColumns + "WHERE id = ?";
        Quest quest = jdbcTemplate.queryForObject(sql, new QuestDAOImpl.QuestRowMapper(), id);
        return quest;
    }

    @Override
    public void removeQuestById(long id)
    {
        final String sql = "DELETE FROM quest WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void insertQuestToDb(Quest quest)
    {
        final String sql = "INSERT INTO quest (name,description,id_place,id_administrator, " +
                "launch_date,reward,is_able) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                quest.getName(),
                quest.getDescription(),
                quest.getIdAdministrator(),
                quest.getLaunchDate(),
                quest.getReward(),
                quest.isAble());
    }

    @Override
    public void updateQuest(Quest quest)
    {
        final String sql = "UPDATE quest SET name = ?, score = ?, logo_link = ?" +
                ", description = ? WHERE id_quest = ?";
        final long id = quest.getIdQuest();
        final String name = quest.getName();
        final String description = quest.getDescription();
        final long id_administrator = quest.getIdAdministrator();
        final Date launch_date = quest.getLaunchDate();
        final long reward = quest.getReward();
        final boolean is_able = quest.isAble();
        jdbcTemplate.update(sql, name,description,id_administrator,
                launch_date,reward,is_able,id);
    }

}

    