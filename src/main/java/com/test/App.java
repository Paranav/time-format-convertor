package com.test;

import java.util.Scanner;

import com.test.britishTimeSpeaker.BritishTimeSpeaker;
import com.test.britishTimeSpeaker.*;

public class App {
	public static void main(String[] args) {
		BritishTimeSpeaker britishTimeSpeaker = new BritishTimeSpeaker();
		while (true) {
			System.out.print("Enter time in HH:mm format: ");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine().trim();
			try {
				System.out.println(britishTimeSpeaker.toBritishSpeech(input, TimeStyle.BRITISH_PAST_TO));
			} catch (IllegalArgumentException ex) {
				System.out.println("Invalid time. Please provide HH:mm in 24-hour format (e.g., 07:35).");
			}
		}
	}
}
