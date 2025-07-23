--620. 有趣的电影
--https://leetcode.cn/problems/not-boring-movies/description/?envType=study-plan-v2&envId=sql-free-50

select *
from cinema
where (
        description != 'boring'
        or description is null
    )
    and id % 2 != 0
order by rating desc;


--select * from cinema where (description!='boring' or description is null) and mod(id,2) !=0 order by rating desc;