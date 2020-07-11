package org.launch.java.studios.quiz.test;

import org.launch.java.studios.quiz.*;
import org.junit.Test;
import org.launch.java.studios.quiz.customexceptions.NotBinaryException;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class TestBinaryQuestion {

    @Test(expected = NotBinaryException.class)
    public void testNotBinaryExceptionMoreThanTwo() throws NotBinaryException {
        Question binaryQuestion = new BinaryQuestion("To be or not to be?", Arrays.asList("To be", "not to be", "a question?"), Collections.singletonList("Does it matter?"));
        fail("This should not get here: Exception should forbid user from creating a binary question without two and only two elements in possible choices.");
    }

    @Test(expected = NotBinaryException.class)
    public void testNotBinaryExceptionLessThanTwo() throws NotBinaryException {
        Question binaryQuestion = new BinaryQuestion("To be or not to be?", Collections.singletonList("To be"), Collections.singletonList("Does it matter?"));
        fail("This should not get here: Exception should forbid user from creating a binary question without two and only two elements in possible choices.");
    }

}
