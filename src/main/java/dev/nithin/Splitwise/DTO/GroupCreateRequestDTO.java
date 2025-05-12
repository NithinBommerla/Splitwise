package dev.nithin.Splitwise.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GroupCreateRequestDTO {
    private String name;
    private String description;
    private int creatorId;
    private List<Integer> userIDs;
}

/*
JSON
{
    "name" : "",
    "description" : "",
    "creatorId" : ,
    "userIDs" : []
}
*/