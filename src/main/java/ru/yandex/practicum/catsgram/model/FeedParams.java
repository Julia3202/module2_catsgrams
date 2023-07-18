package ru.yandex.practicum.catsgram.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedParams {
    private String sort;
    private Integer size;
    private List<String> friendsEmails;

}