/*This class has been created as part of assignment 2. 
 * 
 */
import java.util.*;

public class MarkovFour extends AbstractMarkovModel{
    public MarkovFour() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String toString(){
	    return "MarkovModel of order 4";
	}
    
    public String getRandomText(int numChars){
        StringBuffer sb = new StringBuffer();
        //We'll generate a random key from the file provided.
        int index = myRandom.nextInt(myText.length()-4);
        String key = myText.substring(index, index+4);
        sb.append(key);
        for(int i=0; i< numChars-4; i++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size()==0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1)+next;
        }
        return sb.toString();
    }
    
}