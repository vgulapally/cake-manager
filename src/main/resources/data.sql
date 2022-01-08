DROP TABLE IF EXISTS CAKE;
  
CREATE TABLE CAKE (
  ID INT PRIMARY KEY,
  TITLE VARCHAR(100) NOT NULL UNIQUE,
  DESCRIPTION VARCHAR(100) NOT NULL,
  IMAGE VARCHAR(300) NOT NULL
);
  
INSERT INTO cake (id, title, description, image) VALUES
('1', 'Vanilla', 'Vanilla Cake', 'Vanilla'),
('2', 'Strawberry', 'Strawberry Cake', 'Strawberry'),
('3', 'Chocolate', 'Chocolate Cake', 'Chocolate'),
('4', 'Lemon', 'Lemon Cake', 'Lemon');