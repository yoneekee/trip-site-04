package com.bb.voyage.service;

import java.util.List;

import com.bb.voyage.dto.FreeBoardDto;
import com.bb.voyage.dto.MemberDto;
import com.bb.voyage.dto.VipBoardDto;

public interface BoardService {
  // =================FreeBoard Related
  int insertFreeBoard(FreeBoardDto freeBoardDto);
  List<FreeBoardDto> getAllFree();    
  FreeBoardDto getOneFree(int no);
  MemberDto getMemberInfo(int no);
  int modifyFreeBoard(FreeBoardDto freeBoardDto);
  int deleteFreeBoard(int freeNo);

  // =================VipBoard Related
  int insertVipBoard(VipBoardDto VipBoardDto);
  List<VipBoardDto> getAllVip();    
  VipBoardDto getOneVip(int no);
  int modifyVipBoard(VipBoardDto VipBoardDto);
  int deleteVipBoard(int VipNo);
  MemberDto getMemberInfo02(int no);
  
}
