package com.ita.speakukrainian.utils.jdbc.entity;

import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data

public class ClubsEntity {
    public static final String SELECT_BY_NAME= "SELECT * FROM clubs WHERE name = '%S'";
    public static final String SELECT_ALL = "SELECT * FROM clubs ORDER BY id";


    private int age_from;
    private int age_to;
    private long center_external_id;
    private long center_id;
    private long club_external_id;
    private String contacts;
    private String description;
    private long feedback_count;
    private long id;
    private boolean is_approved;
   // private boolean is_online;
    private String name;
    private double rating;
    private String url_background;
    private String url_logo;
    private String url_web;
    private long user_id;
    private long work_time;



    public ClubsEntity() {
        this.age_from=0;
        this.age_to=0;
        this.center_external_id=0L;
        this.center_id=0L;
        this.club_external_id = 0L;
        this.contacts=null;
        this.description=null;
        this.feedback_count=0L;
        this.id = 0L;
        this.name = null;
        this.is_approved=true;
        //this.is_online=true;
        this.rating = 0D;
        this.url_background = null;
        this.url_logo=null;
        this.url_web=null;
        this.user_id=0L;
        this.work_time=0L;
    }

    public static ClubsEntity getClub(List<String> row) {
        ClubsEntity club = new ClubsEntity();
        club.setId(Long.parseLong(row.get(0)));
        club.setAge_from(Integer.parseInt(row.get(1)));
        club.setAge_to(Integer.parseInt(row.get(2)));
        //club.setCenter_external_id(Long.parseLong(row.get(4)));
        //club.setClub_external_id(Long.parseLong(row.get(4)));
        club.setContacts(row.get(5));
        club.setDescription(row.get(6));
       // club.setFeedback_count(Long.parseLong(row.get(7)));
        club.setName(row.get(9));
        club.setRating(Double.parseDouble(row.get(10)));
        club.setUrl_background(row.get(11));
        club.setUrl_logo(row.get(12));
        club.setUrl_web(row.get(13));
       // club.setUser_id(Long.parseLong(row.get(14)));
       // club.setWork_time(Long.parseLong(row.get(15)));
        return club;
    }

    public static List<ClubsEntity> getClubs(List<List<String>> rows) {
        List<ClubsEntity> clubs = new ArrayList<>();
        for (List<String> row : rows) {
            clubs.add(getClub(row));
        }
        return clubs;
    }
}
