package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cruddemo")
public class ControllerDemo {
	
	@Autowired
	ServiceInterFace face;
	
	@PostMapping("/save")
	public ResponseEntity<CompanyDemo> saveData(@RequestBody CompanyDemo companyDemo)
	{
		try
		{
			CompanyDemo com=this.face.saveData(companyDemo);
			return ResponseEntity.ok().body(com);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<CompanyDemo> getbyIdCompanyDeta(@PathVariable(value = "id") int id)
	{
		try
		{
			CompanyDemo companyDemo=this.face.getdataById(id);
			return ResponseEntity.ok().body(companyDemo);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/getAllData")
	public ResponseEntity<ArrayList<CompanyDemo>> getAllData()
	{
		try
		{
			ArrayList<CompanyDemo> list=this.face.getallData();
			return ResponseEntity.ok().body(list);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<CompanyDemo> updateData(@PathVariable(value = "id") int id,@RequestBody CompanyDemo companyDemo) {
		try
		{
			CompanyDemo demo=this.face.updateData(id,companyDemo);
			return ResponseEntity.ok().body(demo);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteinfoById(@PathVariable(value = "id") int id)
	{
		try
		{
			String responce=this.face.deleteById(id);
			return ResponseEntity.ok().body(responce);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
