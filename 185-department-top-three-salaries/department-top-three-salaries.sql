# Write your MySQL query statement below
select d.name as Department, e.name as Employee, e.salary from employee e
join department d on e.departmentId = d.id
where (select count(distinct e2.salary) from employee e2
where e2.departmentId = e.departmentId and e2.salary > e.salary)<3;