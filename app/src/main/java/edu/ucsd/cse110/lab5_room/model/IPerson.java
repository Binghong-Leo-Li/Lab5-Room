package edu.ucsd.cse110.lab5_room.model;

import java.util.List;

public interface IPerson {
    int getId();
    String getName();
    List<String> getNotes();
}
