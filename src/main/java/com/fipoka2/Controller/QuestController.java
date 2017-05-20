package com.fipoka2.Controller;


import com.fipoka2.Entity.Quest;
import com.fipoka2.Service.QuestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/quests")
public class QuestController
{
    private final Logger logger = LoggerFactory.getLogger(QuestController.class);

    @Autowired
    private QuestService questService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Quest> getAllQuests(){

        logger.info("collection of teams was successfully sent.");
        return questService.getAllQuests();
    }

}
