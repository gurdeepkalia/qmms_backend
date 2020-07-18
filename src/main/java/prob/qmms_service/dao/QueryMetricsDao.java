package prob.qmms_service.dao;


import org.springframework.dao.DataIntegrityViolationException;
import prob.qmms_service.models.Query;
import prob.qmms_service.models.QueryAttributes;
import prob.qmms_service.pojos.QueryInfo;

import javax.persistence.NoResultException;
import java.util.Collection;

public interface QueryMetricsDao {

        public Query getQueryById(String query_id) throws NoResultException;
        public Collection<String> getAllQueryIds();
        public Collection<Query> getAllQueries();
        public void deleteQuery(String query_id) throws NoResultException;
        public void registerQuery(Query query) throws DataIntegrityViolationException;
        public void updateQuery(Query query);
        public Collection<QueryAttributes> getAttributes(String queryId);

   }
