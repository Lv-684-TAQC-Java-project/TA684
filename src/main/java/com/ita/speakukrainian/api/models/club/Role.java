package com.ita.speakukrainian.api.models.club;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private int id;
    private String name;
    private List<String> users;
}
