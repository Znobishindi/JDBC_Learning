package com.example.jdbc_learning.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Component
public class AfterStartSettings {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional


    @EventListener(ApplicationReadyEvent.class)
    public void fillInTheTable() {

        var order1 = Orders.builder()
                .timeStamp(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime()))
                .productName("Молоко")
                .amount(50.45)
                .build();

        var order2 = Orders.builder()
                .timeStamp(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime()))
                .productName("Пряники")
                .amount(70.28)
                .build();
        var order3 = Orders.builder()
                .timeStamp(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime()))
                .productName("Пиво")
                .amount(85.50)
                .build();

        var customer1 = Customers.builder()
                .name("Ivan")
                .surname("Pronin")
                .age(45)
                .phoneNumber("+74168168163")
                .build();

        var customer2 = Customers.builder()
                .name("Denis")
                .surname("Vasin")
                .age(54)
                .phoneNumber("+748681163")
                .build();
        var customer3 = Customers.builder()
                .name("Svetlana")
                .surname("Zimina")
                .age(45)
                .phoneNumber("+741888163")
                .build();

        List<Customers> customersList = List.of(customer1, customer2, customer3);
        customersList.forEach(entity->entityManager.persist(entity));

        customer1.setOrdersList(List.of(order3,order1));
        entityManager.persist(order3);
        entityManager.persist(order1);
        customer2.setOrdersList(List.of(order2));
        entityManager.persist(order2);



    }
}
