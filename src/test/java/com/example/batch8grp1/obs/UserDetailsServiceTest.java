package com.example.batch8grp1.obs;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.batch8grp1.obs.dto.SetLoginPasswordDto;
import com.batch8grp1.obs.dto.UserDetailsDto;
import com.batch8grp1.obs.entity.AccountDetails;
import com.batch8grp1.obs.entity.Netbanking;
import com.batch8grp1.obs.entity.UserDetails;
import com.batch8grp1.obs.exceptions.CustomException;
import com.batch8grp1.obs.payload.response.CreateAccountResponse;
import com.batch8grp1.obs.repository.AccountDetailsRepository;
import com.batch8grp1.obs.repository.NetbankingRepository;
import com.batch8grp1.obs.repository.UserDetailsRepository;
import com.batch8grp1.obs.service.UserDetailsServiceImpl;

public class UserDetailsServiceTest {

    @Mock
    private UserDetailsRepository userDetailsRepository;

    @Mock
    private NetbankingRepository netbankingRepository;

    @Mock
    private AccountDetailsRepository accountDetailsRepository;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAccount_Success() {
        UserDetailsDto userDetailsDto = new UserDetailsDto("Mr.", "John", null, null, null, null, null, null, null, null, null, null);
        //userDetailsDto.setAccountId("account123");

        UserDetails newUser = new UserDetails("account123", "Mr.", "John", null, null, null, null, null, null, null, null, null, null, null, false);
        //newUser.setAccountId("account123");

        Netbanking newNetUser = new Netbanking();

        AccountDetails newAccount = new AccountDetails();

        when(userDetailsRepository.save(any())).thenReturn(newUser);
        when(netbankingRepository.save(any())).thenReturn(newNetUser);
        when(accountDetailsRepository.save(any())).thenReturn(newAccount);

        CreateAccountResponse response = userDetailsServiceImpl.createAccount(userDetailsDto);

        assertNotNull(response);
        assertEquals("Mr. John null", response.getFullName());
    }
 

	@Test
	public void testForgotUserId_ValidInput() {
        Netbanking user = new Netbanking("account123", null, null, null, null);
       // user.setAccountId("account123");
        user.setOtp("1234");

        when(netbankingRepository.findByAccountId("account123")).thenReturn(user);

        String response = userDetailsServiceImpl.forgotUserId("account123", "1234");

        assertEquals("User Verified.", response);
    }

    @Test
    public void testForgotUserId_WrongOtp() {
        Netbanking user = new Netbanking("account123", null, null, null, null);
        //user.setAccountId("account123");
        user.setOtp("1234");
        

        //UserDetails user = new UserDetails("account123", null,null, null, null, null, null, null, null, null, null, null, null, null, false);
        //newUser.setAccountId("account123");

        when(netbankingRepository.findByAccountId("account123")).thenReturn(user);

        String response = userDetailsServiceImpl.forgotUserId("account123", "5678");

        assertEquals("",response);
    }
//
    @Test
    public void testForgotUserId_UserNotFound() {
        when(netbankingRepository.findByAccountId("account123")).thenReturn(null);

        //assertThrows(CustomException.class, () -> userDetailsServiceImpl.forgotUserId("account123", "1234"));
    }

    // Add more test cases for other methods

}

