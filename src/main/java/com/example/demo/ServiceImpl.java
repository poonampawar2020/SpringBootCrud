package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements ServiceInterFace {

	
	@Autowired
	RepositoryDemo repositoryDemo;
	
	@Override
	public CompanyDemo saveData(CompanyDemo companyDemo) {

             try
             {
            	 CompanyDemo demo=this.repositoryDemo.save(companyDemo);
            	 return demo;
             }
             catch (Exception e) {
				// TODO: handle exception
            	 e.printStackTrace();
			}
			return companyDemo;
	}

	@Override
	public CompanyDemo getdataById(int id) {
		// TODO Auto-generated method stub

       try
       {
    	   CompanyDemo demo=this.repositoryDemo.findById(id).orElseThrow();
    	   return demo;
       }
       catch (Exception e) {
		// TODO: handle exception
    	   e.printStackTrace();
	}
	return null;
	}

	@Override
	public ArrayList<CompanyDemo> getallData() {

       try
       {
    	   ArrayList<CompanyDemo> list=(ArrayList<CompanyDemo>) this.repositoryDemo.findAll();
    	return list;   
       }
       catch (Exception e) {
		// TODO: handle exception
    	   e.printStackTrace();
	}
	return null;
	}

	@Override
	public CompanyDemo updateData(int id, CompanyDemo companyDemo) {
		// TODO Auto-generated method stub
		try
		{
			CompanyDemo demo=this.repositoryDemo.findById(id).orElseThrow();
			demo.setId(companyDemo.getId());
			demo.setName(companyDemo.getName());
			demo.setAddress(companyDemo.getAddress());
			CompanyDemo d=this.repositoryDemo.save(demo);
			return d;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return companyDemo;
	}

	@Override
	public String deleteById(int id) {

       try
       {
    	   CompanyDemo demo=this.repositoryDemo.findById(id).orElseThrow();
    	   repositoryDemo.delete(demo);
    	   return "Deleted";
       }
       catch (Exception e) {
		// TODO: handle exception
    	   e.printStackTrace();
	}
	return null;
	}
	
	

}
