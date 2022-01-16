package za.co.coders23;

import za.co.coders23.domain.Session;
import za.co.coders23.domain.Talk;
import za.co.coders23.domain.TalkEvent;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

public class TalkAllocator extends Observable {
    private final TalkEvent event;
    private final Session session;

    public TalkAllocator(List<Talk> talks, Session session) {
        this.session = session;

        event = new TalkEvent(talks, session.getType().getDuration());
    }

    public void allocate() {
        do {
            Talk max = Collections.max(event.getTalks(), Comparator.comparingInt(Talk::getRatings));
            event.addTalk(max);
            session.addTalk(max);

            setChanged();

            notifyObservers(event);
        } while (event.isRemainingTimeApplicable());
    }
}
