package com.ita.speakukrainian.api.models.challenge;


import lombok.Data;

import java.util.List;

@Data
public class ChallengeResponseForGet {
 private int id;
 private String name;
 private String title;
 private String description;
 private String picture;
 private Integer sortNumber;
 private Boolean isActive;
 private List<Task> tasks;
 private User user;
 private String registrationLink;
}
