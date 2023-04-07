package com.bb.voyage.dto;

import lombok.Data;

@Data
public class VipBoardDto {
    private int vipNo;
    private int vipWriterNo; // 세션에서 받아온 멤버 int no를 입력. 이걸 이용해 nickName을 출력하거나, PW확인 실시
    private String vipTitle;
    private String vipContents;
    private String vipRegDate;
    private int vipAvailable;
    private int vipReGroup;
    private int vipReLevel;
    private int vipReStep;
    private int vipHit;
    private int vipNum; // ROWNUM 용 property
}
