## Web Socket

### API Root [/ws/player]
### SockJS API Root [/sockjs/player]

### 1. Web Socket Models

#### Topic
+ Enum(string)
	+ `init` - INITIAL ENVIRONMENT
	+ `next` - GET NEXT SONG
	+ `skip` - SKIP SONG
	+ `restart` - RESTART SONG
	+ `play_pause` - PLAY OR PAUSE SONG
	+ `origin` - ENABLE ORIGIN SINGER SOUND
	+ `wait` - PLAYER WAIT
	+ `notify` - NOTIFY PLAYER

#### Message
+ Fields
	+ id (string, required) - Environment ID
	+ topic ([Topic](#topic), required) - Message topic
	+ msg (object, required) - extra information

#### Initial Environment Response
+ Fields
	+ env_id (string, required) - Environment ID
	+ pair_code (string, required) - Pair code

### 2. Web Socket Methods

#### Initial Environment
Create an environment to ready for client connect, player client sent `init` to server, and get environment ID and pair code from server. Player client should keep the environment ID.

+ Topic - `init`

+ From Client([Message](#message))
	+ id - should be null
	+ topic - `init`
	+ msg - should be null
+ Body

	```json
	{
		"id":null,
		"topic": "init",
		"msg": null
	}
	```

+ From Server([Message](#message))
	+ id - Environment ID
	+ topic - `init`
	+ msg - [Initial Environment Resopnse](#initial-environment-response)
+ Body

	```json
	{
		"id": "975a1932-b805-42ac-aac7-481d5bd40511",
		"topic": "init",
		"msg": {
			"env_id": "975a1932-b805-42ac-aac7-481d5bd40511",
			"pair_code": "0000"
		}
	}
	```
	
#### Get Next Song
Get next song in playlist to play.

+ Topic - `next`

+ From Client([Message](#message))
	+ id - Environment ID
	+ topic - `next`
	+ msg - should be null
+ Body

	```json
	{
		"id": "975a1932-b805-42ac-aac7-481d5bd40511",
		"topic": "next",
		"msg": null
	}
	```

+ From Server([Message](#message))
	+ id - Environment ID
	+ topic - `next`
	+ msg - [Song Detail](models.md#song-detal)
+ Body

	```json
	{
		"id": "975a1932-b805-42ac-aac7-481d5bd40511",
		"topic": "next",
		"msg": {
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

#### Skip Song
Stop current playing song, and player should send get next song request to server.

+ Topic - `skip`

+ From Server([Message](#message))
	+ id - Environment ID
	+ topic - `skip`
	+ msg - should be null
+ Body

	```json
	{
		"id": "975a1932-b805-42ac-aac7-481d5bd40511",
		"topic": "skip",
		"msg": null
	}
	```
	
#### Restart Song
Restart current playing song.

+ Topic - `restart`

+ From Server([Message](#message))
	+ id - Environment ID
	+ topic - `restart`
	+ msg - should be null
+ Body

	```json
	{
		"id": "975a1932-b805-42ac-aac7-481d5bd40511",
		"topic": "restart",
		"msg": null
	}
	```

#### Play or Pause Song
If player is playing, pause the song. start playing otherwise.

+ Topic - `play_pause`

+ From Server([Message](#message))
	+ id - Environment ID
	+ topic - `play_pause`
	+ msg - should be null
+ Body

	```json
	{
		"id": "975a1932-b805-42ac-aac7-481d5bd40511",
		"topic": "play_pause",
		"msg": null
	}
	```

#### Enable Origin Singer Sound
If the song is playing with music only, change to allow origin artist sound. Set to music only otherwise.

+ Topic - `origin`

+ From Server([Message](#message))
	+ id - Environment ID
	+ topic - `origin`
	+ msg - should be null
+ Body

	```json
	{
		"id": "975a1932-b805-42ac-aac7-481d5bd40511",
		"topic": "origin",
		"msg": null
	}
	```
	
#### Player Wait
Player idle until receive notify command.

+ Topic - `wait`

+ From Server([Message](#message))
	+ id - Environment ID
	+ topic - `wait`
	+ msg - should be null
+ Body

	```json
	{
		"id": "975a1932-b805-42ac-aac7-481d5bd40511",
		"topic": "wait",
		"msg": null
	}
	```
	
#### Notify Player
Start working, get next song from server.

+ Topic - `notify`

+ From Server([Message](#message))
	+ id - Environment ID
	+ topic - `notify`
	+ msg - should be null
+ Body

	```json
	{
		"id": "975a1932-b805-42ac-aac7-481d5bd40511",
		"topic": "notify",
		"msg": null
	}
	```