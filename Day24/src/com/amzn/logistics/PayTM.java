package com.amzn.logistics;

import com.amzn.people.Farmer;

public class PayTM implements Payment{

	@Override
	public void pay(Farmer f, float amt) {
		System.out.println(" Paying thru paytm..");		
	}

}
