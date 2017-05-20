package com.fipoka2.Controller;


import com.fipoka2.Entity.Team;
import com.fipoka2.Service.TeamService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/teams")
public class TeamController
{
    private final Logger logger = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Team> getAllTeams(){

        logger.info("collection of teams was successfully sent.");
        return teamService.getAllTeams();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Team getTeamById(@PathVariable("id") int id){
        logger.info("team with id = " + id + " was successfully sent.");
        return teamService.getTeamById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

    public void deleteTeamById(@PathVariable("id") int id){

        teamService.removeTeamById(id);
        logger.info("Team with id = " + id + " was removed.");
    }

    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTeam(@RequestBody Team team){
        teamService.updateTeam(team);
        logger.info("Team with id = was updated");
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertTeam(@RequestBody Team team){

        try{
            teamService.insertTeam(team);}
        catch (DataAccessException ex)
        {
            logger.error("SQL Exception1",ex.getCause());
            logger.error("SQL Exception2",ex.getRootCause());
            logger.error("SQL Exception3",ex.getMostSpecificCause().getCause());
            logger.error("SQL Exception4",ex.toString());
            logger.error("SQL Exception5",ex.getLocalizedMessage());
            return new ResponseEntity<String>("empty field", HttpStatus.BAD_REQUEST);
        }
        logger.info("team [" + team.toString()+"] was created");
        return new ResponseEntity<String>("it is ok", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/amount",method = RequestMethod.GET)
    public long getUsersAmount(@PathVariable long id){
        return teamService.getUsersAmountByTeam(id);
    }

    // @RequestMapping(value = "/byCourse/{username}",method = RequestMethod.GET)
    //@PreAuthorize("authentication.name == #name " )

}
