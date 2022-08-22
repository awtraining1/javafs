package com.ni.farm.respositries;

import com.ni.farm.Farmer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepositry_V2 extends JpaRepository<Farmer, Integer>{   
    
}
