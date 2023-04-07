package com.bb.voyage.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.bb.voyage.dto.FreeBoardDto;
import com.bb.voyage.dto.MemberDto;
import com.bb.voyage.dto.VipBoardDto;

@Mapper
public interface BoardDao {
  // =================FreeBoard Related
  int insertFreeBoard(FreeBoardDto freeBoardDto);
  List<FreeBoardDto> getAllFree();    
  FreeBoardDto getOneFree(int no);
  MemberDto getMemberInfo(int no);
  int modifyFreeBoard(FreeBoardDto freeBoardDto);
  int deleteFreeBoard(int freeNo);

  // =================VipBoard Related
  int insertVipBoard(VipBoardDto vipBoardDto);
  List<VipBoardDto> getAllVip();    
  VipBoardDto getOneVip(int no);
  int modifyVipBoard(VipBoardDto vipBoardDto);
  int deleteVipBoard(int vipNo);
  MemberDto getMemberInfo02(int no);

}

