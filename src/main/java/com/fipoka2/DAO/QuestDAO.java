package com.fipoka2.DAO;

import com.fipoka2.Entity.Quest;

import java.util.Collection;

/**
 * Created by Дима on 04.05.2017.
 */
public interface QuestDAO
{
    Collection<Quest> getAllQuests();
    Quest getQuestById(long id);
    void removeQuestById(long id);
    void updateQuest(Quest quest);
    void insertQuestToDb(Quest quest);
}
