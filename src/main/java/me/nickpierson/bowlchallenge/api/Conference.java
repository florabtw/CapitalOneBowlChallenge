package me.nickpierson.bowlchallenge.api;

import java.util.List;

public class Conference {
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}