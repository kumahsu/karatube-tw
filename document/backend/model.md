## Models

#### Singer Type
+ Enum (integer)
	+ Values
		+ `0` - Undefine
		+ `1` - Male singer
		+ `2` - Female singer
		+ `3` - Group
		+ `4` - Duet

#### Singer Detail
+ Fields
	+ id (string, required) - UUID
	+ name (string, required) - Singer name
	+ type ([Singer Type](#singer-type), required) - Singer type
