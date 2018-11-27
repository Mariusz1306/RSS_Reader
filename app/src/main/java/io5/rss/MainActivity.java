package io5.rss;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private TextView Text;
    private int fails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Text = (TextView) findViewById(R.id.Text);
        String url = "https://wszczecinie.pl/rss/news.xml";
        try {
            RSSFetcher test = new RSSFetcher(url);
            while(true) {
                test.run();
                if (test.isDownloaded())
                    Text.setText(test.getFeed().getAuthor());
                else {
                    String text = "Failed to download " + ++fails + " times";
                    Text.setText(text);
                }
                System.out.print("");
            }
        } catch (Exception e) {
            String text = "Failed to download " + ++fails + " times";
            Text.setText(text);
        }
    }


}