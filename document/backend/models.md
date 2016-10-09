## Data Models

#### Singer Type
+ Enum(integer)
	+ `0` - UNDEFINE, 未定義
	+ `1` - MALE, 男星
	+ `2` - FEMALE, 女星
	+ `3` = GROUP, 團體
	+ `4` = DUET, 合唱

#### Song Category
+ Enum(integer)
	+ `0` - OTHER, 其他 
	+ `1` - CHINESE, 國語
	+ `2` - TAIWANESE, 台語
	+ `3` - CANTONESE, 粵語
	+ `4` - ENGLISH, 英語
	+ `5` - JAPANESE, 日語
	+ `6` - KOREAN, 韓語
	+ `7` - HAKKA, 客家

#### Confirmed Type
+ Enum(integer)
	+ `0` - NEW, 新加入
	+ `1` - CONFIRMED, 正確
	+ `2` - FAKE, 假的

#### Singer Detail
+ Fields
	+ id (string, required) - Singer ID
	+ name (string, required) - Singer name
	+ type ([Singer Type](#singer-type), required) - Singer type
	+ keywords (string, required) - Keywords for search singer

#### Song Detail
+ Fields
	+ id (string, required) - Song ID
	+ name (string, required) - Song name
	+ category ([Song Category](#song-category), required) - Song category
	+ singer_id (string, required) - Singer ID
	+ singer_name (string, required) - Singer name
	+ tube_id (string, required) - Youtube video ID
	+ confirmed ([Confirmed Type](#confirmed-type), required) - Confirmed type