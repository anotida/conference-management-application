package za.co.coders23.domain;

import lombok.Data;

import java.util.List;

@Data
public class Track {
    private int number;
    private List<Session> sessions;

    public Track(int number) {
        this.number = number;
    }
}
