--1075. 项目员工 I

--https://leetcode.cn/problems/project-employees-i/description/?envType=study-plan-v2&envId=sql-free-50

-- Write your PostgreSQL query statement below

select project_id , round(sum(e.experience_years::numeric)/count(*),2) as average_years  from Project p inner join Employee  e on p.employee_id  = e.employee_id
group by project_id

-- Write your PostgreSQL query statement below
-- 窗口函数 avg() over()  PARTITION BY project_id

select distinct p.project_id ,
round(AVG(e.experience_years) OVER (PARTITION BY project_id),2) as average_years
 from Project p inner join Employee  e on p.employee_id  = e.employee_id
