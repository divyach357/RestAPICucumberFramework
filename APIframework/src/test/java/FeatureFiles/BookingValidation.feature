Feature: Validating Booking APIS

Scenario: Verify if booking is successfully added through Booking API

Given Retrieve "Booking" payload
When User calls "AddBookingAPI" with GET request
Then the API call is successfull with status code 200
And "status" in response body is "OK" 

Given Add "Booking" payload
When User calls "AddBookingAPI" with POST request
Then the API call is successfull with status code 200
And "status" in response body is "OK" 
