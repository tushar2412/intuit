DELETE FROM Referrer;

INSERT INTO Referrer (id, domain, timestamp)
VALUES
  (1, 'domain1', 123456789),
  (2, 'domain2', 123456790)
  ON DUPLICATE KEY UPDATE
  id = id;