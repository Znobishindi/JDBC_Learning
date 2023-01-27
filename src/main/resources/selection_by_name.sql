SELECT o.productName
from Orders o
         join Customers c on c.id = o.customer.id
where c.name = :name