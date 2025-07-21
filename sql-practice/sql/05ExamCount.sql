--1280. 学生们参加各科测试的次数

--https://leetcode.cn/problems/students-and-examinations/description/?envType=study-plan-v2&envId=sql-free-50

-- Write your PostgreSQL query statement below

-- 关键1：cross join n*m 笛卡尔积
-- 关键2:count(e.subject_name) ->> 不是count(*)

select s.student_id, s.student_name, su.subject_name, count(e.subject_name) as attended_exams
from
    Students s
    cross join Subjects su
    left join Examinations e on s.student_id = e.student_id
    and e.subject_name = su.subject_name
group by
    s.student_id,
    s.student_name,
    su.subject_name
order by s.student_id, su.subject_name, count(e.subject_name) desc