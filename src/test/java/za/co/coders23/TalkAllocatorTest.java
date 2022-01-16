package za.co.coders23;

import org.junit.jupiter.api.Test;
import za.co.coders23.domain.Session;
import za.co.coders23.domain.Talk;
import za.co.coders23.enums.SessionType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TalkAllocatorTest {
    @Test
    void testAllocate() {

        Session session = new Session(SessionType.MORNING);

        List<Talk> talks = new ArrayList<>();
        talks.add(new Talk(5, "Test"));

        TalkAllocator talkAllocator = new TalkAllocator(talks, session);
        talkAllocator.allocate();

        assertNotNull(talkAllocator);
        assertNotNull(session.getTalks());
    }
}
