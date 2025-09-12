package ru.job4j.srp.example3.model;

/**
 * Пример нарушения SRP - неправильное выделение бизнес-моделей.
 * Данные автора должны быть вынесены в отдельный класс
 */
public class Post {
    private String title;
    private String description;
    private String authorName;
    private String authorEmail;
    private String authorPhone;

    public Post(String title, String description, String authorName, String authorEmail, String authorPhone) {
        this.title = title;
        this.description = description;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authorPhone = authorPhone;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorPhone() {
        return authorPhone;
    }

    public void setAuthorPhone(String authorPhone) {
        this.authorPhone = authorPhone;
    }
}
