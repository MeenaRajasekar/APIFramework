

#Feature: Validating place API
#Scenario: Verify if place is being added successfully using AddPlaceAPI



@AddPlace
  Scenario: Verify if Place is being successfully addedusing AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When User calls "AddPlaceAPI" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaveAPI"

    Examples: 
      | name    | language   | address       |
      | AAhouse | English    | Westwijk      |
      | Bhouse  | Dutch      | Kronenburg    |

      
  @DeletePlace  
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When User calls "deletePlaceAPI" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"