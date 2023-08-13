package com.batch8grp1.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.batch8grp1.obs.dto.LoginDto;
import com.batch8grp1.obs.dto.NetbankingDto;
import com.batch8grp1.obs.entity.Netbanking;
import com.batch8grp1.obs.payload.response.LoginMessage;
import com.batch8grp1.obs.repository.NetbankingRepository;

@Service
public class NetbankingServiceImpl implements NetbankingService {

	@Autowired private NetbankingRepository netbankingRepository;
	
	@Autowired PasswordEncoder passwordEncoder;
	
	@Override
	public String Signup(NetbankingDto netbankingDto) {
		Netbanking netbanking=new Netbanking(netbankingDto.getNetbankingId(),
				netbankingDto.getAccountId(),netbankingDto.getPassword(),netbankingDto.getTxnPassword(),netbankingDto.getOtp());
		netbankingRepository.save(netbanking);
		//netbankingRepository.save(netbanking);
		return netbanking.getNetbankingId();
	}

	NetbankingDto netbankingDto;
	@Override
	public LoginMessage loginNetbanking(LoginDto loginDto) {
		Netbanking netbanking1 = netbankingRepository.findByNetbankingId(loginDto.getNetbankingId());
		if(netbanking1 != null)
		{
			String password = loginDto.getPassword();
			String encodedPassword = netbanking1.getPassword();
			Boolean isPwdRight=passwordEncoder.matches(password, encodedPassword);
			
			if(isPwdRight) {
				Netbanking netbanking2=netbankingRepository.findByNetbankingIdAndPassword(loginDto.getNetbankingId(), encodedPassword);
				if(netbanking2 != null) {
					return new LoginMessage("Login Success", true);
				}else {
					return new LoginMessage("Login Failed", false);
				}
			}else {
				return new LoginMessage("User's Netbanking doesn't exists", false);
			}
		}
		return new LoginMessage("User Doesnot Exist",false);
	}
	
	
	

}
