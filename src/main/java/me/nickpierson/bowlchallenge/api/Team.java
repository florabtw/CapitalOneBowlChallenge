package me.nickpierson.bowlchallenge.api;

public class Team {

    private String id;
    private String name;
    private Standing overall;
    private Points points;

    public Team() {
    }

    public Team(String id, String name, Standing overall, Points points) {
        super();
        this.setId(id);
        this.name = name;
        this.overall = overall;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Standing getOverall() {
        return overall;
    }

    public void setOverall(Standing overall) {
        this.overall = overall;
    }

    public Points getPoints() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points;
    }
}