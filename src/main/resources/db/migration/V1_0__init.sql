CREATE TABLE clan(
  id BIGSERIAL,
  name VARCHAR NOT NULL,
  uuid UUID DEFAULT random_uuid(),
  PRIMARY KEY (id)
);

CREATE TABLE member(
  id BIGSERIAL,
  name VARCHAR NOT NULL,
  uuid UUID DEFAULT random_uuid(),
  PRIMARY KEY (id)
);

CREATE TABLE clan_member (
  clan_id BIGINT NOT NULL,
  member_id BIGINT NOT NULL,
  FOREIGN KEY (clan_id) REFERENCES clan(id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (member_id) REFERENCES member(id) ON UPDATE CASCADE,
  CONSTRAINT clan_member_pkey PRIMARY KEY (clan_id, member_id)
)