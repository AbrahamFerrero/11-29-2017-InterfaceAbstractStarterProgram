 

import edu.duke.*; 
import java.util.ArrayList;

/**
 * Created by yury on 10/01/16.
 */
public class Tester {

    public void testGetFollowsWithFile() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markovOne = new MarkovOne();
        markovOne.setRandom(88);
        markovOne.setTraining(st);
        ArrayList<String> list = markovOne.getFollows("he");
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        new Tester().testGetFollowsWithFile();
        // 3 10453
        // 4 3715
//        EfficientMarkovModel em = new EfficientMarkovModel(5);
//        em.setRandom(615);
//        em.setTraining(new FileResource("data/week3/romeo.txt").asString());
    }
}