package org.example.models;

import java.util.HashMap;

public class Game {
    HashMap<Team, Integer> scoreboard;
    private static int gameCount;
    private static final int QUAFFLE_POINTS = 10;
    private static final int SNITCH_POINTS = 150;

    public Game(Team home, Team away) {
        this.scoreboard = new HashMap<>();
        this.scoreboard.put(new Team(home), 0);
        this.scoreboard.put(new Team(away), 0);
        gameCount++;
    }

    public Integer getScore(Team team) {
        return this.scoreboard.get(team);
    }

    public void setScore(Team team, Integer score) {
        if (team == null) {
            throw new IllegalArgumentException("Cannot add null to the scoreboard");
        }
        this.scoreboard.put(team, score);
    }

    public Team getTeam(String name) {
        return this.scoreboard.keySet().stream().filter(t -> t.getHouse().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public String getPlaceholder(String play) {
        return play.substring(play.indexOf("<") + 1, play.indexOf(">"));
    }

    public String replacePlaceholder(String play, String placeholder, String value) {
        return play.replace("<"+placeholder+">", value);
    }

    public void quaffleScore(Team team) {
        this.setScore(team, this.getScore(team) + QUAFFLE_POINTS);
    }

    public void catchSnitch(Team team) {
        this.setScore(team, this.getScore(team) + SNITCH_POINTS);
    }

    public Team getRandomTeam() {
        Object[] teams = scoreboard.keySet().toArray();
        return (Team)teams[random(teams.length)];
    }

    public int random(int range) {
        return (int) (Math.random() * range);
    }

    public String simulate(String play) {
        String placeholder = this.getPlaceholder(play);
        Team team = this.getRandomTeam();
        String value = "";

        if (placeholder.equals(Team.getPositionChaser())) {
            quaffleScore(team);
            value = team.getChasers()[random(team.getChasers().length)];
        } else if (placeholder.equals(Team.getPositionSeeker())) {
            catchSnitch(team);
            value = team.getSeeker();
        } else if (placeholder.equals(Team.getPositionKeeper())) {
            value = team.getKeeper();
        }

        return replacePlaceholder(play, placeholder, value);
    }
}
