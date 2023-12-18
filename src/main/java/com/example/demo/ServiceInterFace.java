package com.example.demo;

import java.util.ArrayList;

public interface ServiceInterFace {

	CompanyDemo saveData(CompanyDemo companyDemo);

	CompanyDemo getdataById(int id);

	ArrayList<CompanyDemo> getallData();

	CompanyDemo updateData(int id, CompanyDemo companyDemo);

	String deleteById(int id);
	
	

}
