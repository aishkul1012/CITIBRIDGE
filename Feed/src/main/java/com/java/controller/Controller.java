package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.*;
import com.java.model.Database;
import com.mongodb.DBCursor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {

	private ArrayList<Object> feedfile = createList();

	@RequestMapping(value = "/feeds", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<Object> firstPage() {
		return feedfile;
	}
	
	
	/*@RequestMapping(value = "/Failedfeeds", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<Object> firstPage() {
		return Passedfeeds;
	}*/
	
	
	private static ArrayList<Object> createList() {
		Database.dbConnect();
		DBCursor cursorObj =  Database.feedsCollection().find();
		ArrayList<Object> feedList =new ArrayList<>();
		System.out.println("___________________________________________________________");
		System.out.println("ALL TRANSACTIONS");
	    try {
	        while(cursorObj.hasNext()) {
	        	feedList.add(cursorObj.next());
	        }
	        return feedList;
	    } 
	    catch(Exception e) {
	    	System.out.print(e.getMessage());
	    	return feedList;
	    }
	    finally {
	        cursorObj.close();
	    }
	}
	
	
	
	


}
