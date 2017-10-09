package operators.service;

import operators.Entity.StatisticEntity;
import operators.dao.StatisticDaoImpl;

import java.util.List;

public class StatisticServiceImpl implements StatisticService {

    private StatisticDaoImpl statisticDao = new StatisticDaoImpl();

    @Override
    public void add(StatisticEntity entity) {
        statisticDao.add(entity);
    }

    @Override
    public List getAll() {
        return statisticDao.getAll();
    }

}
