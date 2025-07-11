197. 上升的温度

 SQL Schema
 Pandas Schema
 表： Weather

 +---------------+---------+
 | Column Name   | Type    |
 +---------------+---------+
 | id            | int     |
 | recordDate    | date    |
 | temperature   | int     |
 +---------------+---------+
 id 是该表具有唯一值的列。
 没有具有相同 recordDate 的不同行。
 该表包含特定日期的温度信息


 编写解决方案，找出与之前（昨天的）日期相比温度更高的所有日期的 id 。

 返回结果 无顺序要求 。

 结果格式如下例子所示。

 示例 1：

 输入：
 Weather 表：
 +----+------------+-------------+
 | id | recordDate | Temperature |
 +----+------------+-------------+
 | 1  | 2015-01-01 | 10          |
 | 2  | 2015-01-02 | 25          |
 | 3  | 2015-01-03 | 20          |
 | 4  | 2015-01-04 | 30          |
 +----+------------+-------------+
 输出：
 +----+
 | id |
 +----+
 | 2  |
 | 4  |
 +----+
 解释：
 2015-01-02 的温度比前一天高（10 -> 25）
 2015-01-04 的温度比前一天高（20 -> 30）


 # 思路，可以使用自查询，我使用的是子查询

-- Write your PostgreSQL query statement below

with
    yesterday as (
        select w.*, w.recordDate - INTERVAL '1 day' as recordDate_yesterday
        from Weather w
    )
select yesterday.id as "Id"
from Weather wi
    inner join yesterday on wi.recordDate = yesterday.recordDate_yesterday
where
    wi.temperature < yesterday.

