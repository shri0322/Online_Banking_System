package com.batch8grp1.obs.service;

import com.batch8grp1.obs.dto.NetbankingDto;
import com.batch8grp1.obs.dto.LoginDto;
import com.batch8grp1.obs.payload.response.LoginMessage;

public interface NetbankingService {
	
	String Signup(NetbankingDto netbankingDto);
	LoginMessage loginNetbanking(LoginDto loginDto);

}
