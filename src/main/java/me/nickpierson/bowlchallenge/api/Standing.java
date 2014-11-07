package me.nickpierson.bowlchallenge.api;

public class Standing {

    private int wins;
    private int losses;
    private int ties;
    private double wpct;

    public Standing() {
    }

    public Standing(int wins, int losses, int ties, double wpct) {
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.wpct = wpct;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public double getWpct() {
        return wpct;
    }

    public void setWpct(double wpct) {
        this.wpct = wpct;
    }
}