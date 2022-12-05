package org.example.models;

import java.util.Arrays;
import java.util.Objects;

public class Team {

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";
    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    public Team(String house, String keeper, String seeker, String[] chasers) {
        if (house == null || keeper == null || seeker == null || hasNull(chasers)) {
            throw new IllegalArgumentException("Positions cannot be null");
        }
        if (house.isBlank() || keeper.isBlank() || seeker.isBlank() || hasBlank(chasers)) {
            throw new IllegalArgumentException("Positions cannot be blank");
        }
        if (chasers.length != 3) {
            throw new IllegalArgumentException("There must be 3 chasers on a team");
        }
        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = chasers;
    }

    public Team(Team source) {
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = source.chasers;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        checkParam(house);
        this.house = house;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        checkParam(keeper);
        this.keeper = keeper;
    }

    public String getSeeker() {
        return seeker;
    }

    public void setSeeker(String seeker) {
        checkParam(seeker);
        this.seeker = seeker;
    }

    public String[] getChasers() {
        return chasers;
    }

    public void setChasers(String[] chasers) {
        if (chasers.length != 3 || hasNull(chasers) || hasBlank(chasers)) {
            throw new IllegalArgumentException("Chasers cannot be null or blank and should have 3 players");
        }
        this.chasers = chasers;
    }

    public static String getPositionChaser() {
     return POSITION_CHASER;
    }

    public static String getPositionSeeker() {
     return POSITION_SEEKER;
    }

    public static String getPositionKeeper() {
     return POSITION_KEEPER;
    }

    public static boolean hasNull(String[] chasers) {
        return Arrays.stream(chasers).anyMatch(Objects::isNull);
    }

    public static boolean hasBlank(String[] chasers) {
        return Arrays.stream(chasers).anyMatch(String::isBlank);
    }

    public void checkParam(String param) {
        if (param == null || param.isBlank()) {
            throw new IllegalArgumentException("field cannot be null or blank");
        }
    }

    @Override
    public String toString() {
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: "  + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(this.house, team.house)
                && Objects.equals(this.keeper, team.keeper)
                && Objects.equals(this.seeker, team.seeker)
                && Arrays.toString(this.chasers).equals(Arrays.toString(team.chasers));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.house, this.keeper, this.seeker, Arrays.toString(this.chasers));
    }
}
