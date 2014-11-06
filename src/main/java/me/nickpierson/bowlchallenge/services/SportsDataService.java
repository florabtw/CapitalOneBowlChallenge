package me.nickpierson.bowlchallenge.services;

import me.nickpierson.bowlchallenge.api.Standings;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface SportsDataService {

    @GET("/ncaafb-t1/teams/{div}/{year}/{season}/standings.json")
    Standings getTeamStandings(
            @Path("div") String div,
            @Path("year") int year,
            @Path("season") String season,
            @Query("api_key") String apiKey
            );
}