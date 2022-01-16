package za.co.coders23;

import za.co.coders23.domain.Session;
import za.co.coders23.domain.Talk;
import za.co.coders23.domain.Track;
import za.co.coders23.enums.SessionType;
import za.co.coders23.utils.ReadRile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConferenceManagementApplication {
    private static int trackCounter = 0;

    public static void main(String[] args) throws IOException {

        String path = (args.length > 0) ? args[0] : ConferenceManagementApplication.class
                .getClassLoader().getResource("test-input.txt").getPath();

        List<Talk> talks = ReadRile.read(path);

        List<Track> tracks = new ArrayList<>();

        while (!talks.isEmpty()) {
            Track track = new Track(++trackCounter);

            Session morningSession = new Session(SessionType.MORNING);
            Session lunchSession = new Session(SessionType.LUNCH, List.of(new Talk(60, "Lunch")));

            new TalkAllocator(talks, morningSession).allocate();

            Session afternoonSession = new Session(SessionType.AFTERNOON);
            Session networkingEventSession = new Session(SessionType.EVENT, List.of(new Talk(0, "Networking Event ")));

            new TalkAllocator(talks, afternoonSession).allocate();

            track.setSessions(List.of(morningSession, lunchSession, afternoonSession, networkingEventSession));
            tracks.add(track);
        }

        printOutput(tracks);
    }

    public static void printOutput(List<Track> tracks) {
        for(Track track: tracks) {
            System.out.printf("\nTrack %d\n\n", track.getNumber());
            track.getSessions().forEach(Session::printSession);
        }
    }
}
