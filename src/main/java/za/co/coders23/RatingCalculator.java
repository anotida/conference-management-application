package za.co.coders23;

import za.co.coders23.domain.Talk;
import za.co.coders23.domain.TalkEvent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RatingCalculator {

    private final Talk talk;

    public int calculate(TalkEvent event) {
        boolean minutesAllocated = event.containsMinutes(talk);
        int ratings = 0;
        if(minutesAllocated) {
            ratings -= 2;
        }

        int remainingMinutes = event.computeRemainingMinutes(talk);

        if(remainingMinutes < 0) {
            ratings -= 10;
        } else if (remainingMinutes == 0) {
            ratings += 10;
        } else if (event.existTalkForRemainMinutes(talk)) {
            ratings += 5;
        } else {
            ratings += 3;
        }
        return ratings;
    }
}
