
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int model;
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
    
    abstract public String getRandomText(int numChars);
    
    protected ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<String>();
        //String phrase = "this is a test yes this is a test.";
        int pos = 0;
        while(pos<myText.length()){
            //Find the key starting from pos.
            int start = myText.indexOf(key,pos);
            //Break if no key found or key is after end of text.
            if(start == -1){
                break;
            }
            if(start+key.length() > myText.length()-1){
                break;
            }
            //Substring the key, add it to the arraylist
            String next = myText.substring(start+key.length(),start+key.length()+1);
            follows.add(next);
            //the position changes to where we found the key.
            pos = start+key.length();
        }
        return follows;
    }
}
