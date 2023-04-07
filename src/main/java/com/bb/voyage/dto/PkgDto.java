package com.bb.voyage.dto;
import lombok.Data;

@Data
public class PkgDto {
    int pkgNo;
    String pkgName;
    String pkgContents;
    String pkgRegion;
    String pkgDepart;
    String pkgArrival;
    int pkgBudget;
    int minBudget; // DB에는 들어가지 않음
    int maxBudget; // DB에는 들어가지 않음
}
