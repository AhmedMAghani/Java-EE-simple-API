package com.Home.TaskRest.Service;

import com.Home.TaskRest.Entity.Region;
import org.sql2o.tools.NamedParameterStatement;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.*;
import java.util.LinkedList;

@Stateless
public class DBService implements DBServiceInterface, Serializable {
    private NamedParameterStatement namedParameterStatement;
    private ResultSet queryResult;
    private LinkedList<Region> regions = new LinkedList<>();
    private final String connString ="jdbc:oracle:thin:hr/hr@localhost:1521:xe";


    @Override
    public void createRegion(Region region) {
        try (Connection jdbcConnection = DriverManager.getConnection(connString)){
            jdbcConnection.setAutoCommit(false);
            namedParameterStatement =new NamedParameterStatement(jdbcConnection,DBStmt.CREATE.getStmt(),false);
            namedParameterStatement.setObject("REGION_ID",region.getRegionID());
            namedParameterStatement.setObject("REGION_NAME",region.getRegionName());
            namedParameterStatement.execute();
            jdbcConnection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateRegion(Region region) {
        try (Connection jdbcConnection = DriverManager.getConnection(connString)){
            jdbcConnection.setAutoCommit(false);
            namedParameterStatement =new NamedParameterStatement(jdbcConnection,DBStmt.UPDATE.getStmt(),false);
            namedParameterStatement.setObject("REGION_ID",region.getRegionID());
            namedParameterStatement.setObject("REGION_NAME",region.getRegionName());
            namedParameterStatement.execute();
            jdbcConnection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public LinkedList<Region> findRegion(BigDecimal id) {
        try(Connection jdbcConnection = DriverManager.getConnection(connString)){
            jdbcConnection.setAutoCommit(false);
            namedParameterStatement =new NamedParameterStatement(jdbcConnection,DBStmt.FIND.getStmt(),false);
            namedParameterStatement.setObject("REGION_ID",id);
            queryResult = namedParameterStatement.executeQuery();
            while(queryResult.next()){
                Region region = new Region();
                region.setRegionID(queryResult.getBigDecimal("REGION_ID"));
                region.setRegionName(queryResult.getString("REGION_NAME"));
                regions.add(region);
            }
            return regions;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public LinkedList<Region> findAll() {
        try(Connection jdbcConnection = DriverManager.getConnection(connString)){
            jdbcConnection.setAutoCommit(false);
            namedParameterStatement =new NamedParameterStatement(jdbcConnection,DBStmt.FIND_ALL.getStmt(),false);
            queryResult = namedParameterStatement.executeQuery();
            while(queryResult.next()){
                Region region = new Region();
                region.setRegionID(queryResult.getBigDecimal("REGION_ID"));
                region.setRegionName(queryResult.getString("REGION_NAME"));
                regions.add(region);
            }
            return regions;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
