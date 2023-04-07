package com.bb.voyage.dto;

import lombok.Data;

@Data
public class ReservDto {
    int reservNo;
    int customerNo;
    int selectedPkgNo;
    String reservName;
    String reservBday;
    String reservPassport;
    String reservEmail;
    String reservRegDate;
}


