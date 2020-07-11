package org.launch.java.studios.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LinearScale extends MultipleChoiceQuestion {

    public LinearScale(String question, List<String> possibleChoices, List<String> correctAnswer) {
        super(question, possibleChoices, correctAnswer);
    }

    public LinearScale(String question, int linearMax, String correctValueRange) {
        super(question, Arrays.asList(IntStream.rangeClosed(1, linearMax).mapToObj(String::valueOf).toArray(String[]::new)), Arrays.asList(correctValueRange.split("^[, ]+$")));
    }

    @Override
    public String getFullQuestion() {
        return question +"\n" + possibleChoices.toString().replace("[", "").replace("]", "");
    }
}
