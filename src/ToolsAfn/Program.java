package ToolsAfn;

import java.io.IOException;
/* Schema este in folderul src*/
public class Program {

	public static void main(String[] args) {
		KeyboardReader keyboardReader=new KeyboardReader(); 
		System.out.println("enter a word with a and b only: ");
		
		String word=keyboardReader.read(); //citim cuvantul la tastatura
		Afd afd=new Afd(); //instantiem afd-ul
		
		afd.showInfoWord(word); //afisam informatiile cuvantului citit la tastatura
		try {
			afd.showWordsListInfo("Words.txt"); 
		} catch (IOException e) {
		     
			e.printStackTrace();
		}
		
		
	}

}
