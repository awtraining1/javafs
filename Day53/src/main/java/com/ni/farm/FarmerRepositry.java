package com.ni.farm;

import java.util.ArrayList;
import java.util.List;

public class FarmerRepositry {
    public static List<Farmer> farmerList = new ArrayList<>();
    
    static {
    farmerList.add(new Farmer("name1234",23,"asasa@asas.com",20 ));
    farmerList.add(new Farmer("name2222",23,"22222@asas.com",20 ));
    }
    
    
}
