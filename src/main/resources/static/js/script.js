AOS.init({
  duration: 600,
  delay: 200,
});

const swiper = new Swiper(".discount-banner", {
  slidesPerView: 3,
  spaceBetween: 20,
  loop: true,
  navigation: {
    nextEl: ".discount-banner .btn--next",
    prevEl: ".discount-banner .btn--prev",
  },
});

const picker01 = new Lightpick({
  field: document.querySelector("#datepicker01"),
  format: "YYYY/MM/DD",
});
const picker02 = new Lightpick({
  field: document.querySelector("#datepicker02"),
  format: "YYYY/MM/DD",
});
const picker03 = new Lightpick({
  field: document.querySelector("#datepicker03"),
  format: "YYYY/MM/DD",
});

const btnTop = document.querySelector(".btn-top");
btnTop.addEventListener("click", function () {
  window.scrollTo({ top: 0, behavior: "smooth" });
});

const header = document.querySelector(".header");
window.addEventListener("scroll", function (e) {
  if (window.scrollY > 0) {
    header.classList.add("on");
    btnTop.classList.add("on");
  } else {
    header.classList.remove("on");
    btnTop.classList.remove("on");
  }
});

$(".sessionCheck").on("click", function () {
  if (session == null) {
    alert("You need to login to utilize this function.");
    return false;
  }
});

$(".vipCheck").on("click", function () {
  if (session.userRank < 2) {
    alert("You need to be a vip to utilize this function");
    return false;
  }
});

if (msg) {
  memoModal.show();
}

$("#btnDeleteAjax").on("click", function (e) {
  //e.preventDefault();
  isState = "delete";
  $("#deleteModal .modal-title").text("Enter password to delete your account.");
  deleteModal.show();
  return false;
});

$("#btnDeleteBoardAjax").on("click", function (e) {
  //e.preventDefault();
  isState = "delete";
  $("#deleteBoardModal .modal-title").text("Enter password to delete your board content.");
  deleteBoardModal.show();
  return false;
});

$("#btnDeleteBoardAjax").on("click", function (e) {
  //e.preventDefault();
  isState = "delete";
  $("#deleteBoardModal .modal-title").text("Enter password to delete your board content.");
  deleteBoardModal.show();
  return false;
});

$("#btnVipDeleteBoardAjax").on("click", function (e) {
  //e.preventDefault();
  isState = "delete";
  $("#deleteVipBoardModal .modal-title").text("Enter password to delete your board content (vip)");
  deleteVipBoardModal.show();
  return false;
});

$("#btnDeleteConfirm").on("click", function (e) {
  $.ajax({
    url: "/member/deleteProcess", // 해당 함수 필요 (responsebody)
    data: { no: session.no, userPw: $("#userPw_check").val() },
    type: "POST",
    success: function (response) {
      console.log(response);
      if (response.msg === "ok") {
        alert('Your account has been successfully deleted!')
        setTimeout(function () {
          location.href = "/";
        }, 500);
      } else {
        alert('Wrong password. Try again.');
        location.reload();
      }
    },
  });
});

/*
$("#btnBoardDeleteConfirm").on("click", function (e) {
  $.ajax({
    url: "/board/freeboarddelete", // 해당 함수 필요 (responsebody)
    data: { no: session.no, userPw: $("#userPw_check").val() },
    type: "POST",
    success: function (response) {
      console.log(response);
      if (response.msg === "ok") {
        alert('Your content has been successfully deleted!')
        setTimeout(function () {
          location.href = "/";
        }, 500);
      } else {
        alert('Wrong password. Try again.');
        location.reload();
      }
    },
  });
});
$("#btnVipBoardDeleteConfirm").on("click", function (e) {
  $.ajax({
    url: "/board/vipboarddelete", // 해당 함수 필요 (responsebody)
    data: { no: session.no, userPw: $("#userPw_check").val() },
    type: "POST",
    success: function (response) {
      console.log(response);
      if (response.msg === "ok") {
        alert('Your content has been successfully deleted!')
        setTimeout(function () {
          location.href = "/";
        }, 500);
      } else {
        alert('Wrong password. Try again.');
        location.reload();
      }
    },
  });
});
*/

/////////////////////////////////////////////////////////////////////
/*  이 함수 작동하는 거 확인함 (멤버 삭제 - info에서)
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
*/