package com.cloud.t3.dao;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Valentin
 */
@XmlRootElement
public class UrlEntity {
    private String shortURL;
    private String longURL;
    private String kind;
    private String id;
    private String status;

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
