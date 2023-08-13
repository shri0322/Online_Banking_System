package com.batch8grp1.obs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.batch8grp1.obs.entity.Netbanking;

@EnableJpaRepositories
@Repository
public interface NetbankingRepository extends JpaRepository <Netbanking, String> {
	
	List<Netbanking> findAll();
	
	Netbanking findByNetbankingId(String netbankingId);
	Netbanking findByNetbankingIdAndPassword(String netbankingId, String Password);
}
