Space Mines API
===============

This project is the API work to support saved games and mine field levels
via REST that will be fronted by Javascript like the engine used here
to render various games and make them playable in a web browswer.

http://twcrone.com/space-mines/

The API starting point is to list existing Game UUIDs.

GET https://spacemines.herokuapp.com


To create a game based on a mine field use 'TEST'.

POST https://spacemines.herokuapp.com/game

```$javascript
{
  "mineFieldUuid": "TEST"
}
```
 
The way to get current state of a "Game" and the primary GET request would look like this:

https://spacemines.herokuapp.com/game/UUID_RETURNED_ABOVE

Radiation levels is an implication on any active 'mines' in adjacent
slots.  -1 means the radiation is UNKNOWN and this location has yet
to be revealed.  Once a location has been 'revealed', known radiation
levels will be 0 to 26.  With something higher than 26 being a location 
of an actual mine.