package sc.gads2020_aadpp.models;

import com.google.gson.annotations.SerializedName;

public class IQItem {
//{"name":"Perry Oluwatobi",
// "score":277,
// "country":"Nigeria",
// "badgeUrl":"https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"}
    @SerializedName("name")
    private String name;

    @SerializedName("score")
    private int score;

    @SerializedName("country")
    private String country;

    @SerializedName("badgeUrl")
    private String badgeUrl;

    public IQItem(String name, int score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int hours) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}