package za.co.coders23.utils;

import za.co.coders23.domain.Talk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadRile {

    public static List<Talk> read(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<Talk> talks = new ArrayList<>();
        try {
            String line = br.readLine();

            while (line != null) {
                Talk talk = getTalk(line);

                if (talk != null) {
                    talks.add(talk);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return talks;
    }

    public static Talk getTalk(String talkDescription) {

        final String patternString = "^(.+)(\\s+)([0-9]+min|lightning)$";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(talkDescription);

        if (!matcher.find()) {
            return null;
        }

        String title = matcher.group(1);
        String duration = matcher.group(3);

        return new Talk(getDurationFromString(duration), talkDescription);
    }

    private static int getDurationFromString(String duration) {

        if ("lightning".equalsIgnoreCase(duration)) {
            return 5;
        } else {
            duration = duration.replace("min", "");
            return Integer.valueOf(duration);
        }
    }
}
