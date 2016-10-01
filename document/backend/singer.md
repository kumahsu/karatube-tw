## Singer Service

### API Root [/singer]

#### Create Singer [POST, /create]
+ Request (application/json)
	+ Headers
	
		```
		Content-Type: application/json
		```
	+ Fields
		+ name (string, required) - Singer name
		+ type ([Singer Type](model.md#singer-type), required) - Singer type
		+ keywords (string, required) - Keywords for search singer, null if unnecessary
	+ Body

		```json
		{
			"name": "mock singer",
			"type": 0,
			"keywords": "fake,test,prototype"
		}
		```
		
+ Response 200 (application/json)
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, required) - Response message
		+ data ([Singer Detail](model.md#singer-detail), optional) - Response data
	+ Body
	
		```json
		{
			"status": 0,
			"message": "success",
			"data": {
				"id": "513da6c2-6979-4f5a-b447-c5a95889a5b2",
				"name": "mock singer",
				"type": 0,
				"keywords": "fake,test,prototype"
			}
		}
		```
		
#### Update Singer [PUT, /update]
+ Request (application/json)
	+ Headers
	
		```
		Content-Type: application/json
		```
	+ Fields
		+ type ([Singer Type](model.md#singer-type), required) - Singer type, null if nothing to update
		+ keywords (string, required) - Keywords for search singer, null if unnecessary
	+ Body

		```json
		{
			"type": 0,
			"keywords": "fake,test"
		}
		```

+ Response 200 (application/json)
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, required) - Response message
		+ data ([Singer Detail](model.md#singer-detail), optional) - Response data
	+ Body

		```json
		{
			"status": 0,
			"message": "success",
			"data": {
				"id": "513da6c2-6979-4f5a-b447-c5a95889a5b2",
				"name": "mock singer",
				"type": 0,
				"keywords": "fake,test"
			}
		}
		```