CREATE DATABASE EmployeeManagementSystem;
GO

USE EmployeeManagementSystem;
GO

CREATE TABLE Departments
(
    DepartmentId INT PRIMARY KEY IDENTITY(1,1),

    DepartmentName VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Employees
(
    EmployeeId INT PRIMARY KEY IDENTITY(1,1),

    FirstName VARCHAR(50) NOT NULL,

    LastName VARCHAR(50) NOT NULL,

    Email VARCHAR(150) NOT NULL UNIQUE,

    Salary DECIMAL(10,2) NOT NULL,

    HireDate DATE NOT NULL,

    DepartmentId INT NOT NULL,

    CONSTRAINT FK_Employees_Departments
        FOREIGN KEY (DepartmentId)
        REFERENCES Departments(DepartmentId)
);

CREATE TABLE Projects
(
    ProjectId INT PRIMARY KEY IDENTITY(1,1),

    ProjectName VARCHAR(150) NOT NULL,

    StartDate DATE NOT NULL,

    EndDate DATE NULL,

    Budget DECIMAL(12,2) NOT NULL
);

CREATE TABLE EmployeeProjects
(
    EmployeeId INT NOT NULL,

    ProjectId INT NOT NULL,

    AssignedDate DATE NOT NULL,

    Role VARCHAR(100) NULL,

    CONSTRAINT PK_EmployeeProjects
        PRIMARY KEY (EmployeeId, ProjectId),

    CONSTRAINT FK_EmployeeProjects_Employees
        FOREIGN KEY (EmployeeId)
        REFERENCES Employees(EmployeeId),

    CONSTRAINT FK_EmployeeProjects_Projects
        FOREIGN KEY (ProjectId)
        REFERENCES Projects(ProjectId)
);


INSERT INTO Departments (DepartmentName)
VALUES
('IT'),
('HR'),
('Finance'),
('Marketing'),
('Sales');

INSERT INTO Employees
(
    FirstName,
    LastName,
    Email,
    Salary,
    HireDate,
    DepartmentId
)
VALUES
('Ahmed', 'Kelany', 'ahmed@gmail.com', 10000, '2025-01-10', 1),

('Mohamed', 'Ali', 'mohamed@gmail.com', 12000, '2024-05-15', 1),

('Omar', 'Hassan', 'omar@gmail.com', 8000, '2025-03-20', 2),

('Ali', 'Mahmoud', 'ali@gmail.com', 15000, '2023-09-01', 3),

('Sara', 'Ahmed', 'sara@gmail.com', 11000, '2024-11-10', 4),

('Youssef', 'Khaled', 'youssef@gmail.com', 9000, '2026-01-01', 1),

('Mariam', 'Samir', 'mariam@gmail.com', 13000, '2024-02-12', 3),

('Hassan', 'Ibrahim', 'hassan@gmail.com', 7000, '2025-06-01', 5);

INSERT INTO Projects
(
    ProjectName,
    StartDate,
    EndDate,
    Budget
)
VALUES
('Employee Portal', '2025-01-01', '2025-06-30', 100000),

('HR Management System', '2025-03-01', '2025-09-30', 75000),

('Financial Dashboard', '2025-02-15', '2025-08-15', 120000),

('Marketing Campaign', '2025-05-01', '2025-07-31', 50000);

INSERT INTO EmployeeProjects
(
    EmployeeId,
    ProjectId,
    AssignedDate,
    Role
)
VALUES
(1, 1, '2025-01-05', 'Backend Developer'),

(2, 1, '2025-01-05', 'Senior Developer'),

(6, 1, '2026-01-05', 'Junior Developer'),

(3, 2, '2025-03-05', 'HR Specialist'),

(1, 2, '2025-03-05', 'Backend Developer'),

(4, 3, '2025-02-20', 'Financial Analyst'),

(7, 3, '2025-02-20', 'Financial Manager'),

(5, 4, '2025-05-05', 'Marketing Specialist');

INSERT INTO Employees
(
    FirstName,
    LastName,
    Email,
    Salary,
    HireDate,
    DepartmentId
)
VALUES
(
    'Khaled',
    'Mostafa',
    'khaled@gmail.com',
    9500,
    '2026-02-01',
    5
);

SELECT *
FROM Employees;

SELECT *
FROM Employees
WHERE EmployeeId = 1;

SELECT *
FROM Employees
WHERE Salary > 10000;

UPDATE Employees
SET Salary = 12000
WHERE EmployeeId = 1;

DELETE FROM Employees
WHERE EmployeeId = 9;

SELECT
    e.EmployeeId,
    e.FirstName,
    e.LastName,
    e.Salary,
    d.DepartmentName
FROM Employees e
INNER JOIN Departments d
    ON e.DepartmentId = d.DepartmentId;

    SELECT
    d.DepartmentName,
    e.FirstName,
    e.LastName
FROM Departments d
LEFT JOIN Employees e
    ON d.DepartmentId = e.DepartmentId;

    SELECT
    e.FirstName,
    e.LastName,
    p.ProjectName,
    ep.Role
FROM Employees e
INNER JOIN EmployeeProjects ep
    ON e.EmployeeId = ep.EmployeeId
INNER JOIN Projects p
    ON ep.ProjectId = p.ProjectId;

SELECT
    DepartmentId,
    COUNT(*) AS EmployeeCount
FROM Employees
GROUP BY DepartmentId;

SELECT
    d.DepartmentName,
    COUNT(e.EmployeeId) AS EmployeeCount
FROM Departments d
LEFT JOIN Employees e
    ON d.DepartmentId = e.DepartmentId
GROUP BY d.DepartmentName;


SELECT COUNT(*) AS TotalEmployees
FROM Employees;


SELECT SUM(Salary) AS TotalSalaries
FROM Employees;



SELECT AVG(Salary) AS AverageSalary
FROM Employees;


SELECT MAX(Salary) AS HighestSalary
FROM Employees;

SELECT MIN(Salary) AS LowestSalary
FROM Employees;

SELECT
    COUNT(*) AS TotalEmployees,
    SUM(Salary) AS TotalSalaries,
    AVG(Salary) AS AverageSalary,
    MAX(Salary) AS HighestSalary,
    MIN(Salary) AS LowestSalary
FROM Employees;


SELECT
    d.DepartmentName,
    AVG(e.Salary) AS AverageSalary
FROM Departments d
INNER JOIN Employees e
    ON d.DepartmentId = e.DepartmentId
GROUP BY d.DepartmentName;



SELECT
    d.DepartmentName,
    COUNT(e.EmployeeId) AS EmployeeCount
FROM Departments d
INNER JOIN Employees e
    ON d.DepartmentId = e.DepartmentId
GROUP BY d.DepartmentName
HAVING COUNT(e.EmployeeId) > 1;


SELECT
    d.DepartmentName,
    AVG(e.Salary) AS AverageSalary
FROM Departments d
INNER JOIN Employees e
    ON d.DepartmentId = e.DepartmentId
GROUP BY d.DepartmentName
HAVING AVG(e.Salary) > 10000;




CREATE VIEW EmployeeDetails
AS
SELECT
    e.EmployeeId,
    e.FirstName,
    e.LastName,
    e.Email,
    e.Salary,
    e.HireDate,
    d.DepartmentName
FROM Employees e
INNER JOIN Departments d
    ON e.DepartmentId = d.DepartmentId;



SELECT *
FROM EmployeeDetails;

SELECT
    FirstName,
    LastName,
    DepartmentName,
    Salary
FROM EmployeeDetails
WHERE Salary > 10000;


CREATE VIEW DepartmentStatistics
AS
SELECT
    d.DepartmentId,
    d.DepartmentName,
    COUNT(e.EmployeeId) AS EmployeeCount,
    AVG(e.Salary) AS AverageSalary,
    MAX(e.Salary) AS HighestSalary,
    MIN(e.Salary) AS LowestSalary
FROM Departments d
LEFT JOIN Employees e
    ON d.DepartmentId = e.DepartmentId
GROUP BY
    d.DepartmentId,
    d.DepartmentName;


SELECT *
FROM DepartmentStatistics;
GO


CREATE INDEX IX_Employees_Email
ON Employees(Email);
GO


CREATE INDEX IX_Employees_DepartmentId
ON Employees(DepartmentId);
GO



CREATE INDEX IX_Employees_Salary
ON Employees(Salary);
GO



BEGIN TRANSACTION;

UPDATE Employees
SET Salary = Salary + 1000
WHERE DepartmentId = 1;

COMMIT TRANSACTION;
GO


/* Transaction with ROLLBACK */

BEGIN TRANSACTION;

UPDATE Employees
SET Salary = Salary + 5000
WHERE EmployeeId = 1;

-- Cancel the operation
ROLLBACK TRANSACTION;
GO


/* =========================================================
   TRANSACTION WITH TRY/CATCH
   ========================================================= */

BEGIN TRY

    BEGIN TRANSACTION;

    UPDATE Employees
    SET Salary = Salary + 1000
    WHERE DepartmentId = 1;

    UPDATE Employees
    SET Salary = Salary + 500
    WHERE DepartmentId = 2;

    COMMIT TRANSACTION;

END TRY
BEGIN CATCH

    ROLLBACK TRANSACTION;

    PRINT 'Transaction failed and was rolled back.';

END CATCH;
GO

/* Employees ordered by salary */

SELECT *
FROM Employees
ORDER BY Salary DESC;
GO


/* Highest paid employee */

SELECT TOP 1
    FirstName,
    LastName,
    Salary
FROM Employees
ORDER BY Salary DESC;
GO


/* Employees hired after 2024 */

SELECT *
FROM Employees
WHERE HireDate >= '2024-01-01';
GO


/* Employees in IT */

SELECT
    e.FirstName,
    e.LastName,
    d.DepartmentName
FROM Employees e
INNER JOIN Departments d
    ON e.DepartmentId = d.DepartmentId
WHERE d.DepartmentName = 'IT';
GO


/* Total salary per department */

SELECT
    d.DepartmentName,
    SUM(e.Salary) AS TotalSalary
FROM Departments d
INNER JOIN Employees e
    ON d.DepartmentId = e.DepartmentId
GROUP BY d.DepartmentName;
GO


/* Average salary per department */

SELECT
    d.DepartmentName,
    AVG(e.Salary) AS AverageSalary
FROM Departments d
INNER JOIN Employees e
    ON d.DepartmentId = e.DepartmentId
GROUP BY d.DepartmentName;