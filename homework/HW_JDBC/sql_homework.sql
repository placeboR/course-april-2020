use course;
SELECT DISTINCT job FROM employee;
SELECT * FROM employee e WHERE job="clerk" ORDER BY e.salary DESC;
SELECT name, hiredate FROM employee WHERE job="manager"; 
SELECT * FROM employee e WHERE job = "clerk" OR job = "analyst" ORDER BY e.empid DESC;
SELECT * FROM employee e WHERE e.salary > 1833 AND e.salary < 3750;
SELECT * FROM employee e WHERE job != "president" AND job != "manager" ORDER BY e.salary DESC;
SELECT * FROM employee e WHERE e.salary > (SELECT salary FROM employee WHERE name = "BLAKE");
SELECT * FROM employee WHERE job = (SELECT job FROM employee WHERE name = "ALLEN");
SELECT * FROM employee e 
WHERE salary = (SELECT salary FROM employee WHERE name = "FORD") OR salary = (SELECT salary FROM employee WHERE name = "SMITH")
ORDER BY e.salary DESC; 
SELECT * FROM employee e WHERE e.hiredate < (SELECT hiredate FROM employee WHERE empid = e.manager);
SELECT d.name AS department, e.name AS employee, e.salary FROM department d, employee e
WHERE d.deptid = e.deptid AND (e.salary, e.deptid) IN (SELECT Max(salary), deptid FROM employee GROUP BY deptid);
SELECT e.name AS employee, d.name AS department FROM employee e LEFT JOIN department d ON e.deptid = d.deptid;
SELECT d.name AS deparment FROM department d WHERE d.deptid NOT IN (SELECT deptid FROM employee);
SELECT name, salary from employee order by salary DESC, name limit 1 offset 1;
SELECT name, salary from employee order by salary DESC, name limit 1 offset 2;
select job, sum(salary) as tot_salary from employee group by job;
select d.name as department, avg(e.salary) as avg_salary from department d join employee e on e.deptid = d.deptid group by d.name;
select d.name as department, avg(e.salary) as avg_salary from department d join employee e on e.deptid = d.deptid group by d.name
having avg(e.salary) > 1000;
select d.name, e.job, count(*) as count from employee e inner join department d on e.deptid = d.deptid group by d.name, e.job order by d.name, count DESC;
select d.name, d.loc as location from department d join employee e on d.deptid = e.deptid group by d.name having count(*) > 2;
select d.name, d.loc as location, count(*) as num_of_employee from department d join employee e on d.deptid = e.deptid group by d.name
having count(case when e.job = "CLERK" then 1 end) >= 2;
select d.name from department d join employee e on d.deptid = e.deptid group by d.name order by count(*) desc limit 1; 
select * from employee where name like '%A%';
select * from employee where day(hiredate) < 15;
select d.name, avg(e.salary) as avg_salary from department d join employee e on d.deptid = e.deptid group by d.deptid having avg(e.salary) > 1000;
select concat(name,'(',lower(job),')') as employee_info from employee;
select distinct e.name from employee e, (select e.deptid, min(e.salary) as min_sal from employee e group by e.deptid) as tmp where e.salary = min_sal order by e.salary;
select distinct e.name from employee e, (select e.deptid, min(datediff(e.hiredate, curdate())) as most_recent from employee e group by e.deptid) as tmp 
where datediff(e.hiredate, curdate()) = most_recent order by e.hiredate;
select * from employee where year(hiredate) = 1981;
select d.name, count(case when e.hiredate < '1981-05-01' then 1 end) as senior_count, count(case when e.hiredate >= '1981-05-01' then 1 end) as junior_count
from department d join employee e on d.deptid = e.deptid group by d.deptid;

DROP PROCEDURE IF EXISTS getTotSalary;
DELIMITER //
CREATE PROCEDURE getTotSalary(
IN deptName VARCHAR(14)
)
BEGIN
select d.name, sum(e.salary) from department d join employee e on d.deptid = e.deptid where d.name = deptName;
END //
DELIMITER ;

CALL getTotSalary('SALES');