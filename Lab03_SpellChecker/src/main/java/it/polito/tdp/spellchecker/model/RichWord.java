package it.polito.tdp.spellchecker.model;
import java.io.Serializable;

public class RichWord implements Serializable {
	String parola;
	boolean correct;

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public RichWord(String parola, boolean correct) {
		this.parola=parola;
		this.correct = correct;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	

}
