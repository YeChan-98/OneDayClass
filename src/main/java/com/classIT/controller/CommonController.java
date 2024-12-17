package com.classIT.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classIT.domain.MemberVO;
import com.classIT.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	
	 @Autowired
	    private MemberService memberService;

	    @Autowired
	    private PasswordEncoder passwordEncoder;
	
	 // 접근 거부 페이지 핸들러
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	
	// 로그인페이지 핸들러 
		@GetMapping("/customLogin")
		public void loginInput(String error, String logout, Model model) {
			log.info("error >> " + error);
			log.info("logout : " + logout);
			
			if(error != null) {
				model.addAttribute("error", "Login error check your account");
			}
			
			if(logout != null) {
				model.addAttribute("logout", "Logout!!!!!!!");
			}
			
		}
		
		@GetMapping("/customLogout")
		public String logoutGET(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		    log.info("custom logout");
		    
		    SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
	        logoutHandler.logout(request, response, null); // authentication은 null로 설정

		    return "redirect:/main"; // 기본 리다이렉트 URL
		}
		
		@PostMapping("/customLogout")
	    public String handleLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response,
	                               @RequestParam(value = "redirectUrl", required = false) String redirectUrl) {
	        // 로그아웃 처리
	        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
	        logoutHandler.logout(request, response, null); // authentication은 null로 설정

	        // redirectUrl이 유효한 경우 해당 URL로 리다이렉트
	        if (redirectUrl != null && !redirectUrl.isEmpty()) {
	            return "redirect:" + redirectUrl;
	        }

	        // 기본 리다이렉트 URL
	        return "redirect:/defaultRedirect"; // 기본 리다이렉트 URL로 이동
	    }
		
		@GetMapping("/customLogout2")
	    public String handleLogout2(HttpSession session, HttpServletRequest request, HttpServletResponse response,
	                               @RequestParam(value = "redirectUrl", required = false) String redirectUrl) {
	        // 로그아웃 처리
	        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
	        logoutHandler.logout(request, response, null); // authentication은 null로 설정

	        // redirectUrl이 유효한 경우 해당 URL로 리다이렉트
	        if (redirectUrl != null && !redirectUrl.isEmpty()) {
	            return "redirect:" + redirectUrl;
	        }

	        // 기본 리다이렉트 URL
	        return "redirect:/defaultRedirect"; // 기본 리다이렉트 URL로 이동
	    }
		
		// 회원가입 폼 페이지
	    @GetMapping("/signUp")
	    public String signupForm() {
	        return "/signUp";  // signup.jsp (회원가입 폼)
	    }

	 // 회원가입 요청 처리
	    @PostMapping("/signUp")
	    public String signup(@RequestParam("user_name") String user_name,
                @RequestParam("user_id") String userId,
                @RequestParam("user_pw") String userPw,
                @RequestParam("user_birth") String userBirth,
                @RequestParam("user_number") String userNumber,
                @RequestParam("user_addr") String userAddr, RedirectAttributes rttr) {
	    	
	        // 비밀번호를 암호화
	        String encodedPassword = passwordEncoder.encode(userPw);  // 비밀번호 인코딩
	        
	        MemberVO member = new MemberVO();
	        member.setUsername(user_name);
	        member.setUserid(userId);
	        member.setPwd(encodedPassword);
	        member.setbirth(userBirth);
	        member.setnumber(userNumber);
	        member.setaddr(userAddr);

	        // 회원가입 처리 (DB에 저장)
	        int result = memberService.insertMember(member);

	        // 결과에 따라 메시지 설정
	        if (result > 0) {
	            rttr.addFlashAttribute("message", "회원가입이 완료되었습니다.");
	        } else {
	            rttr.addFlashAttribute("message", "회원가입에 실패했습니다.");
	        }

	        // 회원가입 후 로그인 페이지로 리다이렉트
	        return "redirect:/index"; 
	    }
		
	    @GetMapping("/main")
	    public String mainPage(Model model, HttpSession session) {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null && authentication.isAuthenticated()) {
	            String userId = authentication.getName(); // 현재 로그인한 사용자 ID
	            MemberVO member = memberService.getMember(userId); // 사용자 정보를 조회

	            if (member != null) {
	                // MemberVO 객체를 세션에 저장
	                session.setAttribute("loginUser", member); // 세션에 저장
	                model.addAttribute("loginUser", member); // 모델에도 추가 (선택 사항)
	            }
	        }

	        // redirectUrl을 세션에서 가져오기
	        String redirectUrl = (String) session.getAttribute("redirectUrl");
	        if (redirectUrl != null) {
	            session.removeAttribute("redirectUrl"); // 사용 후 세션에서 제거
	            return "redirect:" + redirectUrl; // redirectUrl로 리다이렉트
	        }

	        return "index"; // redirectUrl이 null일 경우 index로 이동
	    }

	    @GetMapping("/updateMember")
	    public String showMemberUpdatePage(Model model) {
	        // 세션에서 로그인한 사용자 정보를 가져옵니다.
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null && authentication.isAuthenticated()) {
	            String userId = authentication.getName(); // 현재 로그인한 사용자 ID
	            MemberVO member = memberService.getMember(userId); // 사용자 정보를 조회

	            if (member != null) {
	                // MemberVO 객체를 모델에 추가
	                model.addAttribute("loginUser", member); // 전체 MemberVO 객체 추가
	            }
	        }
	        return "memberUpdate"; // main.jsp로 이동
	    }

	    @PostMapping("/updateMember")
	    public String updateMember(
	            @RequestParam("user_name") String userName,
	            @RequestParam("user_id") String userId,
	            @RequestParam("user_pw") String userPw,
	            @RequestParam("user_birth") String userBirth,
	            @RequestParam("user_number") String userNumber,
	            @RequestParam("user_addr") String userAddr,
	            HttpSession session,
	            RedirectAttributes rttr) {

	        String encodedPassword = passwordEncoder.encode(userPw);
	        
	     // MemberVO 객체 생성 및 값 설정
	        MemberVO member = new MemberVO();
	        member.setUsername(userName);
	        member.setUserid(userId);
	        member.setPwd(encodedPassword);
	        member.setbirth(userBirth); // 메서드 이름 수정
	        member.setnumber(userNumber); // 메서드 이름 수정
	        member.setaddr(userAddr); // 메서드 이름 수정

	        try {
	            // 데이터베이스에 업데이트
	            memberService.updateMember(member);
	            
	            // 성공 메시지 추가
	            rttr.addFlashAttribute("message", "회원 정보가 성공적으로 업데이트되었습니다.");
	            return "redirect:/index"; // 성공 시 리다이렉트
	        } catch (Exception e) {
	            // 예외 발생 시 에러 메시지 추가
	            rttr.addFlashAttribute("errorMessage", "회원 정보 업데이트에 실패했습니다.");
	            return "redirect:/errorPage"; // 실패 시 리다이렉트
	        }
	    }
	    
	    @GetMapping("/mypage1")
	    public String showMyPage(Model model) {
	        // 세션에서 로그인한 사용자 정보를 가져옵니다.
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null && authentication.isAuthenticated()) {
	            String userId = authentication.getName(); // 현재 로그인한 사용자 ID
	            MemberVO member = memberService.getMember(userId); // 사용자 정보를 조회

	            if (member != null) {
	                // MemberVO 객체를 모델에 추가
	                model.addAttribute("loginUser", member); // 전체 MemberVO 객체 추가
	            }
	        }
	        return "mypage"; // mypage.jsp로 이동
	    }
	    
	    @GetMapping("/mypage")
	    public String myPage(Model model, HttpSession session) {
	        // 세션에서 로그인 사용자 정보를 가져옴
	        MemberVO member = (MemberVO) session.getAttribute("loginUser");
	        
	        // 로그인한 사용자가 있을 경우, 모델에 추가
	        if (member != null) {
	            model.addAttribute("loginUser", member);
	        }
	        
	        // mypage.jsp로 이동
	        return "mypage"; // mypage.jsp로 이동
	    }
	    
	    @GetMapping(value = "/confirmID", produces = "application/json")
	    @ResponseBody
	    public Map<String, String> confirmID(@RequestParam String id) {
	        boolean isAvailable = memberService.confirmID(id);
	        Map<String, String> response = new HashMap<>();
	        if (isAvailable) {
	            response.put("msg", "사용 가능한 아이디입니다.");
	        } else {
	            response.put("msg", "이미 사용 중인 아이디입니다.");
	        }
	        return response;
	    }
	    
	    @PostMapping("/selectresult")
	    public ModelAndView handleSelectionResult(
	            @RequestParam("selection1") String selection1,
	            @RequestParam("selection2") String selection2,
	            @RequestParam("selection3") String selection3,
	            @RequestParam("selection4") String selection4) {
	        
	        // 선택된 값에 따라 결과를 결정
	        String result = selection1 + selection2 + selection3 + selection4; // 예: ESTJ, ESTP 등

	        String redirectUrl;
	        
	        // 각 조합에 따라 리다이렉트할 URL 설정
	        switch (result) {
	            case "ESTJ":
	                redirectUrl = "/product/sub?product_no=1";
	                break;
	            case "ESTP":
	                redirectUrl = "/product/sub?product_no=2";
	                break;
	            case "ESFJ":
	                redirectUrl = "/product/sub?product_no=3";
	                break;
	            case "ESFP":
	                redirectUrl = "/product/sub?product_no=4";
	                break;
	            case "INTJ":
	                redirectUrl = "/product/sub?product_no=5";
	                break;
	            case "INTP":
	                redirectUrl = "/product/sub?product_no=6";
	                break;
	            case "INFJ":
	                redirectUrl = "/product/sub?product_no=7";
	                break;
	            case "INFP":
	                redirectUrl = "/product/sub?product_no=8";
	                break;
	            case "ENTJ":
	                redirectUrl = "/product/sub?product_no=9";
	                break;
	            case "ENTP":
	                redirectUrl = "/product/sub?product_no=10";
	                break;
	            case "ENFJ":
	                redirectUrl = "/product/sub?product_no=11";
	                break;
	            case "ENFP":
	                redirectUrl = "/product/sub?product_no=12";
	                break;
	            case "ISTJ":
	                redirectUrl = "/product/sub?product_no=13";
	                break;
	            case "ISTP":
	                redirectUrl = "/product/sub?product_no=14";
	                break;
	            case "ISFJ":
	                redirectUrl = "/product/sub?product_no=15";
	                break;
	            case "ISFP":
	                redirectUrl = "/product/sub?product_no=16";
	                break;
	            default:
	                redirectUrl = "/index"; // 기본값
	                break;
	        }

	        // 리다이렉트
	        return new ModelAndView("redirect:" + redirectUrl);
	    }
}
