package com.arcada.devops.unit_tester;

public class App {
	
	// Function that returns a list of friends based on a Facebook URL
    public String[] getFriends(String facebookUrl) {    	
        
    	// If the URL is null or empty, throw an exception. Used in test_EmptyUrl() and test_NullUrl()
        if(facebookUrl == null || facebookUrl.isEmpty()) {
            throw new IllegalArgumentException("Invalid Facebook URL");
        }
        
        // Simulate friend fetching by returning hardcoded friends list
        if(facebookUrl.equals("https://www.facebook.com/validuser")) {
            return new String[] {"Emil", "Niraj", "Sebastian"}; // Comparing expected friend list with fetched friend list. Used in test_ValidUser()
        } else if(facebookUrl.equals("https://www.facebook.com/emptyuser")) {
            return new String[] {}; // If the FB person has 0 friend list is empty. Used in test_EmptyUser()
        } else {
            return null; // For invalid user or not found. Used in test_InvalidUser()
        }
    }
}