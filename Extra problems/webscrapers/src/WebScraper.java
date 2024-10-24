import java.util.ArrayList;

public class WebScraper extends Thread {
    String url;
    final ArrayList<String> sharedData;

    WebScraper(String url, ArrayList<String> sharedData) {
        this.url = url;
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try {
            String data = fetchDataFromUrl(url);// to fetch the data from each url

            synchronized(sharedData) {// synchronize the data
                sharedData.add(data);// storing the data to the arraylist
            }

        } catch (Exception e) {
            System.out.println("Error occurred when fetching data, " + e.getMessage());
        }
    }

    /* th fetch the data from url */
    private String fetchDataFromUrl(String url) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception occurred, " + e.getMessage());
        }
        return "Data from " + url;
    }
}
