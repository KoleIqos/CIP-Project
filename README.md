Urban Green Spaces Reservation API
Introduction
This API enables users to manage events in urban green spaces. It provides endpoints to create, retrieve, and delete events, facilitating the organization and maintenance of public events in green spaces.

http://localhost:8080/api
Endpoints
1. Retrieve All Events
HTTP Method: GET

Endpoint: /events

Description: Fetch a list of all events.

Request Headers:

Accept: application/json
Responses:

200 OK:
json
[
  {
    "id": 1,
    "name": "Tree Planting Event",
    "description": "Community tree planting event.",
    "date": "2024-06-01",
    "location": "Central Park"
  },
  {
    "id": 2,
    "name": "Yoga in the Park",
    "description": "Morning yoga sessions.",
    "date": "2024-06-02",
    "location": "Riverside Park"
  }
]
204 No Content: No events found.
2. Retrieve Event by ID
HTTP Method: GET

Endpoint: /events/{id}

Description: Fetch details of a single event by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the event
Responses:

200 OK:
json
{
  "id": 1,
  "name": "Tree Planting Event",
  "description": "Community tree planting event.",
  "date": "2024-06-01",
  "location": "Central Park"
}
404 Not Found: Event not found.
3. Create a New Event
HTTP Method: POST

Endpoint: /events

Description: Create a new event with the provided details.

Request Headers:

Content-Type: application/json
Request Body:

json
{
  "name": "Community Cleanup",
  "description": "Neighborhood cleanup and waste collection.",
  "date": "2024-06-05",
  "location": "Downtown Park"
}
Responses:

201 Created:
json
{
  "id": 3,
  "name": "Community Cleanup",
  "description": "Neighborhood cleanup and waste collection.",
  "date": "2024-06-05",
  "location": "Downtown Park"
}
400 Bad Request: Invalid input.
4. Delete an Event
HTTP Method: DELETE

Endpoint: /events/{id}

Description: Delete an event by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the event
Responses:

204 No Content: Successfully deleted.
404 Not Found: Event not found.
