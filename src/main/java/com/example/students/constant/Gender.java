package com.example.students.constant;

import lombok.Getter;

@Getter
public enum Gender {
    Male("남자"),
    Female("여자");

    private final String desc;

    Gender(String desc) {
        this.desc = desc;
    }
}
