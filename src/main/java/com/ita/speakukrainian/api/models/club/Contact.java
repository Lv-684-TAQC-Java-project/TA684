package com.ita.speakukrainian.api.models.club;

import lombok.Data;

@Data
public class Contact {
    private ContactType contactType;
    private String contactData;
}
