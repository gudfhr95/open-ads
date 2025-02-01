ALTER table ad_users
  ADD COLUMN user_id    CHAR(36) UNIQUE,
  ADD COLUMN name       VARCHAR(255),
  ADD COLUMN email      VARCHAR(255),
  ADD COLUMN created_at TIMESTAMP,
  ADD COLUMN created_by VARCHAR(255),
  ADD COLUMN updated_at TIMESTAMP,
  ADD COLUMN updated_by VARCHAR(255);
