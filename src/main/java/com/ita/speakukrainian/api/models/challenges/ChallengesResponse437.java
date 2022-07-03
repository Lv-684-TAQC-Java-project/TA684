package com.ita.speakukrainian.api.models.challenges;

import com.github.dockerjava.api.model.Task;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ChallengesResponse437 {
 private int id;
 private String name;
 private String title;
 private String description;
 private String picture;
 private int sortNumber;
 private boolean isActive;
 private ArrayList<Task437> tasks;
 private User437 user;
 private String registrationLink;

}
