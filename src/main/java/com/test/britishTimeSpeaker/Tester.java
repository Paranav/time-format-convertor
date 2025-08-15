package com.test.britishTimeSpeaker;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
    	BritishTimeSpeaker britishTimeSpeaker = new BritishTimeSpeaker();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        try {
            System.out.println(britishTimeSpeaker.toBritishSpeech(input, TimeStyle.BRITISH_PAST_TO));
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid time. Please provide HH:mm in 24-hour format (e.g., 07:35).");
        }
    }

}
