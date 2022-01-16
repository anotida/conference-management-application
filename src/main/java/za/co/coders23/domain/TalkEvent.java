package za.co.coders23.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TalkEvent {
    List<Talk> talks;
    List<Talk> allocatedTalks;
    int remainingMinutes;

    public TalkEvent(List<Talk> talks, int remainingMinutes) {
        this.talks = talks;
        this.remainingMinutes = remainingMinutes;
    }

    public boolean containsMinutes(Talk talk) {
        return allocatedTalks.stream().anyMatch(t -> t.getMinutes() == talk.getMinutes());
    }

    public int computeRemainingMinutes(Talk talk) {
        return remainingMinutes - talk.getMinutes();
    }

    public boolean existTalkForRemainMinutes(Talk talk) {
        return talks.stream().anyMatch(t -> t.getMinutes() == (remainingMinutes - talk.getMinutes()));
    }

    public void addTalk(Talk talk) {
        if(allocatedTalks == null) {
            allocatedTalks = new ArrayList<>();
        }
        allocatedTalks.add(talk);

        talks.remove(talk);
        remainingMinutes -= talk.getMinutes();
    }

    public boolean isRemainingTimeApplicable() {
        return talks.stream().anyMatch(talk -> talk.getMinutes() <= remainingMinutes);
    }
}
