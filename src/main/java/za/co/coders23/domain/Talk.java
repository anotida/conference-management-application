package za.co.coders23.domain;

import za.co.coders23.RatingCalculator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Observable;
import java.util.Observer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Talk implements Observer {
    private int minutes;
    private String title;
    private int ratings;

    public Talk(int minutes, String title) {
        this.minutes = minutes;
        this.title = title;
    }

    @Override
    public void update(Observable o, Object arg) {
        TalkEvent event = (TalkEvent) arg;
        ratings = new RatingCalculator(this).calculate(event);
    }

}
