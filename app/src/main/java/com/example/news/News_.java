package com.example.news;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News_ implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("language")
    @Expose
    private String language;
  /*  @SerializedName("category")
    @Expose
    private List<String> category = null;*/
    @SerializedName("published")
    @Expose
    private String published;
    public final static Parcelable.Creator<News_> CREATOR = new Creator<News_>() {


        @SuppressWarnings({
                "unchecked"
        })
        public News_ createFromParcel(Parcel in) {
            return new News_(in);
        }

        public News_[] newArray(int size) {
            return (new News_[size]);
        }

    }
            ;

    protected News_(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.author = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((String) in.readValue((String.class.getClassLoader())));
//        in.readList(this.category, (java.lang.String.class.getClassLoader()));
        this.published = ((String) in.readValue((String.class.getClassLoader())));
    }

    public News_() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

   /* public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }*/

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(url);
        dest.writeValue(author);
        dest.writeValue(image);
        dest.writeValue(language);
       // dest.writeList(category);
        dest.writeValue(published);
    }

    public int describeContents() {
        return 0;
    }
}
