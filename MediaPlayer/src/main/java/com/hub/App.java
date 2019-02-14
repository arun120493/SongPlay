package com.hub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Media  Player 
 *
 */
public class App {
	
	private volatile static int nextOrPrevious = 0;

	private static Object lock = new Object();

	public static void main(String[] args) {
		
		List<String> songList = new ArrayList<String>();
		
		try {
			/**
			 * song list from file
			 */
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream inputStream = classloader.getResourceAsStream("songList.txt");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			String song;
			while ((song = bufferedReader.readLine()) != null) {
				songList.add(song);
				System.out.println(song);
			}

			bufferedReader.close();
			// Shuffle original playList
			Collections.shuffle(songList);
			
			//for user interruption(Previous or next) song to play
			Thread thread = new Thread(() -> {
				Scanner sc = new Scanner(System.in);
				System.out.println("Wating for interruption (-1 or 1)");
				while (sc.hasNext()) {
					nextOrPrevious = sc.nextInt();
					//System.out.println("Value is " + nextOrPrevious);
					synchronized (lock) {
						lock.notify();
					}
				}
			});
			thread.start();

			/**
			 * Iterating playlist
			 */
			ListIterator<String> iterator = songList.listIterator();
			System.out.println("**************************************");

			System.out.println("Playing random songs in playlist");
			while (iterator.hasNext()) {
				String current = iterator.next();
				System.out.println("Playing song " + current);
				
				synchronized (lock) {
					try {
						lock.wait(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
				if (nextOrPrevious == -1) {
					if (iterator.hasPrevious()) {
						current = iterator.previous();
					}
					if (iterator.hasPrevious()) {
						current = iterator.previous();
					}
					nextOrPrevious = 0;
				}
			}
			System.out.println("PlayList Completed");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
