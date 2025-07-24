--1633. 各赛事的用户注册率


--https://leetcode.cn/problems/percentage-of-users-attended-a-contest/description/?envType=study-plan-v2&envId=sql-free-50

-- Write your PostgreSQL query statement below

select r.contest_id, ROUND(COUNT(r.contest_id)::numeric * 100.0 / (SELECT COUNT(*) FROM Users), 2) as percentage
from Register r group by r.contest_id order by percentage desc,r.contest_id asc

-- AI 给出的解题办法性能更好

--优化说明：
--
--使用CTE (WITH子句)预先计算总用户数，避免对Users表的重复扫描
--使用CROSS JOIN替代子查询，PostgreSQL优化器通常能更好地处理这种连接方式
--简化了COUNT(r.contest_id)为COUNT(*)，因为GROUP BY已经确保了contest_id非空
--使用MAX(uc.total)获取总用户数，因为CROSS JOIN会使这个值在每行都出现
--如果Register表很大，建议在contest_id列上创建索引：

WITH user_count AS (
  SELECT COUNT(*) AS total FROM Users
)
SELECT
  r.contest_id,
  ROUND(COUNT(*) * 100.0 / MAX(uc.total), 2) AS percentage
FROM
  Register r
CROSS JOIN
  user_count uc
GROUP BY
  r.contest_id
ORDER BY
  percentage DESC,
  r.contest_id ASC;