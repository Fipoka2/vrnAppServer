package com.fipoka2.Controller;


import com.fipoka2.Entity.Team;
import com.fipoka2.Service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    TeamService teamService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Team getTeamById(@PathVariable("id") int id){
        return teamService.getTeamById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

    public String deleteTeamById(@PathVariable("id") int id){
        teamService.removeTeamById(id);
        return "deleted";
    }

    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateTeam(@RequestBody Team team){
        teamService.updateTeam(team);
        return "updated";
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertTeam(@RequestBody Team team){
        teamService.insertTeam(team);
        return new ResponseEntity<String>("it is ok", HttpStatus.OK);
    }

    // @RequestMapping(value = "/byCourse/{username}",method = RequestMethod.GET)
    //@PreAuthorize("authentication.name == #name " )

}
