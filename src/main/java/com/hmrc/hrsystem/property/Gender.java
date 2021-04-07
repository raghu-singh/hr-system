package com.hmrc.hrsystem.property;

public enum Gender {
    Male("M"), Female("F"), Transgender("T");
    private String desc;
    Gender(String desc){ this.desc = desc;}
}
