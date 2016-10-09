## Song Management

### API Root [/song]

#### Create Song [POST]
+ Request (application/json)
	+ Headers
		
		```
		Content-Type: application/json
		```
	+ Fields
		+ name (string, required) - Song name
		+ category ([Song Category](models.md#song-category), required) - Song category
		+ singer_id (string, required) - Singer ID
		+ tube_id (string, required) - Youtube video ID
	+ Body

		```json
		{
			"name": "Mock Song",
			"category": 0,
			"singer_id": "f9775ad5-9141-402a-9087-63a4d3dee16f",
			"tube_id": "aXV7kf"
		}
		```

+ Response 200 (application/json)
	+ Headers

		```
		Content-Type: application/json
		```
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, reuqired) - Response message
		+ data ([Song Detail](models.md#song-detail), optional) - Response data
	+ Body

		```json
		{
			"status": 0,
			"message": "success",
			"data": {
				"id": "a6acf4b6-8ed2-454a-a9f0-9a17fb1fda7f",
				"name": "Mock Song",
				"category": 0,
				"singer_id": "f9775ad5-9141-402a-9087-63a4d3dee16f",
				"singer_name": "Mock Singer",
				"tube_id": "aXV7kf",
				"confirmed": 0
			}
		}
		```

#### Confirmed Song [PUT, /{song_id}/confirmed]
+ Request (application/json)
	+ Headers

		```
		Content-Type: application/json
		```
	+ Parameters
		+ song_id (string, required) - Song ID to update
	+ Fields
		+ type ([Confirmed Type](models.md#confirmed-type), required) - Song type
	+ Body
	
		```json
		{
			"type": 0
		}
		```
		
+ Response 200 (application/json)
	+ Headers
		
		```
		Content-Type: application/json
		```
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, required) - Resopnse message
		+ data ([Singer Detail](models.md#singer-detail), optional) - Response data
	+ Body

		```json
		{
			"status": 0,
			"message": "success",
			"data": {
				"id": "a6acf4b6-8ed2-454a-a9f0-9a17fb1fda7f",
				"name": "Mock Song",
				"category": 0,
				"singer_id": "f9775ad5-9141-402a-9087-63a4d3dee16f",
				"singer_name": "Mock Singer",
				"tube_id": "aXV7kf",
				"confirmed": 0
			}
		}
		```
		
#### Delete Song [DELETE, /{song_id}]
+ Request
	+ Parameters
		+ song_id (string, required) - Song ID to delete

+ Response 200 (applicatoin/json)
	+ Headers
		
		```
		Content-Type: application/json
		```
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
		
#### Get Song Detail [GET, /{song_id}]
+ Request
	+ Parameters
		+ song_id (string, required) - Song ID for search

+ Response 200 (application/json)
	+ Headers

		```
		Content-Type: application/json
		```
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, required) - Response message
		+ data ([Song Detail](models.md#song-detail), optional) - Response data
	+ Body

		```json
		{
			"status": 0,
			"message": "success",
			"data": {
				"id": "a6acf4b6-8ed2-454a-a9f0-9a17fb1fda7f",
				"name": "Mock Song",
				"category": 0,
				"singer_id": "f9775ad5-9141-402a-9087-63a4d3dee16f",
				"singer_name": "Mock Singer",
				"tube_id": "aXV7kf",
				"confirmed": 0
			}
		}
		```

#### Get Song List [GET, /list?index={index}&size={size}&category={category}&name={name}]
+ Request
	+ Parameters
		+ index (integer, optional) - Get list from index
		+ size (integer, optional) - Get list size
		+ category ([Song Category](models.md#song-category), optional) - Song category
		+ name (string, optional) - Song name

+ Response 200 (applicaton/json)
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
