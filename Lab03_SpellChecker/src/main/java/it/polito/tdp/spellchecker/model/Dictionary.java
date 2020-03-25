package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {
	List <String> dizionario=new ArrayList<String>();
	List <String> list=new ArrayList<String>();
	List<String> paroleSbagliate=new ArrayList<String>();
	String ris;
	
	public void loadDictionary(String language)
	{ 
		String nomeFile="src/main/resources/"+language+".txt";
		
		try
		{
			FileReader fr;
			fr=new FileReader(nomeFile);	
			BufferedReader br=new BufferedReader(fr);
			String word;
			while((word=br.readLine())!=null)
			{
				dizionario.add(word);
			}
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("Errore nella lettura dei file");
		}
	}
	
	public String spellCheckText(String parola)
	{
		this.spezza(parola);
		for(String par:list)
		{	
			boolean check=false;
			for(String s:dizionario)
			{	
				if(par.compareTo(s)==0)
					check=true;
			}
			if(check==false)
				paroleSbagliate.add(par);
		}
		return this.stampa();
	}
	
	public void spezza(String contenuto)
	{
		contenuto.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		String[] campi=contenuto.split(" ");
		list=Arrays.asList(campi);
	}
	
	public String stampa()
	{
		ris="";
		for(String p:paroleSbagliate)
		{
			ris+=p+"\n";
		}
		if(ris.isEmpty())
			return ris; 
		else return ris.substring(0,ris.length()-1);
	}
	
	public int conta()
	{
		return paroleSbagliate.size();
	}
	
	public void reset()
	{
		this.paroleSbagliate.removeAll(paroleSbagliate);
	}
}