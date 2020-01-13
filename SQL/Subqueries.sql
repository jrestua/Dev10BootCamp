USE TrackIt;

-- The identifier, WorkerId, means two different things depending on where it's 
-- mentioned. In the main query, it refers to Worker.WorkerId. Inside the IN, it refers 
-- to ProjectWorker.WorkerId. Its easy to get confused.

-- An alternative approach might be to JOIN Worker with ProjectWorker. That's a good idea, 
-- but it would return duplicate Workers because Workers can be assigned to more than one Project. 
-- The IN approach, on the other hand, does not duplicate Workers. If a value occurs more than once 
-- in an IN, it is ignored.
SELECT *
FROM Worker
WHERE WorkerId IN (
    SELECT WorkerId FROM ProjectWorker
);

SELECT *
FROM Worker w
INNER JOIN ProjectWorker p ON w.WorkerId = p.WorkerId;

-- This doesnt do what we want.
SELECT
    p.Name ProjectName,
    MIN(t.TaskId) MinTaskId
    -- t.Title is what we want, but the SQL Engine 
    -- doesn't know which Task we're talking about!
    -- t.Title is not part of a group and there's 
    -- no aggregate guaranteed to grab the Title from the MinTaskId.
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
GROUP BY p.ProjectId, p.Name;

-- This works
SELECT
    g.ProjectName,
    g.MinTaskId,
    t.Title MinTaskTitle
FROM Task t
INNER JOIN (
    SELECT
        p.Name ProjectName,
        MIN(t.TaskId) MinTaskId
    FROM Project p
    INNER JOIN Task t ON p.ProjectId = t.ProjectId
    GROUP BY p.ProjectId, p.Name) g ON t.TaskId = g.MinTaskId;
    

-- This query fetches Workers and counts their assigned Projects.
SELECT
    w.FirstName,
    w.LastName,
    (SELECT COUNT(*) FROM ProjectWorker 
    WHERE WorkerId = w.WorkerId) ProjectCount
FROM Worker w;

-- Some queries are impossible without a subquery. Consider grabbing both a Project and the first 
-- Task added to it. We can GROUP BY ProjectId and SELECT MIN(TaskId). That identifies the first Task 
-- added, but then we're stuck. There's no way to fetch the first Task's fields. The only values we can 
-- select are grouped Project fields and Task aggregates. There's no aggregate function that grabs a field 
-- from a specific record.
SELECT
    p.Name ProjectName,
    MIN(t.TaskId) MinTaskId,
    (SELECT Title FROM Task 
    WHERE TaskId = MIN(t.TaskId)) MinTaskTitle
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
GROUP BY p.ProjectId, p.Name

-- View
-- A view is a named query that's stored in a database. Once it's stored, other queries can build on it. 
-- A view can be treated like a table anywhere in a SELECT statement.
CREATE VIEW ProjectNameWithMinTaskId
AS
SELECT
    p.Name ProjectName,
    MIN(t.TaskId) MinTaskId
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
GROUP BY p.ProjectId, p.Name;

-- Select for view thats created
SELECT * FROM ProjectNameWithMinTaskId;

-- More complex query
SELECT
    pt.ProjectName,
    pt.MinTaskId TaskId,
    t.Title
FROM Task t
INNER JOIN ProjectNameWithMinTaskId pt -- Aliased just like a table.
    ON t.TaskId = pt.MinTaskId;
    
-- Advantages
-- Encapsulating complex joins can reduce code complexity and increase code reuse.
-- Views an be secured separately from a table, for example to grant user access to a view without
--  granting access to the tables underneath.
-- Views can limit columns and rows shown to some users.

-- Disadvantages
-- Just because a view appears simple doesn't mean the underlying data model is. A view with simple 
-- results may be very expensive to run.
-- Developers can be tempted to build more and more on top of views because views are easy to understand. 
-- As views are joined to views which are joined to other views, performance issues may arise.