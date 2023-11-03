package jpabook.jpashop.repository.order.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                "select new jpabook.jpashop.repository.order.query.OrderItemQueryDto(oi.order.id, i.name, oi.orderPrice, oi.count) " +
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

    public List<OrderQueryDto> findAllByDto_optimization() {
        List<OrderQueryDto> result = findOrder();

        List<Long> orderIds = toOrderId(result);

        Map<Long, List<OrderItemQueryDto>> listMap = findOrderItemMap(orderIds);

        result.forEach(o ->o.setOrderItemQueryDtos(listMap.get(o.getOrderId())));

        return result;
    }

    private Map<Long, List<OrderItemQueryDto>> findOrderItemMap(List<Long> orderIds) {
        List<OrderItemQueryDto> orderItemQueryDtos = em.createQuery(
                        "select new jpabook.jpashop.repository.order.query.OrderItemQueryDto(oi.order.id, i.name, oi.orderPrice, oi.count) " +
                                "from OrderItem oi " +
                                "join oi.item i " +
                                "where oi.order.id in :orderIds", OrderItemQueryDto.class)
                .setParameter("orderIds", orderIds)
                .getResultList();

        Map<Long, List<OrderItemQueryDto>> listMap = orderItemQueryDtos.stream()
                .collect(Collectors.groupingBy(OrderItemQueryDto::getOrderId));
        return listMap;
    }

    private List<Long> toOrderId(List<OrderQueryDto> result) {
        List<Long> orderIds = result.stream().map(OrderQueryDto::getOrderId)
                .collect(Collectors.toList());
        return orderIds;
    }
}
