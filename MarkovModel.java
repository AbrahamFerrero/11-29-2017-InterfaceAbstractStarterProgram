/*Class copied from the last assignment (11//27/2017) as required in this assignment
 * 
 */
import java.util.*;

public class MarkovModel extends AbstractMarkovModel {
    private int model;
    
    public MarkovModel(int N) {
        myRandom = new Random();
        model = N;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
   /*public void setModel(int N){
        model = N;
    }*/
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String toString(){
	    return "MarkovModel of order " + model;
	}
    
    public String getRandomText(int numChars){
        StringBuffer sb = new StringBuffer();
        //We'll generate a random key from the file provided.
        int index = myRandom.nextInt(myText.length()-model);
        String key = myText.substring(index, index+model);
        sb.append(key);
        for(int i=0; i< numChars-model; i++){
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