
/**
 * Class given by starter
 * 
 * @author Duke Software
 * @version 1.0
 */

import java.util.*;

public class MarkovZero extends AbstractMarkovModel {
    public MarkovZero() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public String toString(){
	    return "MarkovModel of order 0";
	}
	
	public String getRandomText(int numChars){
        StringBuffer sb = new StringBuffer();
        //We'll generate a random key from the file provided.
        int index = myRandom.nextInt(myText.length()-1);
        String key = myText.substring(index, index+1);
        sb.append(key);
        for(int i=0; i< numChars-1; i++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size()==0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }
        return sb.toString();
    }
}
