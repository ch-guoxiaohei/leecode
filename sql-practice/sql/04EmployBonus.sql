--577. 员工奖金
--
--https://leetcode.cn/problems/employee-bonus/description/?envType=study-plan-v2&envId=sql-free-50

-- Write your PostgreSQL query statement below

select e .name,b.bonus from Employee e left join Bonus b on e.empId = b.empId
where b.bonus<1000 or b.bonus is null;