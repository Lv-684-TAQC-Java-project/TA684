package com.ita.speakukrainian.api.models.challenges;

import com.github.dockerjava.api.model.Task;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ChallengesResponse437 {
 private int id;
 private String name;
 public String title;
 public String description;
 public String picture;
 public int sortNumber;
 public boolean isActive;
 public ArrayList<Task437> tasks;
 public User437 user;
 public String registrationLink;

}
