package com.ita.speakukrainian.api.models.editProfile;

import lombok.Data;

@Data
public class CreateEditProfileRequest {
    public Integer Id;
    public String email;
    public String firstName;
    public String lastName;
    public String phone;
    public String urlLogo;
    public String status;
    public String roleName;

}