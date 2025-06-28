This project demonstrates API test automation using RestAssured, Cucumber, and JUnit frameworks. 
The tests cover Add Place API and Booking API workflows, showcasing behavior-driven development (BDD) with data-driven testing.

Tech Stack
Java
RestAssured
Cucumber
JUnit
Maven

APIs Tested
✅ Add Place API
POST /maps/api/place/add/json
Creates a new place with details like name, location, and address.
Validates response status, place ID, and fields.

✅ Booking API
POST /booking
Creates a new booking.

GET /booking/{id}
Retrieves booking details.

PayloadBuilder.java – Generates dynamic JSON payloads.
TestDataBuilder.java – Supplies data-driven inputs.
Utils.java – Common configurations like base URI, request specifications, and reusable methods.


Author
Divya.
