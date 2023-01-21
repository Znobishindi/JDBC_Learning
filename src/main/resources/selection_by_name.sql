select product_name
from homework.customers c
left join homework.orders o
on c.id = o.customer_id
where c.name = lower(:name);