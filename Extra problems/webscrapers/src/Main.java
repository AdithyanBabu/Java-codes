import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // to store the scraped data from the urls
        ArrayList<String> scrapedData = new ArrayList<>();
        String[] urls = {"https://www.tutorialspoint.com/java/java_lang_threadgroup.htm",
                "https://www.tutorialspoint.com/java/java_thread_pool.htm"};

        // to store the threads
        ArrayList<Thread> threads = new ArrayList<>();
        for (String url: urls) {
            WebScraper webScraper = new WebScraper(url, scrapedData);
            threads.add(webScraper);
            webScraper.start();// to run the thread
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception occurred, " + e.getMessage());
            }
        }

        // printing each data
        System.out.println("Scraped Data:");
        for (String data : scrapedData) {
            System.out.println(data);
        }
    }
}