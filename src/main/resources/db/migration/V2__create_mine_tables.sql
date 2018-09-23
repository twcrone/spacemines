CREATE TABLE mine_field (
  uuid VARCHAR(255) PRIMARY KEY,
  x_length INT,
  y_length INT,
  z_length INT
);

CREATE TABLE mine (
  uuid VARCHAR(255) PRIMARY KEY ,
  x INT,
  y INT,
  z INT,
  mine_field_uuid VARCHAR(255) REFERENCES mine_field(uuid)
);