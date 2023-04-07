package com.bb.voyage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bb.voyage.dto.MemberDto;
import com.bb.voyage.service.MemberService;
import com.bb.voyage.utils.ScriptWriter;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {

  @Autowired
  MemberService memberService;

  @GetMapping("/join")
  public String join() {
    return "/member/join";
  }
  @PostMapping("/join")
  public String joinProcess(MemberDto memberDto, HttpServletResponse response) throws IOException{
    int result = memberService.insertMember(memberDto);
    if (result > 0) {
        ScriptWriter.alert(response,"회원가입이 완료되었습니다.");
        return "redirect:/member/login";
      } else {
        ScriptWriter.alertAndBack(response, "다시 시도해 주세요.");
        return null;
      }
  }
  @GetMapping("/login")
  public String login() {
    return "/member/login";
  }

  @PostMapping("/login")
  public String loginProcess(
    MemberDto memberDto,
    RedirectAttributes redirectAttributes,
    HttpServletRequest request,
    HttpServletResponse response
  ) throws IOException {
    MemberDto loggedMember = memberService.loginMember(memberDto);
    if (loggedMember == null) {
      return "redirect:/member/login";
    } else {
      HttpSession session = request.getSession();
      session.setAttribute("loggedMember", loggedMember);
      return "redirect:/member/info";
    }
  }

  @GetMapping("/info")
  public String info() {
    return "/member/info";
  }

  @GetMapping("/logout")
  public String logout(
    HttpServletRequest request,
    RedirectAttributes redirectAttributes,
    HttpServletResponse response
  ) {
    HttpSession session = request.getSession();
    session.removeAttribute("loggedMember");
    redirectAttributes.addFlashAttribute("msg", "로그아웃되었습니다.");
    return "redirect:/";
  }

    // 회원 정보 수정
    @GetMapping("/modify")
    public String modify(){
      return "/member/modify";
    }
  
    @PostMapping("/modify")
    public String modify(
    MemberDto memberDto,
    RedirectAttributes redirectAttributes,
    HttpServletRequest request,
    HttpServletResponse response) throws IOException {
      log.info("{}",memberDto);
      int result = memberService.modifyMember(memberDto);
      if(result>0){
        redirectAttributes.addFlashAttribute("msg", "수정되었습니다.");
        MemberDto loggedMember = memberService.loginMember(memberDto);
        HttpSession session = request.getSession();
        session.setAttribute("loggedMember", loggedMember);
        return "redirect:/member/info";
      } else {
        ScriptWriter.alertAndBack(response, "비밀번호를 다시 확인해주세요.");
      } return null;
    }
  
    // 회원 탈퇴
    @GetMapping("/delete")
    public String delete() {
      return "/member/delete";
    }
  
    @PostMapping("/delete")
    public String delete(MemberDto memberDto,
    HttpServletResponse response,
    RedirectAttributes redirectAttributes)  throws IOException{
      int result = memberService.deleteMember(memberDto);
      if(result>0){
        redirectAttributes.addFlashAttribute("msg", "회원 탈퇴 되었습니다.");
        return "redirect:/";
      } else {
        ScriptWriter.alertAndBack(response, "비밀번호를 다시 확인해주세요.");
        return null;
      }
    }

    @PostMapping("/deleteProcess")
    @ResponseBody
    public Map<String, Object> deleteProcess(
    MemberDto memberDto,
    HttpServletRequest request,
    RedirectAttributes redirectAttributes) throws IOException  {
    int result = memberService.deleteMember(memberDto);
    System.out.println(result);
    Map<String, Object> sendJson = new HashMap<>();
    if (result > 0) {
      HttpSession session = request.getSession();
      session.removeAttribute("loggedMember");
      sendJson.put("msg", "ok");
    } else {
      sendJson.put("msg", "fail");
    }
    return sendJson;
    }
}
