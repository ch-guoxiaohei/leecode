--1633. 各赛事的用户注册率


--https://leetcode.cn/problems/percentage-of-users-attended-a-contest/description/?envType=study-plan-v2&envId=sql-free-50

-- Write your PostgreSQL query statement below

select r.contest_id, ROUND(COUNT(r.contest_id)::numeric * 100.0 / (SELECT COUNT(*) FROM Users), 2) as percentage
from Register r group by r.contest_id order by percentage desc,r.contest_id asc

