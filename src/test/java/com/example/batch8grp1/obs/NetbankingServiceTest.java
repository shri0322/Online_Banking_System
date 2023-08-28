package com.example.batch8grp1.obs;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.batch8grp1.obs.dto.LoginDto;
import com.batch8grp1.obs.dto.NetbankingDto;
import com.batch8grp1.obs.entity.Netbanking;
import com.batch8grp1.obs.entity.UserDetails;
import com.batch8grp1.obs.payload.response.LoginMessage;
import com.batch8grp1.obs.payload.response.RegisterResponse;
import com.batch8grp1.obs.repository.NetbankingRepository;
import com.batch8grp1.obs.repository.UserDetailsRepository;
import com.batch8grp1.obs.service.NetbankingServiceImpl;

public class NetbankingServiceTest {

    @Mock
    private NetbankingRepository netbankingRepository;

    @Mock
    private UserDetailsRepository userDetailsRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private NetbankingServiceImpl netbankingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister_Success() {
        NetbankingDto netbankingDto = new NetbankingDto("account123","password","txnPassword","otp");
        //netbankingDto.setAccountId("account123");
        //netbankingDto.setPassword("password");
        //netbankingDto.setTxnPassword("txnPassword");
        //netbankingDto.setOtp("otp");

        Netbanking netbanking = new Netbanking("","account123","","","");
        //netbanking.setAccountId("account123");

        when(netbankingRepository.findByAccountId("account123")).thenReturn(netbanking);
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
        when(passwordEncoder.encode("txnPassword")).thenReturn("encodedTxnPassword");

        RegisterResponse response = netbankingService.register(netbankingDto);

        assertNotNull(response);
        assertEquals("Netbanking Registration Successful!", response.getMessage());
    }

  @Test
    public void testLoginNetbanking_Success() {
        LoginDto loginDto = new LoginDto();
        loginDto.setNetbankingId("netbanking123");
        loginDto.setPassword("password");
        Netbanking netbanking = new Netbanking("netbanking123","","","","");
        //netbanking.setNetbankingId("netbanking123");
        netbanking.setPassword("encodedPassword");

        UserDetails userDetails = new UserDetails("","Mr.","John","Doe","","","","","","","","","", null, false);
//        userDetails.setTitle("Mr.");
//        userDetails.setFirstName("John");
//        userDetails.setLastname("Doe");

       when(netbankingRepository.findByNetbankingId("netbanking123")).thenReturn(netbanking);
       when(passwordEncoder.matches("password", "encodedPassword")).thenReturn(true);
       when(userDetailsRepository.findByAccountId(anyString())).thenReturn(userDetails);

        LoginMessage response = netbankingService.loginNetbanking(loginDto);

        assertNotNull(response);
        assertEquals("Login Successful", response.getMessage());
    }

    @Test
    public void testLoginNetbanking_WrongPassword() {
        LoginDto loginDto = new LoginDto();
        loginDto.setNetbankingId("netbanking123");
        loginDto.setPassword("wrongPassword");

        Netbanking netbanking = new Netbanking("netbanking123","","","","");
        //netbanking.setNetbankingId("netbanking123");
        netbanking.setPassword("encodedPassword");

        when(netbankingRepository.findByNetbankingId("netbanking123")).thenReturn(netbanking);
        when(passwordEncoder.matches("wrongPassword", "encodedPassword")).thenReturn(false);

        LoginMessage response = netbankingService.loginNetbanking(loginDto);
        assertNotNull(response);
        assertEquals("Login Failed", response.getMessage());
    }
//
    // Add more test cases for edge cases and failure scenarios
}
