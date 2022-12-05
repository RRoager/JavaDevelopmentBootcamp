package src.test;

import org.example.models.Team;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TeamTest {


    @Test
    public void hasNullTest() {
        String[] chasers = new String[] {null, "Ginny", "Katie"};
        assertTrue(Team.hasNull(chasers));
    }

    @Test
    public void hasBlankTest() {
        String[] chasers = new String[] {"    ", "Ginny", "Katie"};
        assertTrue(Team.hasBlank(chasers));
    }


}
