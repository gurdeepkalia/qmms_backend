package prob.qmms_service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import prob.qmms_service.models.Query;
import prob.qmms_service.models.QueryAttributes;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.*;

@Repository
public class QueryMetricsDaoImpl implements QueryMetricsDao {

    @Autowired
    private EntityManager em;

    @Override
    public Query getQueryById(String query_id) throws NoResultException {
        Optional<Query> query = Optional.ofNullable(em.find(Query.class,query_id));
        if(query.isPresent()){
            return query.get();
        }
        else {
            throw new NoResultException("Query with id " +query_id +" not found");
        }
    }

    @Override
    public Collection<String> getAllQueryIds() {
        String jpql = "select q.queryId from Query q";
        ArrayList ids = (ArrayList) em.createQuery(jpql).getResultList();
        return ids;
    }

    @Override
    public Collection<Query> getAllQueries() {
        String jpql = "select q from Query q";
        ArrayList queries = (ArrayList) em.createQuery(jpql).getResultList();
        return queries;
    }

    @Override
    public void deleteQuery(String query_id) {
        Optional<Query> query = Optional.ofNullable(em.find(Query.class,query_id));
        if(query.isPresent()){
            em.remove(query.get());
        }else
        {
            throw new NoResultException("Query with id " +query_id +" not found");
        }
    }

    @Override
    public void registerQuery(Query query) throws DataIntegrityViolationException {
        query.setInsDate(new Date(System.currentTimeMillis()));
        em.persist(query);
    }

    @Override
    public void updateQuery(Query query) {
        em.merge(query);
    }

    @Override
    public Collection<QueryAttributes> getAttributes(String queryId) {
        Query q = em.find(Query.class,queryId);
        return q.getAttributes();
    }
}
