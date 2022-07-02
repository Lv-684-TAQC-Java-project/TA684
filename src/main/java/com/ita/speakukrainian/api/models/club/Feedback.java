package com.ita.speakukrainian.api.models.club;

import lombok.Data;

@Data
public class Feedback {
    private int id;
    private int rate;
    //private Date date;
    private String text;
    private User user;
    private String club;
}
