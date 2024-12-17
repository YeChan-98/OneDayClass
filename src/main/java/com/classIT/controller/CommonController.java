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
	
	 // ���� �ź� ������ �ڵ鷯
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	
	// �α��������� �ڵ鷯 
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
	        logoutHandler.logout(request, response, null); // authentication�� null�� ����

		    return "redirect:/main"; // �⺻ �����̷�Ʈ URL
		}
		
		@PostMapping("/customLogout")
	    public String handleLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response,
	                               @RequestParam(value = "redirectUrl", required = false) String redirectUrl) {
	        // �α׾ƿ� ó��
	        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
	        logoutHandler.logout(request, response, null); // authentication�� null�� ����

	        // redirectUrl�� ��ȿ�� ��� �ش� URL�� �����̷�Ʈ
	        if (redirectUrl != null && !redirectUrl.isEmpty()) {
	            return "redirect:" + redirectUrl;
	        }

	        // �⺻ �����̷�Ʈ URL
	        return "redirect:/defaultRedirect"; // �⺻ �����̷�Ʈ URL�� �̵�
	    }
		
		@GetMapping("/customLogout2")
	    public String handleLogout2(HttpSession session, HttpServletRequest request, HttpServletResponse response,
	                               @RequestParam(value = "redirectUrl", required = false) String redirectUrl) {
	        // �α׾ƿ� ó��
	        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
	        logoutHandler.logout(request, response, null); // authentication�� null�� ����

	        // redirectUrl�� ��ȿ�� ��� �ش� URL�� �����̷�Ʈ
	        if (redirectUrl != null && !redirectUrl.isEmpty()) {
	            return "redirect:" + redirectUrl;
	        }

	        // �⺻ �����̷�Ʈ URL
	        return "redirect:/defaultRedirect"; // �⺻ �����̷�Ʈ URL�� �̵�
	    }
		
		// ȸ������ �� ������
	    @GetMapping("/signUp")
	    public String signupForm() {
	        return "/signUp";  // signup.jsp (ȸ������ ��)
	    }

	 // ȸ������ ��û ó��
	    @PostMapping("/signUp")
	    public String signup(@RequestParam("user_name") String user_name,
                @RequestParam("user_id") String userId,
                @RequestParam("user_pw") String userPw,
                @RequestParam("user_birth") String userBirth,
                @RequestParam("user_number") String userNumber,
                @RequestParam("user_addr") String userAddr, RedirectAttributes rttr) {
	    	
	        // ��й�ȣ�� ��ȣȭ
	        String encodedPassword = passwordEncoder.encode(userPw);  // ��й�ȣ ���ڵ�
	        
	        MemberVO member = new MemberVO();
	        member.setUsername(user_name);
	        member.setUserid(userId);
	        member.setPwd(encodedPassword);
	        member.setbirth(userBirth);
	        member.setnumber(userNumber);
	        member.setaddr(userAddr);

	        // ȸ������ ó�� (DB�� ����)
	        int result = memberService.insertMember(member);

	        // ����� ���� �޽��� ����
	        if (result > 0) {
	            rttr.addFlashAttribute("message", "ȸ�������� �Ϸ�Ǿ����ϴ�.");
	        } else {
	            rttr.addFlashAttribute("message", "ȸ�����Կ� �����߽��ϴ�.");
	        }

	        // ȸ������ �� �α��� �������� �����̷�Ʈ
	        return "redirect:/index"; 
	    }
		
	    @GetMapping("/main")
	    public String mainPage(Model model, HttpSession session) {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null && authentication.isAuthenticated()) {
	            String userId = authentication.getName(); // ���� �α����� ����� ID
	            MemberVO member = memberService.getMember(userId); // ����� ������ ��ȸ

	            if (member != null) {
	                // MemberVO ��ü�� ���ǿ� ����
	                session.setAttribute("loginUser", member); // ���ǿ� ����
	                model.addAttribute("loginUser", member); // �𵨿��� �߰� (���� ����)
	            }
	        }

	        // redirectUrl�� ���ǿ��� ��������
	        String redirectUrl = (String) session.getAttribute("redirectUrl");
	        if (redirectUrl != null) {
	            session.removeAttribute("redirectUrl"); // ��� �� ���ǿ��� ����
	            return "redirect:" + redirectUrl; // redirectUrl�� �����̷�Ʈ
	        }

	        return "index"; // redirectUrl�� null�� ��� index�� �̵�
	    }

	    @GetMapping("/updateMember")
	    public String showMemberUpdatePage(Model model) {
	        // ���ǿ��� �α����� ����� ������ �����ɴϴ�.
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null && authentication.isAuthenticated()) {
	            String userId = authentication.getName(); // ���� �α����� ����� ID
	            MemberVO member = memberService.getMember(userId); // ����� ������ ��ȸ

	            if (member != null) {
	                // MemberVO ��ü�� �𵨿� �߰�
	                model.addAttribute("loginUser", member); // ��ü MemberVO ��ü �߰�
	            }
	        }
	        return "memberUpdate"; // main.jsp�� �̵�
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
	        
	     // MemberVO ��ü ���� �� �� ����
	        MemberVO member = new MemberVO();
	        member.setUsername(userName);
	        member.setUserid(userId);
	        member.setPwd(encodedPassword);
	        member.setbirth(userBirth); // �޼��� �̸� ����
	        member.setnumber(userNumber); // �޼��� �̸� ����
	        member.setaddr(userAddr); // �޼��� �̸� ����

	        try {
	            // �����ͺ��̽��� ������Ʈ
	            memberService.updateMember(member);
	            
	            // ���� �޽��� �߰�
	            rttr.addFlashAttribute("message", "ȸ�� ������ ���������� ������Ʈ�Ǿ����ϴ�.");
	            return "redirect:/index"; // ���� �� �����̷�Ʈ
	        } catch (Exception e) {
	            // ���� �߻� �� ���� �޽��� �߰�
	            rttr.addFlashAttribute("errorMessage", "ȸ�� ���� ������Ʈ�� �����߽��ϴ�.");
	            return "redirect:/errorPage"; // ���� �� �����̷�Ʈ
	        }
	    }
	    
	    @GetMapping("/mypage1")
	    public String showMyPage(Model model) {
	        // ���ǿ��� �α����� ����� ������ �����ɴϴ�.
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null && authentication.isAuthenticated()) {
	            String userId = authentication.getName(); // ���� �α����� ����� ID
	            MemberVO member = memberService.getMember(userId); // ����� ������ ��ȸ

	            if (member != null) {
	                // MemberVO ��ü�� �𵨿� �߰�
	                model.addAttribute("loginUser", member); // ��ü MemberVO ��ü �߰�
	            }
	        }
	        return "mypage"; // mypage.jsp�� �̵�
	    }
	    
	    @GetMapping("/mypage")
	    public String myPage(Model model, HttpSession session) {
	        // ���ǿ��� �α��� ����� ������ ������
	        MemberVO member = (MemberVO) session.getAttribute("loginUser");
	        
	        // �α����� ����ڰ� ���� ���, �𵨿� �߰�
	        if (member != null) {
	            model.addAttribute("loginUser", member);
	        }
	        
	        // mypage.jsp�� �̵�
	        return "mypage"; // mypage.jsp�� �̵�
	    }
	    
	    @GetMapping(value = "/confirmID", produces = "application/json")
	    @ResponseBody
	    public Map<String, String> confirmID(@RequestParam String id) {
	        boolean isAvailable = memberService.confirmID(id);
	        Map<String, String> response = new HashMap<>();
	        if (isAvailable) {
	            response.put("msg", "��� ������ ���̵��Դϴ�.");
	        } else {
	            response.put("msg", "�̹� ��� ���� ���̵��Դϴ�.");
	        }
	        return response;
	    }
	    
	    @PostMapping("/selectresult")
	    public ModelAndView handleSelectionResult(
	            @RequestParam("selection1") String selection1,
	            @RequestParam("selection2") String selection2,
	            @RequestParam("selection3") String selection3,
	            @RequestParam("selection4") String selection4) {
	        
	        // ���õ� ���� ���� ����� ����
	        String result = selection1 + selection2 + selection3 + selection4; // ��: ESTJ, ESTP ��

	        String redirectUrl;
	        
	        // �� ���տ� ���� �����̷�Ʈ�� URL ����
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
	                redirectUrl = "/index"; // �⺻��
	                break;
	        }

	        // �����̷�Ʈ
	        return new ModelAndView("redirect:" + redirectUrl);
	    }
}
