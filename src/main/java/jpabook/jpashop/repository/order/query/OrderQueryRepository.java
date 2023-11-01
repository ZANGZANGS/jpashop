package jpabook.jpashop.repository.order.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {

    private final EntityManager em;

    public List<OrderQueryDto> findOrderQueryDtos() {
        List<OrderQueryDto> result = findOrder();
        result.forEach(o -> {
            List<OrderItemQueryDto> orderItems = findOderItems(o.getOrderId());
            o.setOrderItemQueryDtos(orderItems);
            }
        );

        return result;
    }

    private List<OrderItemQueryDto> findOderItems(Long orderId) {

        return em.createQuery(
                "select new jpabook.jpashop.repository.order.query.OrderItemQueryDto(i.name, oi.orderPrice, oi.count) " +
                        "from OrderItem oi " +
                        "join oi.item i " +
                        "where oi.order.id = :orderId", OrderItemQueryDto.class)
                .setParameter("orderId",orderId)
                .getResultList();
    }

    private List<OrderQueryDto> findOrder() {
        return em.createQuery(
                "select new jpabook.jpashop.repository.order.query.OrderQueryDto( o.id, m.name, o.orderDate, o.status, d.address ) " +
                        "from Order o " +
                        "join o.member m " +
                        "join o.delivery d ", OrderQueryDto.class)
                .getResultList();
    }
}
