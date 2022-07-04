package com.ita.speakukrainian.api.models.challenge;

import lombok.Data;

@Data
public class Task {
        private int id;
        private String name;
        public String headerText;
        public String picture;
        public String startDate;
}
