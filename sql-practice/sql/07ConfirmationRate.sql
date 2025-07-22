--1934. 确认率

--https://leetcode.cn/problems/confirmation-rate/description/?envType=study-plan-v2&envId=sql-free-50


-- Write your PostgreSQL query statement below

-- 关键1：case when 条件 then 1 else 0 end
-- 关键2：sum(action_count)::numeric / count(*)  注意：sum(action_count)::numeric 不能省略，否则会报错
-- 关键3：round(,2) 保留两位小数
-- 1. 先将Signups和Confirmations表进行左连接，得到一个新的表a
-- 2. 然后对a表进行分组，计算每个user_id的action_count和count(*)
-- 3. 最后对每个user_id的action_count和count(*)进行计算，得到confirmation_rate
-- 4. 注意：如果count(*)为0，则confirmation_rate为0，否则为sum(action_count)::numeric / count(*)
--::numeric 将sum转成numeric类型，否则计算会计算整数类型

--https://geek-docs.com/postgresql/postgresql-top-tutorials/1043104_postgresql_avg_function.html

-- 也可以使用avg函数，但是avg函数会自动将整数类型转换为浮点数类型，所以需要使用::numeric将sum转成numeric类型，否则计算会计算整数类型

with
    a as (
        select
            s.user_id,
            case
                when c.action = 'confirmed' then 1
                else 0
            end action_count
        from Signups s
            left join Confirmations c on s.user_id = c.user_id
    )
select
    user_id,
    case
        when count(*) = 0 then 0
        else ROUND(sum(action_count)::numeric / count(*),2)
    end as confirmation_rate
from a
group by
    user_id