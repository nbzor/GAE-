package com.cloud.t3.dao;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Valentin
 */
@XmlRootElement
public class TextEntity {

    private String text;

    public TextEntity() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
