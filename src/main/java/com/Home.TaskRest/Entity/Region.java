package com.Home.TaskRest.Entity;

import java.math.BigDecimal;

public class Region {
    private BigDecimal regionID;
    private String regionName;

    public BigDecimal getRegionID() {
        return regionID;
    }

    public void setRegionID(BigDecimal regionID) {
        this.regionID = regionID;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
