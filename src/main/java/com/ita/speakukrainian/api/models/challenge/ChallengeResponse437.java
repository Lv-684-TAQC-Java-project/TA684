package com.ita.speakukrainian.api.models.challenge;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
//@JsonIgnoreProperties(ignoreUnknown = true)

@Data
public class ChallengeResponse437 {
 private int id;
 private String name;
 private String title;
 private String description;
 private String picture;
 private Integer sortNumber;
 private Boolean isActive;
 private List<Task> tasks;
 private User437 user;
 private String registrationLink;
}
