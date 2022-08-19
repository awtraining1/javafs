package com.ni.farm;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data
public class Farmer {

     @NotNull (message = "Farmer name cannot be empty")
     @Size(min=8,max = 12, message = "Farmer name should be atleast 8 chars and atmost 12 chars")
     String name;

     
     @Min(1)
     @Max(value=99, message="Max age cannot be more than 99")
     int age;

     @NotBlank
     @Pattern(regexp = "^(.+)@(\\S+)$")
     String email;

         
     float yearsOfExperience;   
    
     
     public Farmer() {
    }

    public Farmer(String name, int age, String email, float yearsOfExperience) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void incrementYearsOfExperience(int increaseBy){
         this.yearsOfExperience=this.yearsOfExperience + increaseBy;
     };


}
