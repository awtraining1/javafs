package com.ni.farm.respositries;

import com.ni.farm.Farmer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepositry_V2 extends JpaRepository<Farmer, Integer> {
    public int deleteByName(String name);

    @Modifying
    @Query(value = "DELETE FROM FARMER f where f.age=:age", nativeQuery = true)
    public int deleteByAge(int age);

    @Modifying
    @Query(value = "DELETE FROM Farmer f where f.age=:age and f.name=:name", nativeQuery = true)
    public int deleteByAgeAndName(int age, String name);
}
