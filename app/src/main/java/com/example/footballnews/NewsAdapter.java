package com.example.footballnews;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Get the {@link News} object located at this position in the list
        News currentNews = getItem(position);

        // Find the TextView with view ID section
        TextView sectionName = convertView.findViewById(R.id.section);
        // Display the section of the current news article in that TextView
        sectionName.setText(currentNews.getSectionName());

        // Find the TextView with view ID title
        TextView articleTitle = convertView.findViewById(R.id.title);
        // Display the title of the current news article in that TextView
        articleTitle.setText(currentNews.getArticleTitle());

        // Create a new Date object from the time in ISO-8601 format of the news.
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date dateObject = null;
        try {
            dateObject = simpleDateFormat.parse(currentNews.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Find the TextView with view ID date
        TextView publishedDate = convertView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984").
        String formattedDate = formatDate(dateObject);
        // Display the date of the current news article in that TextView
        publishedDate.setText(formattedDate);

        // Find the TextView with view ID time
        TextView publishedTime = convertView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM").
        String formattedTime = formatTime(dateObject);
        // Display the time of the current news article in that TextView
        publishedTime.setText(formattedTime);

        // Return the list item view that is now showing the appropriate data
        return convertView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     *
     * @param dateObject is the time of news in ISO-8601 format.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     *
     * @param dateObject is the time of news in ISO-8601 format.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
        timeFormat.setTimeZone(TimeZone.getDefault());
        return timeFormat.format(dateObject);
    }
}
