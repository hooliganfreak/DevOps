package com.arcada.devops.unit_tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppTest {
	
	// Test for a valid user with friends
    @Test
    public void test_ValidUser() {
        App fetcher = new App();
        String[] friends = fetcher.getFriends("https://www.facebook.com/validuser"); // Valid FB profile link
        // Check that the returned list is not null
        assertNotNull(friends);
        // Check that the returned list matches the expected values
        assertArrayEquals(new String[]{"Emil", "Niraj", "Sebastian"}, friends); // This will be true
    }
    
    // Negative test case to demonstrate failure 
    @Test
    public void test_ValidUser_FailureCase() {
        App fetcher = new App();
        String[] friends = fetcher.getFriends("https://www.facebook.com/validuser");
        
        // Intentionally providing wrong expected friends list to demonstrate a failing test
        assertArrayEquals(new String[]{"John", "Doe", "Jane"}, friends); // This will fail
    }
    
    // Test for a user with no friends in their friend list
    @Test
    public void test_EmptyUser() {
    	App fetcher = new App();
        String[] friends = fetcher.getFriends("https://www.facebook.com/emptyuser");
        // Check that the returned list is not null
        assertNotNull(friends);
        // Check that the list contains 0 items (is empty)
        assertEquals(0, friends.length); // This will be true
    }

    // Test for an invalid user
    @Test
    public void test_InvalidUser() {
    	App fetcher = new App();
        String[] friends = fetcher.getFriends("https://www.facebook.com/invaliduser"); // Invalid FB profile link
        // If the URL is invalid, the list will never be fetched -> null
        assertNull(friends); // This will be true
    }

    // Test for the edge case that the URL given is null using a lambda function
    @Test
    public void test_NullUrl() {
    	App fetcher = new App();
        assertThrows(IllegalArgumentException.class, () -> {
            fetcher.getFriends(null); // This will be true
        });
    }

    // Test for the edge case that the URL given is empty using a lambda function
    @Test
    public void test_EmptyUrl() {
    	App fetcher = new App();
        assertThrows(IllegalArgumentException.class, () -> {
            fetcher.getFriends(""); // This will be true
        });
    }
}
