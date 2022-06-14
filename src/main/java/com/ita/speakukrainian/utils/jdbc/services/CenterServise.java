package com.ita.speakukrainian.utils.jdbc.services;

import com.ita.speakukrainian.utils.jdbc.dao.CentersDAO;
import com.ita.speakukrainian.utils.jdbc.entity.CenterEntity;

import java.util.List;

public class CenterServise {
    private final CentersDAO centersDAO;
    public CenterServise() {
        centersDAO = new CentersDAO();
    }

    public List<CenterEntity> getAllCenters() {
        return centersDAO.selectAll();

    }

    public List<CenterEntity> getIdNamesAsc() {
        return centersDAO.selectIdNameAsc();
    }

    public List<CenterEntity> getIdNamesDesc() {
        return centersDAO.selectIdNameDesc();
    }

    public List<CenterEntity> getIdNameRatingByAscCenters() {
        return centersDAO.selectIdNameRatingByAsc();
    }

    public List<CenterEntity> getIdNameRatingByDescCenters() {
        return centersDAO.selectIdNameRatingByDesc();
    }
}
