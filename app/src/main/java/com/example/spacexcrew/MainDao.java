package com.example.spacexcrew;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface MainDao {

    @Insert(onConflict = REPLACE)
    void insert(RoomDBDataModel roomData);

    @Delete
    void delete(RoomDBDataModel roomData);

    @Delete
    void deleteAll(List<RoomDBDataModel> roomDataList);

    @Query("UPDATE table_name SET Crew_Member_Name = :sText WHERE ID = :sID")
    void update(int sID,String sText);

    @Query("SELECT * FROM table_name")
    List<RoomDBDataModel> getAll();

}
