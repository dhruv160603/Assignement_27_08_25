package com.example.demo;

public class Lesson {
    String l_title;
    String l_description;
    String video_url;

    Lesson(String l_title, String l_description, String video_url){
        this.l_title = l_title;
        this.l_description = l_description;
        this.video_url = video_url;
    }

    public String getL_description() {
        return l_description;
    }

    public String getL_title() {
        return l_title;
    }

    public String getVideo_url() {
        return video_url;
    }
}
