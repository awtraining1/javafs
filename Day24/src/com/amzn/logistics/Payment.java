package com.amzn.logistics;

import com.amzn.people.Farmer;

@FunctionalInterface
public interface Payment {

	public void pay(Farmer f, float amt);
}
