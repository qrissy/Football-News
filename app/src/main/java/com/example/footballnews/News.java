package com.example.footballnews;

public class News {

    // The section name
    private String mSectionName;

    // Title of the article
    private String mTitle;

    // Date of publication
    private String mPublishedDate;

    // Website URL of the news
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param sectionName  is the name of the section the news belongs to
     * @param articleTitle is the title of the article
     * @param date         is the date the article is published
     * @param url          is the website URL to find more details about the article
     */
    public News(String sectionName, String articleTitle, String date, String url) {
        mSectionName = sectionName;
        mTitle = articleTitle;
        mPublishedDate = date;
        mUrl = url;
    }

    /**
     * Returns the section name of the article.
     */
    public String getSectionName() {
        return mSectionName;
    }

    /**
     * Returns the title of the article.
     */
    public String getArticleTitle() {
        return mTitle;
    }

    /**
     * Returns the date of publication.
     */
    public String getDate() {
        return mPublishedDate;
    }

    /**
     * Returns the Website URL of the news.
     */
    public String getUrl() {
        return mUrl;
    }
}
