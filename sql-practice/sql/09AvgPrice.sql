--1251. 平均售价

--https://leetcode.cn/problems/average-selling-price/description/?envType=study-plan-v2&envId=sql-free-50

-- Write your PostgreSQL query statement below

select p.product_id, case when sum(u.units) is null then 0 else
ROUND(sum(p.price * u.units)::numeric / sum(u.units),2) end as average_price   from Prices  p left join UnitsSold  u on
u.product_id = p.product_id
and u.purchase_date>=p.start_date and purchase_date<=p.end_date
group by p.product_id

-- COALESCE 函数 类似mysql ifnull函数

-- Write your PostgreSQL query statement below

select p.product_id, COALESCE(ROUND(sum(p.price * u.units)::numeric / sum(u.units),2),0) as average_price
   from Prices  p left join UnitsSold  u on
u.product_id = p.product_id
and u.purchase_date>=p.start_date and purchase_date<=p.end_date
group by p.product_id

