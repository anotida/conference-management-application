package za.co.coders23;

import org.junit.jupiter.api.Test;
import za.co.coders23.domain.Talk;
import za.co.coders23.domain.TalkEvent;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RatingCalculatorTest {

    @Test
    void testCalculate() {

        List<Talk> talks = new ArrayList<>();

        Talk talk = new Talk(5, "Test");
        talks.add(talk);
        RatingCalculator calculator = new RatingCalculator(talk);

        TalkEvent event = new TalkEvent(talks, 60);
        event.addTalk(new Talk(10, "Test"));
        int ratings = calculator.calculate(event);

        assertNotNull(calculator);
        assertEquals(ratings, 3);
    }
}
