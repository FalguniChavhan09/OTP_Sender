package OTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import OTP.Services.OTPService;
import OTP.Services.UserService;



@Controller
public class UserController {
	String otp1;
	
    @Autowired
    private UserService userService;

    @Autowired
    private OTPService otpService;

    @GetMapping("/login")
    public String getLogin(Model model) {
        return "login";
    }
    
    @GetMapping("/loginsts")
	public String getOtp(@RequestParam ("username") String Username,Model model) {
		String demo="+91"+Username;
		String otp=userService.generateOtp(Username);
		otp1=otp;
		otpService.sendOTP(demo,otp);
	    System.out.println(otp);
	    model.addAttribute("otp",otp);
		return "success";
	}
    
    @GetMapping("/verification")
    public String authetication(@RequestParam ("Otp") String OTP) {
    	if(OTP.equals(otp1)) {
    		return "Verify";
    	}
    	else {
    		return "error";
    	}
    }
}
