package operators.service;

import operators.Entity.StatisticEntity;

import java.util.List;

public interface StatisticService {
    void add(StatisticEntity entity);
    List getAll();
}
