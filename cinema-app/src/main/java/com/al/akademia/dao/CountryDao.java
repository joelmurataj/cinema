package com.al.akademia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.al.akademia.entitete.Country;
import com.al.akademia.utility.HibernateUtil;


public class CountryDao {

	private static Transaction transObj = null;

	private static Session sessionObj=HibernateUtil.getSessionFactory().openSession(); ;
	
	public static Country getCountryById(int countryId) {
	    
	    Country country = null;
	    try {
	    	
	    	country = (Country) sessionObj.get(Country.class, countryId);
	    	} 
	    catch (Exception e) {
	    	e.printStackTrace();
	    	} 
	    
	    return country;
	}
	
	public static List<Country> getAllCountries(){

		try {
		
			List<Country> countries = sessionObj.createQuery("from Country ").getResultList();
			return countries;
			} 
		catch (Exception exceptionObj) {

			exceptionObj.printStackTrace();
			return null;
			
			} 
		
	}
}
