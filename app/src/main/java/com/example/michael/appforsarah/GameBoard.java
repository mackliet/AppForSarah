package com.example.michael.appforsarah;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameBoard {
	private static final int NUM_CARDS = 4;
	private ArrayList<String> allWords;
	private ArrayList<String> cardWords;
	private ArrayList<Character> cardSymbols;

	public GameBoard() throws IOException{
		allWords = setupWordList(WordType.SHORT_I);
		cardWords = setupCardWords();
		cardSymbols = setupCardSymbols();
	}

	private ArrayList<Character> setupCardSymbols() {
		ArrayList<Character> cardSymbols = new ArrayList<Character>();
		for(int i=0; i<NUM_CARDS; i++){
			cardSymbols.add('-');
		}
		Random rand = new Random();
		cardSymbols.set(rand.nextInt(NUM_CARDS), '*');
		return cardSymbols;
	}

	private ArrayList<String> setupCardWords() {
		Random rand = new Random();
		ArrayList<String> cardWords = new ArrayList<String>();
		String word;
		while(cardWords.size()<NUM_CARDS){
			word = allWords.get(rand.nextInt(allWords.size()));
			if(!cardWords.contains(word)){
				cardWords.add(word);
			}
		}
		return cardWords;
	}

	private ArrayList<String>setupWordList(WordType type) throws IOException {
		Scanner s;
		ArrayList<String> allWords = new ArrayList<String>();
		try{
			s = new Scanner(new File(getFilePath(type)));
			while(s.hasNext()){
				allWords.add(s.next());
			}
			s.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		if(allWords.size()<NUM_CARDS){
			throw new IOException();
		}
		return allWords;
	}
	
	
	private String getFilePath(WordType type) {
		String path = "wordLists/";
		switch(type){
		case LONG_A:
			path += "longA.txt";
			break;
		case LONG_E:
			path += "longE.txt";
			break;
		case LONG_I:
			path += "longI.txt";
			break;
		case LONG_O:
			path += "longO.txt";
			break;
		case LONG_U:
			path += "longU.txt";
			break;
		case SHORT_A:
			path += "shortA.txt";
			break;
		case SHORT_E:
			path += "shortE.txt";
			break;
		case SHORT_I:
			path += "shortI.txt";
			break;
		case SHORT_O:
			path += "shortO.txt";
			break;
		case SHORT_U:
			path += "shortU.txt";
			break;
		default:
			return null;
		}
		return path;
	}

	public ArrayList<String> getCardWords() {
		return cardWords;
	}
	
	private ArrayList<Character> getSymbols() {
		return cardSymbols;
	}
}
