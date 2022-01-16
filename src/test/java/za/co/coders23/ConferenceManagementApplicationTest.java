package za.co.coders23;

import org.junit.jupiter.api.Test;
import za.co.coders23.domain.Session;
import za.co.coders23.domain.Talk;
import za.co.coders23.domain.Track;
import za.co.coders23.enums.SessionType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConferenceManagementApplicationTest {
    @Test
    void testPrintOutput() {
        Track track = new Track(1);

        track.setSessions(List.of(new Session(SessionType.EVENT, List.of(new Talk(0, "Test")))));

        ConferenceManagementApplication.printOutput(List.of(track));

        assertNotNull(track);
    }
}
