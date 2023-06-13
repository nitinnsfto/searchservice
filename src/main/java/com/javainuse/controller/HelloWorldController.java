package com.javainuse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.javainuse.MyState;

@RestController
@CrossOrigin
public class HelloWorldController {
	
	private static double MAX_RT_REC = 1000;
	private static final long MIN_CONFIDENCE = 1;

	HashMap<String, Long> klidMap = new HashMap();
	HashMap<String, Long> queryUserMap = new HashMap();
	
	String data = " [\r\n" + 
			"  {\r\n" + 
			"    \"id\": 0,\r\n" + 
			"    \"name\": \"Acme Fresh Start Housing\",\r\n" + 
			"    \"city\": \"Chicago\",\r\n" + 
			"    \"state\": \"IL\",\r\n" + 
			"    \"photo\": \"/assets/bernard-hermant-CLKGGwIBTaY-unsplash.jpg\",\r\n" + 
			"    \"availableUnits\": 4,\r\n" + 
			"    \"wifi\": true,\r\n" + 
			"    \"laundry\": true,\r\n" + 
			"    \"firstname\": \"smith\",\r\n" + 
			"    \"lastname\": \"John\",\r\n" + 
			"    \"ssnnum\": \"987654323\",\r\n" + 
			"    \"dob\": \"11/24/2002\",\r\n" + 
			"    \"klid\": \"46db2be4-04a7-11ee-be56-0242ac120002\"\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": 1,\r\n" + 
			"    \"name\": \"A113 Transitional Housing\",\r\n" + 
			"    \"city\": \"Santa Monica\",\r\n" + 
			"    \"state\": \"CA\",\r\n" + 
			"    \"photo\": \"/assets/brandon-griggs-wR11KBaB86U-unsplash.jpg\",\r\n" + 
			"    \"availableUnits\": 0,\r\n" + 
			"    \"wifi\": false,\r\n" + 
			"    \"laundry\": true,\r\n" + 
			"    \"firstname\": \"smith\",\r\n" + 
			"    \"lastname\": \"John\",\r\n" + 
			"    \"ssnnum\": \"987654323\",\r\n" + 
			"    \"dob\": \"11/24/2002\",\r\n" + 
			"    \"klid\": \"46db2be4-04a7-11ee-be56-0242ac120002\"\r\n" + 			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": 2,\r\n" + 
			"    \"name\": \"Warm Beds Housing Support\",\r\n" + 
			"    \"city\": \"Juneau\",\r\n" + 
			"    \"state\": \"AK\",\r\n" + 
			"    \"photo\": \"/assets/i-do-nothing-but-love-lAyXdl1-Wmc-unsplash.jpg\",\r\n" + 
			"    \"availableUnits\": 1,\r\n" + 
			"    \"wifi\": false,\r\n" + 
			"    \"laundry\": false\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": 3,\r\n" + 
			"    \"name\": \"Homesteady Housing\",\r\n" + 
			"    \"city\": \"Chicago\",\r\n" + 
			"    \"state\": \"IL\",\r\n" + 
			"    \"photo\": \"/assets/ian-macdonald-W8z6aiwfi1E-unsplash.jpg\",\r\n" + 
			"    \"availableUnits\": 1,\r\n" + 
			"    \"wifi\": true,\r\n" + 
			"    \"laundry\": false\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": 4,\r\n" + 
			"    \"name\": \"Happy Homes Group\",\r\n" + 
			"    \"city\": \"Gary\",\r\n" + 
			"    \"state\": \"IN\",\r\n" + 
			"    \"photo\": \"/assets/krzysztof-hepner-978RAXoXnH4-unsplash.jpg\",\r\n" + 
			"    \"availableUnits\": 1,\r\n" + 
			"    \"wifi\": true,\r\n" + 
			"    \"laundry\": false\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": 5,\r\n" + 
			"    \"name\": \"Hopeful Apartment Group\",\r\n" + 
			"    \"city\": \"Oakland\",\r\n" + 
			"    \"state\": \"CA\",\r\n" + 
			"    \"photo\": \"/assets/r-architecture-JvQ0Q5IkeMM-unsplash.jpg\",\r\n" + 
			"    \"availableUnits\": 2,\r\n" + 
			"    \"wifi\": true,\r\n" + 
			"    \"laundry\": true\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": 6,\r\n" + 
			"    \"name\": \"Seriously Safe Towns\",\r\n" + 
			"    \"city\": \"Oakland\",\r\n" + 
			"    \"state\": \"CA\",\r\n" + 
			"    \"photo\": \"/assets/phil-hearing-IYfp2Ixe9nM-unsplash.jpg\",\r\n" + 
			"    \"availableUnits\": 5,\r\n" + 
			"    \"wifi\": true,\r\n" + 
			"    \"laundry\": true\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": 7,\r\n" + 
			"    \"name\": \"Hopeful Housing Solutions\",\r\n" + 
			"    \"city\": \"Oakland\",\r\n" + 
			"    \"state\": \"CA\",\r\n" + 
			"    \"photo\": \"/assets/r-architecture-GGupkreKwxA-unsplash.jpg\",\r\n" + 
			"    \"availableUnits\": 2,\r\n" + 
			"    \"wifi\": true,\r\n" + 
			"    \"laundry\": true\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": 8,\r\n" + 
			"    \"name\": \"Seriously Safe Towns\",\r\n" + 
			"    \"city\": \"Oakland\",\r\n" + 
			"    \"state\": \"CA\",\r\n" + 
			"    \"photo\": \"/assets/saru-robert-9rP3mxf8qWI-unsplash.jpg\",\r\n" + 
			"    \"availableUnits\": 10,\r\n" + 
			"    \"wifi\": false,\r\n" + 
			"    \"laundry\": false\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": 9,\r\n" + 
			"    \"name\": \"Capital Safe Towns\",\r\n" + 
			"    \"city\": \"Portland\",\r\n" + 
			"    \"state\": \"OR\",\r\n" + 
			"    \"photo\": \"/assets/webaliser-_TPTXZd9mOo-unsplash.jpg\",\r\n" + 
			"    \"availableUnits\": 6,\r\n" + 
			"    \"wifi\": true,\r\n" + 
			"    \"laundry\": true\r\n" + 
			"  }\r\n" + 
			"]";
	
	private MyState maxKlid = new MyState();
	
	@GetMapping(value = "/users/{id}")
	public User getUser(@PathVariable("id") String id) {
		User[] users;
		try {
			users = new ObjectMapper().readValue(data, User[].class);
			for (User u : users) {
				System.out.println(u);
				if (u.getId().equals(new Integer(id))) {
					return u;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping({ "/hello" })
	public String firstPage() {		
		return data;
	}
	
	@RequestMapping({ "/uci" })
	public List<Map<String, String>> uciSearch(
			@RequestParam(name="firstname", required=false) String firstname,
			@RequestParam(name="lastname", required=false) String lastname,
			@RequestParam(name="ssn", required=false) String ssn,
			@RequestParam(name="state", required=false) String state,
			@RequestParam(name="city", required=false) String city,
			@RequestParam(name="dob", required=false) String dob,
			@RequestParam(name="username", required=false) String username,
			@RequestParam(name="password", required=false) String password) {	
		User[] users;
		//System.out.println(firstname + "-" + lastname + "-" + ssn + "-" + state + "-" + city + "-" + dob + "-" + username+ "-" + password);
		try {
			users = new ObjectMapper().readValue(data, User[].class);

			List<Map<String, String>> matches= new ArrayList<Map<String, String>>();
			
			Map<String, String> fields= new TreeMap<String, String>();
			
			if (firstname != null && firstname.length() > 0)
				fields.put("FIRSTNAME", firstname);
			if (lastname != null && lastname.length() > 0)
				fields.put("LASTNAME", lastname);
			if (ssn != null && ssn.length() > 0)
				fields.put("SSN/TIN", ssn);
			if (state != null && state.length() > 0)
				fields.put("STATE", state);
			if (city != null && city.length() > 0)
				fields.put("CITY", city);
			if (dob != null && dob.length() > 0)
				fields.put("DOB", dob);
			// KLID/QID
			if (klidMap.get(fields.toString())==null)
				klidMap.put(fields.toString(), maxKlid.getAndIncr());
			
			//System.out.println(fields.toString());
			
			Long klid = klidMap.get(fields.toString()); // If klid is found then return the mapped users to that klid
			
			int count = 0;
			
			for (User u : users) {
				
				if (count > MAX_RT_REC)
					break;
				
				double confidence = 0.0;
				//System.out.println(u);
				Map<String, String> fieldMatches= new HashMap<String, String>();
				//confidence=matchField();
				if (u.getFirstname() != null && firstname != null && u.getFirstname().toUpperCase().contains(firstname.toUpperCase())) {
					confidence++;
					fieldMatches.put("FIRSTNAME", firstname);
				} 
				
				if (u.getLastname() != null && lastname != null && u.getLastname().toUpperCase().contains(lastname.toUpperCase())) {
					confidence++;
					fieldMatches.put("LASTNAME", lastname);
				} 
				
				if (u.getSsnnum() != null && ssn != null && u.getSsnnum().toUpperCase().contains(ssn.toUpperCase())) {
					confidence++;
					fieldMatches.put("SSN/TIN", ssn);
				} 
				if (u.getState() != null && state != null && u.getState().toUpperCase().contains(state.toUpperCase())) {
					confidence++;
					fieldMatches.put("STATE", state);
				} 
				if (u.getCity() != null && city != null && u.getCity().toUpperCase().contains(city.toUpperCase())) {
					confidence++;
					fieldMatches.put("CITY", city);
				} 
				if (u.getDob() != null && dob != null && u.getDob().toUpperCase().contains(dob.toUpperCase())) {
					confidence++;
					fieldMatches.put("DOB", dob);
				}
				
				
				if (confidence > 0)
				{

					u.setKlid(klid.toString());
					
					Map<String, String> retVal = new HashMap<String, String>();
					retVal.put("id", u.getId().toString());
					retVal.put("name", u.getName());
					retVal.put("city", u.getCity());
					retVal.put("state", u.getState());
					retVal.put("dob", u.getDob());
					retVal.put("firstname", u.getFirstname());
					retVal.put("lastname", u.getLastname());
					retVal.put("policynum", u.getPolicynum());
					retVal.put("ssnnum", u.getSsnnum());	
					retVal.put("klids", u.getKlid());
					retVal.put("policynum", u.getPolicynum());
					retVal.put("confidence", new Float(((int)(100*(confidence/fields.size())))/100.0).toString());
					retVal.put("kliddetails", fieldMatches.toString());	
					
					Map<String, String> uciMap = new TreeMap<String, String>();
					uciMap.put("FIRSTNAME", u.getFirstname());
					uciMap.put("LASTNAME", u.getLastname());
					uciMap.put("SSN/TIN", u.getSsnnum());
					uciMap.put("STATE", u.getState());
					uciMap.put("CITY", u.getCity());
					uciMap.put("DOB", u.getDob());
	
					retVal.put("uci", uciMap.toString());
										
					matches.add(retVal);
				}
				count++;
			}
			
			Collections.sort(matches,new ConfidenceCompare());
			
			return matches;
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return null;
	}

	
	class ConfidenceCompare implements Comparator<Map<String, String>> {

		@Override
		public int compare(Map<String, String> a, Map<String, String> b) {
			
			double da = new Double(a.get("confidence"));
			double db = new Double(b.get("confidence"));
			
			if (da > db)
				return -1;
			else if (a==b)
				return 0;
			else 
				return 1;
		}
		
	}
}