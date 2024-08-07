package OTP.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import OTP.com.configuration.Twilio_Configuration;

@Service
public class OTPService {

	@Autowired
	Twilio_Configuration twilioConfig;

	public void sendOTP(String mobileNo,String otp) {
		try {
		Message.creator(
				new PhoneNumber(mobileNo),
				new PhoneNumber(twilioConfig.getContactNo()),
				"Your otp is" +otp
				).create();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
