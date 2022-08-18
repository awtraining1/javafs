package com.ni.farm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
public class Farmer {

     String name;
     int age;
     float yearsOfExperience;   
     
     public Farmer(){
         
     }

     public void incrementYearsOfExperience(int increaseBy){
         this.yearsOfExperience=this.yearsOfExperience + increaseBy;
     };
}
