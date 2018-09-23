CREATE TABLE game (
  uuid VARCHAR(255) PRIMARY KEY
);

CREATE TABLE game_sphere (
  id BIGINT PRIMARY KEY,
  x INT,
  y INT,
  z INT,
  radiation INT,
  game_uuid VARCHAR(255) REFERENCES game(uuid)
);