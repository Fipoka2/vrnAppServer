package com.fipoka2.Service;

import com.fipoka2.DAO.QuestDAO;
import com.fipoka2.Entity.Quest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Дима on 05.05.2017.
 */
@Service
public class QuestService
{
    @Autowired
    private QuestDAO questDAO;

    public Collection<Quest> getAllQuests()
    {
        return questDAO.getAllQuests();
    }
    public Quest getQuestByID(long id){
        return this.questDAO.getQuestById(id);
    }

    public void removeQuestById(long id)
    {
        this.questDAO.removeQuestById(id);
    }
    public void updateQuest(Quest quest){
        this.questDAO.updateQuest(quest);

    }

    public void insertQuest(Quest quest)
    {
        questDAO.insertQuestToDb(quest);
    }
}
