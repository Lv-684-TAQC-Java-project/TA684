package com.ita.speakukrainian.utils.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CenterEntity {
    public static final String SELECT_ALL = "SELECT * FROM centers ORDER BY id";
    public static final String SELECT_ID_NAME_RATING_DESC = "SELECT id, name, rating FROM centers ORDER BY rating desc";
    public static final String SELECT_ID_NAME_RATING_ASC = "SELECT id, name, rating FROM centers ORDER BY rating asc";
    private long Id;
    private long centerExternalId;
    private String contact;
    private String descriptions;
    private String name;
    private String urlBackgroundPicture;
    private String urlLogo;
    private String urlWeb;
    private long userId;
    private long clubCount;
    private double rating;


    public static CenterEntity getCenter(List<String> row) {
        CenterEntity center = new CenterEntity();
        center.setId(Long.parseLong(row.get(0)));
        if(row.get(1) != null) {
            center.setCenterExternalId(Long.parseLong(row.get(1)));
        }
        center.setContact(row.get(2));
        center.setDescriptions(row.get(3));
        center.setName(row.get(4));
        center.setUrlBackgroundPicture(row.get(5));
        center.setUrlLogo(row.get(6));
        center.setUrlWeb(row.get(7));
        if(row.get(8) != null) {
            center.setUserId(Long.parseLong(row.get(8)));
        }
        if(row.get(9) != null) {
            center.setClubCount(Long.parseLong(row.get(9)));
        }
        if(row.get(10) != null) {
            center.setRating(Double.parseDouble(row.get(10)));
        }
        return center;

    }

    public static CenterEntity getCenterIdNameRating(List<String> row) {
        CenterEntity center = new CenterEntity();
        center.setId(Long.parseLong(row.get(0)));
        center.setName(row.get(1));
        if(row.get(2) != null) {
            center.setRating(Double.parseDouble(row.get(2)));
        }
        return center;

    }

    public static List<CenterEntity> getCenters(List<List<String>> rows) {
        List<CenterEntity> centers = new ArrayList<>();
        for (List<String> row : rows) {
            centers.add(getCenter(row));
        }
        return centers;
    }

    public static List<CenterEntity> getCentersIdNameRating(List<List<String>> rows) {
        List<CenterEntity> centers = new ArrayList<>();
        for (List<String> row : rows) {
            centers.add(getCenterIdNameRating(row));
        }
        return centers;
    }
}
