package operators.dao;

import operators.Entity.StatisticEntity;
import operators.blocks.SessionFactorySinglton;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StatisticDaoImpl implements StatisticDao {

    Session session = SessionFactorySinglton.getSessionFactory().openSession();

    @Override
    public void add(StatisticEntity entity) {
            session.getTransaction().begin();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();

    }

    @Override
    public List getAll() {
        Query query = session.createQuery("FROM StatisticEntity ");

        return  query.getResultList();
    }
}
