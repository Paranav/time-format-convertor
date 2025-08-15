package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.test.britishTimeSpeaker.BritishTimeSpeaker;
import com.test.britishTimeSpeaker.TimeStyle;


public class AppTest {

	BritishTimeSpeaker britishTimeSpeaker = new BritishTimeSpeaker();
	
    @Test
    public void shouldAnswerWithTrue() {
        assertEquals("one o'clock", britishTimeSpeaker.toBritishSpeech("01:00", TimeStyle.BRITISH_PAST_TO));
        assertEquals("five past two", britishTimeSpeaker.toBritishSpeech("02:05", TimeStyle.BRITISH_PAST_TO));
        assertEquals("ten past three", britishTimeSpeaker.toBritishSpeech("03:10", TimeStyle.BRITISH_PAST_TO));
        assertEquals("quarter past four", britishTimeSpeaker.toBritishSpeech("04:15", TimeStyle.BRITISH_PAST_TO));
        assertEquals("twenty past five", britishTimeSpeaker.toBritishSpeech("05:20", TimeStyle.BRITISH_PAST_TO));
        assertEquals("twenty-five past six", britishTimeSpeaker.toBritishSpeech("06:25", TimeStyle.BRITISH_PAST_TO));
        
        // to Accomodate this specific scenario to type of Time style has been supported in "toBritishSpeech" function 
        assertEquals("six thirty-two", britishTimeSpeaker.toBritishSpeech("06:32", TimeStyle.DIGITAL_READING));
        
        assertEquals("half past seven", britishTimeSpeaker.toBritishSpeech("07:30", TimeStyle.BRITISH_PAST_TO));
        assertEquals("twenty-five to eight", britishTimeSpeaker.toBritishSpeech("07:35", TimeStyle.BRITISH_PAST_TO));
        assertEquals("twenty to nine", britishTimeSpeaker.toBritishSpeech("08:40", TimeStyle.BRITISH_PAST_TO));
        assertEquals("quarter to ten", britishTimeSpeaker.toBritishSpeech("09:45", TimeStyle.BRITISH_PAST_TO));
        assertEquals("ten to eleven", britishTimeSpeaker.toBritishSpeech("10:50", TimeStyle.BRITISH_PAST_TO));
        assertEquals("five to twelve", britishTimeSpeaker.toBritishSpeech("11:55", TimeStyle.BRITISH_PAST_TO));
        assertEquals("midnight", britishTimeSpeaker.toBritishSpeech("00:00", TimeStyle.BRITISH_PAST_TO));
        assertEquals("noon", britishTimeSpeaker.toBritishSpeech("12:00", TimeStyle.BRITISH_PAST_TO));
    }
}
