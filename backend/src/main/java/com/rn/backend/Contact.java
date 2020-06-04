package com.rn.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String handle;
    private String avatarURL;

    public Contact(Long id, String name, String handle, String avatarURL) {
        Id = id;
        this.name = name;
        this.handle = handle;
        this.avatarURL = avatarURL;
    }

    public Contact(String name, String handle, String avatarURL) {
        this.name = name;
        this.handle = handle;
        this.avatarURL = avatarURL;
    }

    public Contact() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }
}
