package com.ita.speakukrainian.utils.jdbc.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class ClubsEntity {
    public static final String SELECT_BY_NAME = "SELECT * FROM clubs WHERE name = '%s'";
    public static final String SELECT_BY_ID = "SELECT * FROM clubs WHERE id = %d";
    public static final String SELECT_ALL = "SELECT * FROM clubs ORDER BY id";
    public static final String SELECT_ALL_NAME= "SELECT name FROM clubs ORDER BY id";
    public static final String SELECT_BY_USER_ID = "SELECT * FROM clubs WHERE user_id = %d";
    public static final String SELECT_NAME_USER_WHERE_LIKE = "SELECT name FROM clubs WHERE name like 'Anda_usia%'";


    private int ageFrom;
    private int ageTo;
    private long centerExternalId;
    private Long centerId;
    private long clubExternalId;
    private String contacts;
    private String description;
    private long feedbackCount;
    private long id;
    private Boolean isApproved;
    private Boolean isOnline;
    private String name;
    private double rating;
    private String urlBackground;
    private String urlLogo;

    private String urlWeb;
    private long userId;
    private long workTime;


    public ClubsEntity() {
        this.ageFrom = 0;
        this.ageTo = 0;
        this.centerExternalId = 0L;
        this.centerId = null;
        this.clubExternalId = 0L;
        this.contacts = null;
        this.description = null;
        this.feedbackCount = 0L;
        this.id = 0L;
        this.name = null;
        this.isApproved = null;
        this.isOnline = null;
        this.rating = 0D;
        this.urlBackground = null;
        this.urlLogo = null;
        this.urlWeb = null;
        this.userId = 0L;
        this.workTime = 0L;
    }
    public static ClubsEntity getIdName(List<String> row) {
        ClubsEntity club = new ClubsEntity();
        club.setName(row.get(0));
        return club;
    }

    public static ClubsEntity getClub(List<String> row) {
        ClubsEntity club = new ClubsEntity();
        club.setId(Long.parseLong(row.get(0)));
        club.setAgeFrom(Integer.parseInt(row.get(1)));
        club.setAgeTo(Integer.parseInt(row.get(2)));
        if ((row.get(3)) !=null){
        club.setCenterExternalId(Long.parseLong(row.get(3)));}
        if ((row.get(4)) !=null){
        club.setClubExternalId(Long.parseLong(row.get(4)));}
        club.setContacts(row.get(5));
        club.setDescription(row.get(6));
        if (row.get(7) != null) {
            club.setIsApproved(row.get(7) == "t" ? true : false);
        }
        if (row.get(8) != null) {
            club.setIsOnline(row.get(8) == "t" ? true : false);
        }
        club.setName(row.get(9));
        club.setRating(Double.parseDouble(row.get(10)));
        club.setUrlBackground(row.get(11));
        club.setUrlLogo(row.get(12));
        club.setUrlWeb(row.get(13));
        if ((row.get(14)) != null) {
            club.setWorkTime(Long.parseLong(row.get(14)));
        }
        if ((row.get(15)) != null) {
            club.setCenterId(Long.parseLong(row.get(15)));
        }
        if ((row.get(16)) != null) {
            club.setUserId(Long.parseLong(row.get(16)));
        }

        if ((row.get(17)) != null) {
            club.setFeedbackCount(Long.parseLong(row.get(17)));
        }
        return club;
    }

    public static List<ClubsEntity> getClubs(List<List<String>> rows) {
        List<ClubsEntity> clubs = new ArrayList<>();
        for (List<String> row : rows) {
            clubs.add(getClub(row));
        }
        return clubs;
    }

    public static List<ClubsEntity> getIdNames(List<List<String>> rows) {
        List<ClubsEntity> clubs = new ArrayList<>();
        for (List<String> row : rows) {
            clubs.add(getIdName(row));
        }
        return clubs;
    }

}
