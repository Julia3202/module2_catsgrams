package ru.yandex.practicum.catsgram.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private String id;
    private String email;
    private String username;
    private String nickname;
    private LocalDate birthdate;

    public User(String id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }

}
