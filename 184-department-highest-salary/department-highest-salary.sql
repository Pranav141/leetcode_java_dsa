# Write your MySQL query statement below
with sal as (
select id,departmentId,salary,name,dense_rank() over( Partition by departmentId order by salary desc) as rnk
from Employee
)
select d.name as Department,s.name as Employee,s.salary as Salary from sal as s join department d on s.departmentId = d.id where rnk = 1 order by s.id;