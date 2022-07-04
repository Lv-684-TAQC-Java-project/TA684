package com.ita.speakukrainian.utils.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UsersEntity {

    public static final String SELECT_FROM_USERS_WHERE_EMAIL = "SELECT * FROM users WHERE email like 'soyec%'";

    private long id;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String userPhone;
    private String userProvider;
    private String userProviderId;
    private boolean status;
    private String userUrlLogo;
    private String userVerificationCode;
    private int roleId;

    public static UsersEntity getUser(List<String> row) {
        UsersEntity user = new UsersEntity();

        user.setId(Long.parseLong(row.get(0)));
        user.setUserEmail(row.get(1));
        user.setUserFirstName(row.get(2));
        user.setUserLastName(row.get(3));
        user.setUserPassword(row.get(4));
        user.setUserPhone(row.get(5));
        if (row.get(6) != null) {
            user.setUserProvider(row.get(6));
        }
        if (row.get(7) != null) {
            user.setUserProviderId(row.get(7));
        }
        user.setStatus(Boolean.parseBoolean(row.get(8)));
        if (row.get(9) != null) {
            user.setUserUrlLogo(row.get(9));
        }
        if (row.get(10) != null) {
            user.setUserVerificationCode(row.get(10));
        }
        user.setRoleId(Integer.parseInt(row.get(11)));

        return user;
    }

    public static List<UsersEntity> getUsers(List<List<String>> rows) {
        List<UsersEntity> users = new ArrayList<>();
        for (List<String> row : rows) {
            users.add(getUser(row));
        }
        return users;
    }
}
