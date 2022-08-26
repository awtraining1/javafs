package com.ni.config;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@PropertySource("classpath:company.properties")
@ConfigurationProperties(prefix="company.employee")
@Component
public class CompanyProps {
    @Min(1)
    int count;

    String city;
    String specialization;

    boolean wfh;

    List<String> holidays;

    public List<String> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<String> holidays) {
        this.holidays = holidays;
    }

    public int getCount() {
        return count;
    }   

    public String getCity() {
        return city;
    }   

    public String getSpecialization() {
        return specialization;
    }

    public boolean isWfh() {
        return wfh;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setWfh(boolean wfh) {
        this.wfh = wfh;
    }

    
    

}
