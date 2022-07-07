package com.ita.speakukrainian.api.models.challenge;

import lombok.Data;

import java.util.List;

@Data
public class Task {
        private int id;
        private String name;
        public String headerText;
        public String picture;
        public List<Integer> startDate;
}
