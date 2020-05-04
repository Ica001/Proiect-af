package ToolsAfn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/* starile sunt definite ca niste intregi qi=0.....n */
public class Afd {
	  

     /* functia de trazitie delta definita explicit delta(qi,"a") , delta(qi,"b") , i=0...n , delta==tranzition */ 
  
  public int tranzition(int qi,String letter) {
    	
    	if(qi==0&&letter.equals("a")) {return 0;}
    	else if (qi==0&&letter.equals("b")) {return 1;}
    	else if (qi==1&&letter.equals("a")) {return 2;}
    	else if (qi==1&&letter.equals("b")) {return 1;}
    	else if (qi==2&&letter.equals("a")) {return 3;}
    	else if (qi==2&&letter.equals("b")) {return 1;}
    	else if (qi==3&&letter.equals("a")) {return 0;}
    	else if (qi==3&&letter.equals("b")) {return 1;}
    	else return -1;
    	
     }
  /*funtia de tranzitie delta stelat exemplu: delta*(q0,"abbabba")
   * Modul de calcul exemplu: delta*(q0,"abb")= delta(delta(delta(q0,"a"),"b"),"b") , calculam iterativ incepand din interior
   * delta*==tranzition_extended;
   * */
    public int tranzition_extended(String word) {	
    	int q=0;
    	int i=0;
    	int lenghtOfWord=word.length();
    	while(i<lenghtOfWord) {
    		q=tranzition(q, String.valueOf(word.charAt(i++)));
    	}
    	return q;
    	
    }
    /*functia care verifica daca cuvantul este acceptata de automat *
     * Varianta 1: daca se ajunge la starea finala insemneaza ca automatul accepta cuvantul cazul de fata starea finala este 3 (q3);
 */
   public boolean isAccepted1(String word) {
	   return (tranzition_extended(word)==3) ;

   }
   /*Varianta 2: verificam daca sirul de caratere(cuvantul) se termina cu "baa"*/
   public boolean isAccepted2(String word) {
	  return word.endsWith("baa");
   
   }
   public void showInfoWord(String word) {
	   if (isAccepted2(word)) System.out.println( "Accepted word.");//daca cuvantul este acceptat afisam "Accepted word"
	   else System.out.println( "Unaccepted word."); //altfel afisam "Unaccepted word
	   System.out.println("final state: q"+tranzition_extended(word)+"\n"+"__________________________________"); //afisam starea finala si o linie pentru delimitare
	   
	   
   }
   /*Daca avem o lista de cuvinte incarcata dintr-un fisier am construit urmatoarea functie*/
   public void showWordsListInfo(String path) throws IOException {
	   ArrayList<String> listOfWords=new ArrayList<String>();//creem lista
	   @SuppressWarnings("resource") 
	BufferedReader bfr=new BufferedReader(new FileReader(new File(path)));//initializam un buffer reader cu calea URL a unui fisier
	   String word=""; 
	   while ((word = bfr.readLine()) != null) 	     //pentru fiecare linie citita, incarcam lista cu respectivul cuvant de pe linie. 
	           listOfWords.add(word);
	     for (String element_word : listOfWords) {
	    	 System.out.println(element_word);
			showInfoWord(element_word);        //pentru fiecare cuvant din lista afisam informatiile :cuvantul, Acceptata/Neacceptat, starea finala.
			
		}
   }
 
     
}
