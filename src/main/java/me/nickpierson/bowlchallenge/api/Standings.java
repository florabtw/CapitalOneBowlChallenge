package me.nickpierson.bowlchallenge.api;

public class Standings {
    private Division division;

    public Standings() {
    }

    public Standings(Division division) {
        this.setDivision(division);
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

}
