package com.Home.TaskRest.Service;

import com.Home.TaskRest.Entity.Region;

import java.math.BigDecimal;
import java.util.LinkedList;

public interface DBServiceInterface {
    void createRegion(Region region);
    LinkedList<Region> findRegion(BigDecimal id);
    LinkedList<Region> findAll();
}
