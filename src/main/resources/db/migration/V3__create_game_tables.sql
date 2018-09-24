CREATE TABLE game (
  uuid VARCHAR(255) PRIMARY KEY,
  mine_field_uuid VARCHAR(255) REFERENCES  mine_field(uuid)
);

CREATE TABLE game_sphere (
  id BIGSERIAL PRIMARY KEY,
  x INT,
  y INT,
  z INT,
  radiation INT,
  game_uuid VARCHAR(255) REFERENCES game(uuid)
);