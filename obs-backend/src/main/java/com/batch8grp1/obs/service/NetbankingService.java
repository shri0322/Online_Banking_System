package com.batch8grp1.obs.service;

import com.batch8grp1.obs.dto.NetbankingDto;
import com.batch8grp1.obs.dto.LoginDto;
import com.batch8grp1.obs.payload.response.LoginMessage;
import com.batch8grp1.obs.payload.response.RegisterResponse;

public interface NetbankingService {
	
	LoginMessage loginNetbanking(LoginDto loginDto);
	RegisterResponse register(NetbankingDto netbankingDto);

}
