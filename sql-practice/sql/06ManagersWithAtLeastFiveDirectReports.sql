--570. 至少有5名直接下属的经理

--https://leetcode.cn/problems/managers-with-at-least-5-direct-reports/description/?envType=study-plan-v2&envId=sql-free-50

-- Write your PostgreSQL query statement below

select e.name
from Employee e
    inner join Employee ee on e.id = ee.managerId
group by
    e.name,
    e.id
having
    count(ee.managerId) >= 5