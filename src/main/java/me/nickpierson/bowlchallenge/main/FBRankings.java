package me.nickpierson.bowlchallenge.main;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import me.nickpierson.bowlchallenge.api.Conference;
import me.nickpierson.bowlchallenge.api.Points;
import me.nickpierson.bowlchallenge.api.Standing;
import me.nickpierson.bowlchallenge.api.Standings;
import me.nickpierson.bowlchallenge.api.Team;
import me.nickpierson.bowlchallenge.services.SportsDataService;
import retrofit.RestAdapter;

public class FBRankings {

    public static void main(String[] args) {
        InputStream keyIS = FBRankings.class.getClassLoader().getResourceAsStream("key.txt");

        Scanner keyScanner = new Scanner(keyIS);

        String apiKey = keyScanner.useDelimiter("\\z").next();

        keyScanner.close();

        new FBRankings(apiKey).execute();
    }

    private static final String SPORTS_DATA_ENDPOINT = "http://api.sportsdatallc.org";
    private static final String DIVISION = "FBS";
    private static final String SEASON = "REG";
    private static final int YEAR = 2014;

    private SportsDataService sportsDataService;
    private final String apiKey;

    public FBRankings(String apiKey) {
        this.apiKey = apiKey;

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(SPORTS_DATA_ENDPOINT).build();

        sportsDataService = restAdapter.create(SportsDataService.class);
    }

    private void execute() {
        /* Get standings for division */
        Standings standings = sportsDataService.getTeamStandings(DIVISION, YEAR, SEASON, apiKey);

        /* Dive into standings & extract just teams */
        List<Team> teams = extractTeams(standings);

        /* Sort by win / loss ratio */
        teams.sort((t1, t2) -> Double.compare(t2.getOverall().getWpct(), t1.getOverall().getWpct()));

        /* Print teams */
        printTeams(teams);
    }

    private List<Team> extractTeams(Standings standings) {
        List<Team> teams = new ArrayList<Team>();

        List<Conference> conferences = standings.getDivision().getConferences();
        conferences.stream().forEach(c -> teams.addAll(c.getTeams()));

        return teams;
    }

    private void printTeams(List<Team> teams) {
        /* Print header */
        System.out.printf("%-3s\t%-3s\t%-16s\t%-4s\t%-4s\t%-3s\t%-7s\n", "Pos", "Id", "Name", "Win", "Loss", "For", "Against");
        IntStream.range(0, 71).forEach(i -> System.out.print("-"));
        System.out.println();

        /* Print team info */
        for (int i = 0; i < teams.size(); i++) {
            printTeam(i, teams.get(i));
        }
    }

    private void printTeam(int pos, Team team) {
        Standing standing = team.getOverall();
        Points points = team.getPoints();
        System.out.printf("%-3d\t%-5s\t%-16s\t%-2d\t%-2d\t%-3d\t%-3d\n", pos + 1, team.getId(), team.getName(), standing.getWins(), standing.getLosses(),
                points.getFor(), points.getAgainst());
    }
}