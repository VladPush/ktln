package operators.dao;

import operators.Entity.StatisticEntity;

import java.util.List;

public interface StatisticDao {
    void add(StatisticEntity entity);
    List getAll( );
}
