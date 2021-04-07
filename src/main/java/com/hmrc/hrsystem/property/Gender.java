package com.hmrc.hrsystem.property;

public enum Gender {
    M("Male"), F("Female"), T("Transgender");
    private String desc;
    Gender(String desc){ this.desc = desc;}
}
