# Write your MySQL query statement below
select round(count(distinct a.player_id) / 
    (select count(distinct player_id) from Activity), 2) as fraction 
    from Activity a
join 
(select player_id, min(event_date) as first_date
from Activity group by player_id) b
on a.player_id = b.player_id
and a.event_date = date_add(b.first_date, interval 1 day);