import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MakoRobot extends BaseRobot {

    public MakoRobot(){
        super("https://www.mako.co.il/");
    }

    @Override
    public Map<String, Integer> getWordsStatistics() {
        try {
            Document document = Jsoup.connect(getRootWebsiteUrl()).get();
            Elements elements1 = document.getElementsByAttribute("title");

            HashMap<String, Integer> wordsCount = new HashMap<String,Integer>();

            for (int i = 0; i < elements1.size(); i++){
                try {
                    Element document1 = elements1.get(i).parent();
                    String url = document1.attr("href");
                    Document document2 = Jsoup.connect("https://www.mako.co.il/" + url).get();
                    String text = document2.text();
                    String[] words = text.split(" ");

                    for (int j = 0; j < words.length; j++) {
                        String word = words[j];
                        Integer count = wordsCount.get(word);
                        if (count == null) {
                            count = 0;
                        }
                        wordsCount.put(word, count + 1);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
             return wordsCount;

        }catch (IOException e){
            System.out.println();
        }
        return null;
    }

    @Override
    public void countInArticlesTitles(String text) {
            try {
                Document document = Jsoup.connect(getRootWebsiteUrl()).get();
                Elements elements1 = document.getElementsByAttribute("title");
                String elements = elements1.text();
                String[] words = elements.split("");
                String[] wordsOfText = text.split("");
                int length = wordsOfText.length;
                int count = 0;
                int countOfTextInTheTitle = 0;
                    for (int j = 0 ; j < words.length ;j++){
                        for (int w = 0 ; w < length ;w++){
                            try{
                            if (words[j++].equals(wordsOfText[w]))
                                count++;
                            else
                                count =0;
                             if (count == length ) {
                                 countOfTextInTheTitle++;
                                 count = 0;
                             }}catch (ArrayIndexOutOfBoundsException e){
                                e.printStackTrace();
                             }
                        }
                    }
                System.out.println("this is the result" + countOfTextInTheTitle );

            }catch (IOException e){
                e.printStackTrace();
            }
        }

    @Override
    public String getLongestArticleTitle() {
        try {
            Document document = Jsoup.connect(getRootWebsiteUrl()).get();
            Elements elements1 = document.getElementsByAttribute("title");
            String elements = elements1.text();
            String theLongestArtical = "" ;
            int max =0;
            int count =0;
            for (int i =0; i < elements.length(); i++){
                try {
                    Element document1 = elements1.get(i).parent();
                    String url = document1.attr("href");
                    Document document2 = Jsoup.connect("https://www.mako.co.il/" + url).get();
                    String text = document2.text();
                    String[] words = text.split(" ");
                    for (int j =0; j < words.length; j++){
                        count++;
                    }
                    if (count > max){
                        max = count;
                    theLongestArtical = text;
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return theLongestArtical;
        }catch (IOException e){
            e.printStackTrace();
        }
        return "its was a mistak";
    }
}