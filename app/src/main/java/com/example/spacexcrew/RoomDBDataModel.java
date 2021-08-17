package com.example.spacexcrew;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity (tableName = "table_name")
public class RoomDBDataModel implements Serializable {

    @PrimaryKey( autoGenerate = true)
    private int ID;


    @ColumnInfo(name = "Crew_Member_Name")
    private String name;

    @ColumnInfo(name = "Agency Name")
    private String agency;

    @ColumnInfo(name = "Status")
    private String status;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
