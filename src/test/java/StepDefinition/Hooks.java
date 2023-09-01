package StepDefinition;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() {
		
		StepDefinition m=new StepDefinition();
		
		if(StepDefinition.place_id==null) //calling the variable place_id with class Name not with Object because static variables are tied up with class memeory not with object memeory
		{
		m.add_place_payload_with("Meena", "Tamil", "Asia");
		m.user_calls_with_http_request("addPlaceAPI", "POST");
		m.verify_place_id_created_maps_to("getPlaceAPI","Meena" );
		
	   }
	
	
	}
	
	
	
	
	
}
