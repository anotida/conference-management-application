package za.co.coders23.domain;

import za.co.coders23.enums.SessionType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Session {
    private SessionType type;
    private List<Talk> talks;

    public Session(SessionType type) {
        this.type = type;
    }

    public void printSession() {
        LocalDateTime timeCounter = LocalDateTime.now().withHour(type.getStartTime()).withMinute(0).withSecond(0);
        for(Talk talk: talks) {
            System.out.printf("%s %s\n", timeCounter.format(DateTimeFormatter.ofPattern("HH:mma")), talk.getTitle());
            timeCounter = timeCounter.plusMinutes(talk.getMinutes());
        }
    }

    public void addTalk(Talk talk) {
        if(talks == null) {
            talks = new ArrayList<>();
        }
        talks.add(talk);
    }
}
