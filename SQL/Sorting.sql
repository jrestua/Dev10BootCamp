SELECT * FROM Worker;

-- Sort by last name in ascending order
SELECT * 
FROM Worker
ORDER BY LastName;

-- Sort descending by LastName.
SELECT * 
FROM Worker
ORDER BY LastName DESC;

-- Sort ascending by LastName.
-- ASC isn't strictly required since it is the default sort direction.
SELECT * 
FROM Worker
ORDER BY LastName ASC;

-- Sorting is no different for JOIN queries. Qualify your sort column with its table name or alias.
SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName ASC;

-- First, we sort by a Worker's last name, then we sort by the Project's name.
SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName ASC, p.Name ASC;

-- Workers by last name descending and Projects by project name ascending
SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName DESC, p.Name ASC;

SELECT
    t.Title,
    s.Name StatusName
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
ORDER BY s.Name ASC;

-- Results are sorted non-null to null, then by TaskStatus.Name.
-- That puts NULL values last.
SELECT
    t.Title,
    s.Name StatusName
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
ORDER BY ISNULL(s.Name), s.Name ASC;

-- LIMIT [Row offset] [Number of rows]
SELECT *
FROM Worker
ORDER BY LastName DESC
LIMIT 0, 10;

-- There is no offset (remember that programmers start counting from zero) and we grab 10 rows.
-- Next, offset by 10 rows and grab 10.
SELECT *
FROM Worker
ORDER BY LastName DESC
LIMIT 10, 10;

-- The result is empty. No records are returned
SELECT *
FROM Worker
ORDER BY LastName DESC
LIMIT 200, 10;

-- Skip the first 100 records and show the next 25.
SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName DESC, p.Name ASC
LIMIT 100, 25;