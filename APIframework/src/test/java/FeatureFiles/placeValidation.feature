Feature: Validating place APIS

Scenario: Verify if place is successfully added through AddPlace API

Given Add "Place" payload
When User calls "AddPlaceAPI" with POST request
Then the API call is successfull with status code 200
And "status" in response body is "OK" 
And "scope" in response body is "APP"

Scenario: Verify if place is successfully added through AddPlace API-2

Given Add "Places" payload
When User calls "AddPlaceAPI" with POST request
Then the API call is successfull with status code 200
And "status" in response body is "OK" 
And "scope" in response body is "APP"

Scenario: Verify if place is successfully added through AddPlace API-3

Given Add "Placed" payload
When User calls "AddPlaceAPI" with POST request
Then the API call is successfull with status code 200
And "status" in response body is "OK" 
And "scope" in response body is "APP"