## Control Panel APIs

### API Root [/control]

---

### 1. Environment

#### Connect Environment [POST, /connect]
+ Request (application/json)
	+ Headers

		```
		Content-Type: application/json
		```
	+ Fields
		+ pair_code (string, required) - Pair code
	+ Body

		```json
		{
			"pair_code":"0000"
		}
		```

+ Response 200 (application/json)
	+ Headers
	
		```
		Content-Type: application/json
		Set-Cookie: env=${env_id}
		```
	+ Fields
		+ status (integer, required) - [Status Code](status.md)
		+ message (string, required) - Response Message
		+ env_id (string, optional) - Environment ID
	+ Body

		```json
		{
			"status": 0,
			"message": "success",
			"env_id": "dc60aa86-c544-4b13-9b8e-0c5d2eb7f63f"
		}
		```

---
		
### 2. Playlist

#### Get Playlist [GET, /playlist?index={index}&size={size}]
+ Request
	+ Headers
		
		```
		Cookie: env={env_id}
		```
	+ Parameters
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
		
#### Get Play History [GET, /history?index={index}&size={size}]
+ Request
	+ Headers
	
		```
		Cookie: env=${env_id}
		```
	+ Parameters
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

#### Add Song to Playlist [POST, /playlist]
+ Request (application/json)
	+ Headers
	
		```
		Content-Type: application/json
		Cookie: env=${env_id}
		```
	+ Fields
		+ song_id (string, required) - Song ID for add to playlist
	+ Body

		```json
		{
			"song_id": "a6acf4b6-8ed2-454a-a9f0-9a17fb1fda7f"
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
	+ Body
	
		```json
		{
			"status": 0,
			"message": "success"
		}
		```

#### Insert Song to Head [PUT, /playlist]
+ Request (application/json)
	+ Headers
	
		```
		Cookie: env=${env}
		Content-Type: application/json
		```
	+ Fields
		+ song_id (string, required) - Song ID for insert to head
	+ Body
	
		```json
		{
			"song_id": "a6acf4b6-8ed2-454a-a9f0-9a17fb1fda7f"
		}
		```

+ Response 200 (application/json)
	+ Headers
		
		```
		Content-Type: applicaton/json
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
		
#### Remove Song From Playlist [DELETE, /playlist/{song_id}]
+ Request
	+ Headers

		```
		Cookie: env=${env_id}
		```

	+ Parameters
		+ song_id (string, required) - Song ID to delete from playlist
	
+ Response 200 (application/json)
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

---
	
### 3. Command

#### Skip Song [GET, /skip]
+ Request
	+ Headers
	
		```
		Cookie: env=${env_id}
		```
+ Response 200 (application/json)
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

#### Restart Song [GET, /restart]
+ Request
	+ Headers
		
		```
		Cookie: env=${env_id}
		```

+ Response 200 (application/json)
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
		
#### Play or Pause Song [GET, /play_pause]
+ Request
	+ Headers
		
		```
		Cookie: env=${env_id}
		```

+ Response 200 (application/json)
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

#### Enable Origin [GET, /enable_origin]
+ Request
	+ Headers

		```
		Cookie: end=${env_id}
		```

+ Response 200 (application/json)
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