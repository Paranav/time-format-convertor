package com.test.britishTimeSpeaker;
import java.util.*;
import java.util.regex.Pattern;

public class BritishTimeSpeaker {

    private static final TimeStyle DEFAULT_TimeStyle = TimeStyle.BRITISH_PAST_TO;



    public String toBritishSpeech(String hhmm, TimeStyle TimeStyle) {
        if (!Pattern.matches("^\\d{2}:\\d{2}$", hhmm)) {
            throw new IllegalArgumentException("Bad format");
        }
        String[] parts = hhmm.split(":");
        int H = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);
        if (H < 0 || H > 23 || M < 0 || M > 59) {
            throw new IllegalArgumentException("Out of range");
        }

        // Special cases
        if (M == 0) {
            if (H == 0) return "midnight";
            if (H == 12) return "noon";
            return hourWord(H) + " o'clock";
        }

        if (TimeStyle == TimeStyle.DIGITAL_READING) {
            return hourWord(H) + " " + numberToWords(M);
        }

        if (M == 15) return "quarter past " + hourWord(H);
        if (M == 30) return "half past " + hourWord(H);
        if (M == 45) return "quarter to " + hourWord((H + 1) % 24);

        if (M < 30) {
            return numberToWords(M) + " past " + hourWord(H);
        } else {
            int to = 60 - M;
            return numberToWords(to) + " to " + hourWord((H + 1) % 24);
        }
    }

    private String hourWord(int hour24) {
        int h = hour24 % 12;
        if (h == 0) h = 12;
        return numberToWords(h);
    }

    private String numberToWords(int n) {
        String[] ones = {
            "zero","one","two","three","four","five","six","seven","eight","nine",
            "ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen",
            "seventeen","eighteen","nineteen"
        };
        String[] tens = { "", "", "twenty", "thirty", "forty", "fifty" };

        if (n < 20) {
        	return ones[n];
        }
        int t = n / 10;
        int r = n % 10;
        if (r == 0) {
        	return tens[t];
        }
        return tens[t] + "-" + ones[r];
    }
}
