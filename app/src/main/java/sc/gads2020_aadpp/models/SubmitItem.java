package sc.gads2020_aadpp.models;

import com.google.gson.annotations.SerializedName;

public class SubmitItem {

/*
Email Address = entry.1824927963
Name = entry.1877115667
Last Name = entry.2006916086
Link to project = entry.284483984
*/

    @SerializedName("entry.1824927963")
    private String email;

    @SerializedName("entry.1877115667")
    private String name;

    @SerializedName("entry.2006916086")
    private String surname;

    @SerializedName("entry.284483984")
    private String projectLink;

    public SubmitItem(String email, String name, String surname, String projectLink) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.projectLink = projectLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }
}