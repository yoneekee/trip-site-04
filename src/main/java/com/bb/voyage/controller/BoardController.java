package com.bb.voyage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bb.voyage.dto.FreeBoardDto;
import com.bb.voyage.dto.MemberDto;
import com.bb.voyage.dto.VipBoardDto;
import com.bb.voyage.service.BoardService;
import com.bb.voyage.utils.ScriptWriter;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

  @Autowired
  BoardService boardService;

  // =================FreeBoard Relateddd
  @GetMapping("/freeboard")
  public String freeBoard(Model model){
    List<FreeBoardDto> freeList = boardService.getAllFree();
    model.addAttribute("freeList", freeList);
    return "/board/freeboard";
  }
  @GetMapping("/freeboardwrite")
  public String freeBoardWrite() {
    return "/board/freeboardwrite";
  }
  @PostMapping("/freeBoardWrite")
  public String freeBoardWriteProcess(
    FreeBoardDto freeBoardDto,
    RedirectAttributes redirectAttributes, 
    int no
  ) {
    freeBoardDto.setFreeWriterNo(no);
    boardService.insertFreeBoard(freeBoardDto);
    redirectAttributes.addFlashAttribute("msg", "글이 등록되었습니다.");
    return "redirect:/board/freeboard";
  }
  @GetMapping("/freeboardview")
  public String freeBoardView(Model model, int no){
    FreeBoardDto freeBoardDto = boardService.getOneFree(no);
    MemberDto memberDto = boardService.getMemberInfo(no);
    log.info("memberDto==={}", memberDto);

    model.addAttribute("freeBoardDto", freeBoardDto);
    model.addAttribute("memberDto", memberDto);
    return "/board/freeboardview";
  }
  @GetMapping("/freeboardmodify")
  public String freeBoardModify(Model model, int no) {
    FreeBoardDto freeBoardDto = boardService.getOneFree(no);
    model.addAttribute("freeBoardDto", freeBoardDto);
    return "/board/freeboardmodify";
  }
  @PostMapping("/freeBoardModify")
  public String freeBoardModifyProcess(
    FreeBoardDto freeBoardDto,
    RedirectAttributes redirectAttributes, 
    int no
  ) {
    freeBoardDto.setFreeWriterNo(no);
    boardService.modifyFreeBoard(freeBoardDto);
    redirectAttributes.addFlashAttribute("msg", "글이 수정되었습니다.");
    return "redirect:/board/freeboard";
  }
  @GetMapping("/freeboarddelete")
  public String freeBoardDeleteProcess(
    RedirectAttributes redirectAttributes, 
    int no
  ) {
    boardService.deleteFreeBoard(no);
    redirectAttributes.addFlashAttribute("msg", "글이 삭제되었습니다.");
    return "redirect:/board/freeboard";
  }


  // =================VipBoard Related
  @GetMapping("/vipboard")
  public String vipBoard(Model model, HttpServletRequest request, HttpSession session){
    MemberDto memberDto = (MemberDto)session.getAttribute("loggedMember");
    if(memberDto.getUserRank()>2){
    List<VipBoardDto> vipList = boardService.getAllVip();
    model.addAttribute("vipList", vipList);
    return "/board/vipboard";
  } else if(memberDto.getUserRank()< 2){
    return "redirect:/";
  } else {
    return null;
  }
  }
  @GetMapping("/vipboardwrite")
  public String vipBoardWrite(HttpServletRequest request, HttpSession session) {
     MemberDto memberDto = (MemberDto)session.getAttribute("loggedMember");
     if(memberDto.getUserRank()>2){
       return "/board/vipboardwrite";
     } else if(memberDto.getUserRank()< 2) {
      return "redirect:/";
    } else {
    return "/";
    }
  }
  @PostMapping("/vipBoardWrite")
  public String vipBoardWriteProcess(
    VipBoardDto vipBoardDto,
    RedirectAttributes redirectAttributes, 
    int no
  ) {
    vipBoardDto.setVipWriterNo(no);
    boardService.insertVipBoard(vipBoardDto);
    redirectAttributes.addFlashAttribute("msg", "글이 등록되었습니다.");
    return "redirect:/board/vipboard";
  }
  @GetMapping("/vipboardview")
  public String vipBoardView(Model model, int no,
  HttpServletRequest request, HttpSession session){
    MemberDto memberDto02 = (MemberDto)session.getAttribute("loggedMember");
    if(memberDto02.getUserRank()>2){
    VipBoardDto vipBoardDto = boardService.getOneVip(no);
    MemberDto memberDto = boardService.getMemberInfo02(no);
    log.info("memberDto==={}", memberDto);

    model.addAttribute("vipBoardDto", vipBoardDto);
    model.addAttribute("memberDto", memberDto);
    return "/board/vipboardview";
    } else if (memberDto02.getUserRank() < 2){
      return "redirect:/";
    } else {
      return null;
    }
  }
  @GetMapping("/vipboardmodify")
  public String vipBoardModify(Model model, int no,
  HttpServletRequest request, HttpSession session) {
     MemberDto memberDto02 = (MemberDto)session.getAttribute("loggedMember");
    if(memberDto02.getUserRank()>2){
    VipBoardDto vipBoardDto = boardService.getOneVip(no);
    model.addAttribute("vipBoardDto", vipBoardDto);
    return "/board/vipboardmodify";
    } else if (memberDto02.getUserRank() < 2){
      return "redirect:/";
    } else {
      return null;
    }
  }
  @PostMapping("/vipBoardModify")
  public String vipBoardModifyProcess(
    VipBoardDto vipBoardDto,
    RedirectAttributes redirectAttributes, 
    int no
  ) {
    vipBoardDto.setVipWriterNo(no);

    boardService.modifyVipBoard(vipBoardDto);
    redirectAttributes.addFlashAttribute("msg", "글이 수정되었습니다.");
    return "redirect:/board/vipboard";
  }
  @GetMapping("/vipboarddelete")
  public String vipBoardDeleteProcess(
    RedirectAttributes redirectAttributes, 
    int no,
    HttpServletRequest request, HttpSession session
  ) {
     MemberDto memberDto02 = (MemberDto)session.getAttribute("loggedMember");
    if(memberDto02.getUserRank()>2){
    boardService.deleteVipBoard(no);
    redirectAttributes.addFlashAttribute("msg", "글이 삭제되었습니다.");
    return "redirect:/board/vipboard";
    } else if (memberDto02.getUserRank() < 2){
      return "redirect:/";
    } else {
      return null;
    }
  }
}