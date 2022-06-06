package com.ita.speakukrainian.utils.jdbc.services;

import com.ita.speakukrainian.utils.jdbc.dao.DistrictDAO;
import com.ita.speakukrainian.utils.jdbc.entity.DistrictEntity;

import java.util.List;

public class DistrictServise {
    private final DistrictDAO districtDAO;
    public DistrictServise() {
        districtDAO = new DistrictDAO();
    }
    public List<DistrictEntity> getALLDistrict() {
        return districtDAO.selectAll();
    }
}
