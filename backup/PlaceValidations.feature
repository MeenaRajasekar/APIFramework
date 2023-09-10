#Author: your.email@your.domain.com
#Keywords Summary :
Feature: Validating place APIs

@AddPlace
Scenario outline: Verify if place is being added successfully using AddPlaceAPI.



Given: Add Place Payload "<name>" "<language>" "<address>"
When: Usercalls "addPlaceAPI" with "Post" HTTP Request
#Then: The API call is success with status code 200 
#And: "Status" in response body is "ok"
#And: Verify place-id created that maps to "<name>" using "getPlaceAPI"

Examples:
|name            |language             |address			|
|Athouse				 |English							 |WorldCentre|





@DeletePlace
Scenario: Verify if DeletePlace functionality is working 
Given: Deleteplace Payload
When: Usercalls "addPlaceAPI" with "Post" HTTP Request
Then: The API call is success with status code 200 
And: "Status" in response body is "ok"