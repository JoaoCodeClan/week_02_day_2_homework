package com.codeclan.example.wordcounter;

import com.codeclan.example.wordcounter.models.WordCounter;

import org.junit.Test;
import static org.junit.Assert.*;


public class WordCounterTest {

    String testString = "it was the best of times it was the worst of times";

    @Test
    public void testWordCounter() {
        int result = WordCounter.getCount(testString);
        assertEquals(12, result);
    }
}
