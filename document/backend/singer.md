## Singer Management

### API Root [/singer]

#### Create Singer [POST]
+ Request (application/json)
	+ Headers
	
		```
		Content-Type: application/json
		```
	+ Fields
		+ name (string, required) - Singer name
		+ type ([SingerType](models.md#singer-type), required) - Singer type
		+ keywords (string, required) - Keywords for search singer, allow empty
	+ Body
	
		```json
		{
			"name": "Mock Singer",
			"type": 0,
			"keywords": "test,mock"
		}
		```
		
+ Response 200 (application/json)
	+ Headers

		```
		Content-Type: application/json
		```
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, required) - Response message
		+ data ([Singer Detail](models.md#singer-detail), optional) - Response data
	+ Body
	
		```json
		{
			"status": 0,
			"message": "success",
			"data": {
				"id": "f9775ad5-9141-402a-9087-63a4d3dee16f",
				"name": "Mock Singer",
				"type": 0,
				"keywords": "test,mock"
			}
		}
		```
		
#### Update Singer [PUT, /{singer_id}]
+ Request (application/json)
	+ Headers

		```
		Content-Type: application/json
		```
	+ Parameters
		+ singer_id (string, required) - Singer ID to update
	+ Fields
		+ type ([Singer Type](models.md#singer-type), optional) - Singer Type
		+ keywords (string, optional) - Keywords for search singer
	+ Body

		```json
		{
			"type": 0,
			"keywords": "test,mock"
		}
		```

+ Response 200 (application/json)
	+ Headers
		
		```
		Content-Type: application/json
		```
	+ Fields
		+ status (integer, status) - [Status Code](status.md)
		+ message (string, status) - Response message
		+ data ([Singer Detail](models.md#singer-detail), optional) - Response data
	+ Body
	
		```json
		{
			"status": 0,
			"message": "success",
			"data": {
				"id": "f9775ad5-9141-402a-9087-63a4d3dee16f",
				"name": "Mock Singer",
				"type": 0,
				"keywords": "test,mock"
			}
		}
		```
		
#### Delete Singer [DELETE, /{singer_id}]
+ Request
	+ Parameters
		+ singer_id (string, required) - Singer ID to delete

+ Response 200 (application/json)
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, required) - Response message
	+ Body

		```json
		{
			"status": 0,
			"message": "success"
		}
		```

#### Get Singer Detail [GET, /{singer_id}]
+ Request
	+ Parameters
		+ singer_id (string, required) - Singer ID

+ Response
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, required) - Response message
		+ data ([Singer Detail](models.md#singer-detail), optional) - Response data
	+ Body

		```json
		{
			"status": 0,
			"message": "success",
			"data": {
				"id": "f9775ad5-9141-402a-9087-63a4d3dee16f",
				"name": "Mock Singer",
				"type": 0,
				"keywords": "test,mock"
			}
		}
		```
		
#### Get Singer List [GET, /list?index={index}&size={size}&type={type}&keyword={keyword}]
+ Request
	+ Parameters
		+ index (integer, optional) - Get list from index
		+ size (integer, optional) - Get list size
		+ type ([Singer Type](models.md#singer-type), optional) Singer type, can not be null if search by keyword
		+ keyword (string, optional) - Search singers by keowrd

+ Response 200 (application/json)
	+ Headers

		```
		Content-Type: application/json
		```
	+ Models
		+ Data
			+ size (integer, required) - List size
			+ totalCount (integer, required) - Total result size on server
			+ startIndex (integer, required) - List start index
			+ list (array[[Singer Detail](models.md#singer-detail)], required) - Singer detail list
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, required) - Response message
		+ data (Data, optional) - Response Data
	+ Body

		```json
		{
			"status": 0,
			"message": "success",
			"data": {
				"size": 1,
				"totalCount": 1,
				"startIndex": 0,
				"list": [
					{
						"id": "f9775ad5-9141-402a-9087-63a4d3dee16f",
						"name": "Mock Singer",
						"type": 0,
						"keywords": "test,mock"
					}
				]
			}
		}
		```
		
#### Get Songs By Singer [GET, /{singer_id}/songs?index={index}&size={size}]
+ Request
	+ Parameters
		+ singer_id (string, required) - Singer ID
		+ index (integer, optional) - Get list from index
		+ size (integer, optional) - Get list size

+ Response 200 (application/json)
	+ Headers
		
		```
		Content-Type: application/json
		```
	+ Models
		+ Data
			+ size (integer, required) - List size
			+ totalCount (integer, required) - Total result size on server
			+ startIndex (integer, required) - List start index
			+ list (array[[Song Detail](models.md#song-detail)], required) - Song detail list
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, required) - Response message
		+ data (Data, optional) - Response data
	+ Body
	
		```json
		{
			"status": 0,
			"message": "success",
			"data": {
				"size": 1,
				"totalCount": 1,
				"startIndex": 0,
				"list": [
					{
						"id": "a6acf4b6-8ed2-454a-a9f0-9a17fb1fda7f",
						"name": "Mock Song",
						"category": 0,
						"singer_id": "f9775ad5-9141-402a-9087-63a4d3dee16f",
						"singer_name": "Mock Singer",
						"tube_id": "aXV7kf",
						"confirmed": 0
					}
				]
			}
		}
		```