package com.batch8grp1.obs.service;

import com.batch8grp1.obs.payload.response.AccountDetailsResponse;

public interface AccountDetailsService {
	
	AccountDetailsResponse getAccountDetails(String netbankingId);

}
