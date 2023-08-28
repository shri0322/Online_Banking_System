package com.example.batch8grp1.obs;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.batch8grp1.obs.entity.AccountDetails;
import com.batch8grp1.obs.entity.Netbanking;
import com.batch8grp1.obs.entity.UserDetails;
import com.batch8grp1.obs.exceptions.CustomException;
import com.batch8grp1.obs.payload.response.AccountDetailsResponse;
import com.batch8grp1.obs.repository.AccountDetailsRepository;
import com.batch8grp1.obs.repository.NetbankingRepository;
import com.batch8grp1.obs.repository.UserDetailsRepository;
import com.batch8grp1.obs.service.AccountDetailsServiceImpl;

public class AccountDetailsServiceTest {

    @Mock
    private AccountDetailsRepository accountDetailsRepository;

    @Mock
    private UserDetailsRepository userDetailsRepository;

    @Mock
    private NetbankingRepository netbankingRepository;

    @InjectMocks
    private AccountDetailsServiceImpl accountDetailsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAccountDetails_Success() {
        String netbankingId = "netbanking123";
        String accountId = "account123";

        Netbanking netbanking = new Netbanking(netbankingId,accountId,null,null,null);
        //netbanking.setAccountId(accountId);

        AccountDetails account = new AccountDetails(accountId,0,"2023-08-25",null);
//        account.setAccountId(accountId);
//        account.setCreatedAt("2023-08-25");
        account.setBalance(1000);

        UserDetails user = new UserDetails("account123","Mr.","John","Doe", accountId, accountId, accountId, accountId, accountId, accountId, accountId, accountId, accountId, accountId, false );
//        user.setTitle("Mr.");
//        user.setFirstName("John");
//        user.setLastname("Doe");

        when(netbankingRepository.findByNetbankingId(netbankingId)).thenReturn(netbanking);
        when(accountDetailsRepository.findByAccountId(accountId)).thenReturn(account);
        when(userDetailsRepository.findByAccountId(accountId)).thenReturn(user);

        AccountDetailsResponse response = accountDetailsService.getAccountDetails(netbankingId);

        assertNotNull(response);
        assertEquals(accountId, response.getAccountId());
        assertEquals("Mr. John Doe", response.getFullName());
        assertEquals("2023-08-25", response.getCreatedAt());
        assertEquals(1000, response.getBalance());
    }

    @Test
    public void testGetAccountDetails_Failure() {
        String netbankingId = "netbanking123";

        when(netbankingRepository.findByNetbankingId(netbankingId)).thenReturn(null);

        assertThrows(CustomException.class, () -> accountDetailsService.getAccountDetails(netbankingId));
    }

    // Add more test cases for other scenarios

}
