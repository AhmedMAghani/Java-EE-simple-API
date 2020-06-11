package com.Home.TaskRest.Service;

public enum DBStmt {
    CREATE("INSERT INTO REGIONS VALUES ( :REGION_ID , :REGION_NAME )"),
    FIND("SELECT * FROM REGIONS WHERE REGION_ID = :REGION_ID"),
    FIND_ALL("SELECT * FROM REGIONS"),
    UPDATE("UPDATE REGIONS SET REGION_NAME = :REGION_NAME WHERE REGION_ID = :REGION_ID");

    private String stmt;
    DBStmt(String stmt) {
        this.stmt = stmt;
    }

    public String getStmt() {
        return stmt;
    }
}
