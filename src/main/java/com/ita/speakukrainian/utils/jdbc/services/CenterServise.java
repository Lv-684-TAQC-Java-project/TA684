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
}
