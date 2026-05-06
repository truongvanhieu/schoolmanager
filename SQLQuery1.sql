CREATE TABLE students (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100),
    email NVARCHAR(100),
    age INT
);
INSERT INTO students (name, email, age) VALUES
(N'Nguyễn Văn A', 'a@gmail.com', 20),
(N'Trần Thị B', 'b@gmail.com', 21),
(N'Lê Văn C', 'c@gmail.com', 22),
(N'Phạm Thị D', 'd@gmail.com', 19),
(N'Hoàng Văn E', 'e@gmail.com', 23);