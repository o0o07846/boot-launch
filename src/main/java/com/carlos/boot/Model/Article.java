package com.carlos.boot.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Article {
    public Article() {
    }

    public Article(Long id, String author, String title, String content, Date createTime, List<Reader> readers) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.readers = readers;
    }

    /**
     * squadName : Super hero squad
     * homeTown : Metro City
     * formed : 2016
     * secretBase : Super tower
     * active : true
     * members : [{"name":"Molecule Man","age":29,"secretIdentity":"Dan Jukes","powers":["Radiation resistance","Turning tiny","Radiation blast"]},{"name":"Madame Uppercut","age":39,"secretIdentity":"Jane Wilson","powers":["Million tonne punch","Damage resistance","Superhuman reflexes"]},{"name":"Eternal Flame","age":1000000,"secretIdentity":"Unknown","powers":["Immortality","Heat Immunity","Inferno","Teleportation","Interdimensional travel"]}]
     */


    @JsonIgnore
    private Long id;
    @JsonProperty("auther")
    private String author;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Reader> readers;

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}



