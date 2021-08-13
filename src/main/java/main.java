import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 5; i++) {

            System.out.println("enter which website do you want to play with (Mako/Walla/Ynet) ");
            Scanner in = new Scanner(System.in);
            String whatWebsite = in.next();
            switch (whatWebsite) {
                case ("Mako"):
                    MakoRobot makoRobot = new MakoRobot();
                    Map<String, Integer> wordsCount = makoRobot.getWordsStatistics();
                    System.out.println("You're clue is " + makoRobot.getLongestArticleTitle());
                    System.out.println("what do you think is the most common word in this website?");
                    String commonWord = in.next();
                    if (wordsCount.containsKey(commonWord)) {
                        count = count + wordsCount.get(commonWord).intValue();
                    }
                    break;
                case ("Walla"):
                    WallaRobot wallaRobot = new WallaRobot();
                    Map<String, Integer> wordsCount1 = wallaRobot.getWordsStatistics();
                    System.out.println("You're clue is " + wallaRobot.getLongestArticleTitle());
                    System.out.println("what do you think is the most common word in this website?");
                    String commonWord1 = in.next();
                    if (wordsCount1.containsKey(commonWord1)) {
                        count = count + wordsCount1.get(commonWord1).intValue();
                    }
                    break;
                case ("Ynet"):
                    YnetRobot ynetRobot = new YnetRobot();
                    Map<String, Integer> wordsCount2 = ynetRobot.getWordsStatistics();
                    System.out.println("You're clue is " + ynetRobot.getLongestArticleTitle());
                    System.out.println("what do you think is the most common word in this website?");
                    String commonWord2 = in.next();
                    if (wordsCount2.containsKey(commonWord2)) {
                        count = count + wordsCount2.get(commonWord2).intValue();
                    }
                    break;
            }
            System.out.println("you scored "+count +" points");
        }
    }
}

