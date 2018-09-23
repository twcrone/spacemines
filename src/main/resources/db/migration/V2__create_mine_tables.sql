CREATE TABLE mine_field (
  uuid VARCHAR(255) PRIMARY KEY
);

CREATE TABLE mine (
  uuid VARCHAR(255),
  x INT,
  y INT,
  z INT,
  mine_field_uuid VARCHAR(255) REFERENCES mine_field(uuid),
  PRIMARY KEY(uuid)
);