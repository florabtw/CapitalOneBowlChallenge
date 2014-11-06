package me.nickpierson.bowlchallenge.api;

import java.util.List;

public class Division {
    private List<Conference> conferences;

    public Division() {
    }

    public Division(List<Conference> conferences) {
        super();
        this.conferences = conferences;
    }

    public List<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }
}
