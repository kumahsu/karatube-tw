## Common Service

### API Root [/common]

#### Health Check [GET, /health]
+ Request

+ Resopnse 200 (application/json)
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (String, required) - Response message
	+ Body

		```json
		{
			"status": 0,
			"message": "success"
		}
		```
		
#### Echo Service [POST, /echo]
+ Request (application/json)
	+ Headers

		```
		Content-Type: application/json
		```
	+ Fields
		+ message (string, required) - Message to echo
	+ Body

		```json
		{
			"message": "echo message"
		}
		```

+ Response 200 (application/json)
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, required) - Response message
		+ data (string, required) - Echo message
	+ Body

		```json
		{
			"status": 0,
			"message": "success",
			"data": "echo message"
		}
		```