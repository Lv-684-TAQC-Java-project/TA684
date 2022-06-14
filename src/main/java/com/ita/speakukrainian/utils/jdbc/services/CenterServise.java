package com.ita.speakukrainian.utils.jdbc.services;

import com.ita.speakukrainian.utils.jdbc.dao.CentersDAO;
import com.ita.speakukrainian.utils.jdbc.entity.CenterEntity;

import java.util.ArrayList;
import java.util.List;

public class CenterServise {
    private final CentersDAO centersDAO;
    public CenterServise() {
        centersDAO = new CentersDAO();
    }

    public List<CenterEntity> getAllCenters() {
        return centersDAO.selectAll();
    }

    public List<CenterEntity> getIdNameRatingByDescCenters() {
        return centersDAO.selectIdNameRatingByDesc();
    }

    public List<String> getNameCenters(List<CenterEntity> list) {
        List<String> nameList = new ArrayList<>();
        for (int i = 0 ; i < list.size(); i++ ){
           nameList.add(list.get(i).getName());
        }
        return nameList;
    }

    public List<Double> getRatingCenters(List<CenterEntity> list) {
        List<Double> ratingList = new ArrayList<>();
        for (int i = 0 ; i < list.size(); i++ ){
                ratingList.add(list.get(i).getRating());
        }
        return ratingList;
    }

    public List<CenterEntity> getIdNameRatingByAscCenters() {
        return centersDAO.selectIdNameRatingByAsc();
    }

}
