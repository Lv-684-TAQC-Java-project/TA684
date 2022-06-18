package com.ita.speakukrainian.utils.jdbc.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChallengesEntity {

    public static final String SELECT_ALL = "SELECT * FROM challenges WHERE sort_number = '%s%d'";
    public static final String SELECT_NAME_WHERE_ID = "SELECT name FROM challenges WHERE id = '%d'";


    private Long id;
    private String name;
    private String picture;
    private String sortNumber;
    private String title;
    private String description;
    private Boolean isActive;
    private Long users;

    public ChallengesEntity() {
        this.id = null;
        this.name = null;
        this.picture = null;
        this.sortNumber = null;
        this.title = null;
        this.description=null;
        this.isActive=false;
        this.users =null;
    }

    public static ChallengesEntity getChallenge(List<String> row) {
        ChallengesEntity challengesEntity = new ChallengesEntity();
        challengesEntity.setId(Long.parseLong(row.get(0)));
        challengesEntity.setDescription(row.get(1));
        challengesEntity.setIsActive(Boolean.parseBoolean(row.get(2)));
        challengesEntity.setName(row.get(3));
        challengesEntity.setPicture(row.get(4));
        challengesEntity.setSortNumber(row.get(6));
        challengesEntity.setTitle(row.get(7));
        return challengesEntity;
    }
    public static ChallengesEntity getChallengeName(List<String> row) {
        ChallengesEntity challengesEntity = new ChallengesEntity();
        challengesEntity.setName(row.get(0));
        return challengesEntity;
    }

    public static List<ChallengesEntity> getChallenges(List<List<String>> rows) {
        List<ChallengesEntity> challenges = new ArrayList<>();
        for (List<String> row : rows) {
            challenges.add(getChallenge(row));
        }
        return challenges;
    }
    public static List<ChallengesEntity> getChallengesBYName(List<List<String>> rows) {
        List<ChallengesEntity> challenges = new ArrayList<>();
        for (List<String> row : rows) {
            challenges.add(getChallengeName(row));
        }
        return challenges;
    }


}
