import junit.framework.TestCase;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import org.json.*;
import org.junit.Test;

public class TestCases {
	
	String correctData = "{\":@computed_region_bh8s_q3mv\":\"29492\",\":@computed_region_fyvs_ahh9\":\"3\",\":@computed_region_p5aj_wyqh\":\"5\","
			+ "\":@computed_region_rxqg_mtj9\":\"5\",\":@computed_region_yftq_j783\":\"15\",\"facility_name\":\"California Pacific Med Ctr-davies Campus\","
			+ "\"facility_type\":\"General Acute Care Hospital\",\"location\":{\"type\":\"Point\",\"coordinates\":[-122.4358177,37.76905419]},"
			+ "\"location_address\":\"CASTRO AND DUBOCE STREETS\",\"location_city\":\"San Francisco\",\"location_state\":\"CA\",\"oshpd_id\":\"106380933\","
			+ "\"services\":\"Hospital\",\"uid\":\"2\"}";
	

	//Checking for null pointer exception
	@Test(expected=NullPointerException.class)
    public void nullException() {
        String str = null;
        assertNull("Null Pointer Exception", new JSONArray(str));
    }
	
	//Making sure the JSON input is in the required format
    @Test
    public void badJSON() {
        String str = "bad";
        try {
            assertNull("Exception thrown here", new JSONArray((Object)str));
        } catch (JSONException e) {
            assertTrue("Expected an exception message", 
                    "JSONArray initial value should be a string or collection or array.".
                    equals(e.getMessage()));
        }
    }
    
    //check if JSON array can be converted to JSON object
    @Test
    public void toJSONObject() {
        JSONArray names = new JSONArray();
        JSONArray jsonArray = new JSONArray();
        assertTrue("toJSONObject should return null",
                null == jsonArray.toJSONObject(names));
    }
    
    
}
