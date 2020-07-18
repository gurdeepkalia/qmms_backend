package prob.qmms_service.utils;

import prob.qmms_service.models.Query;
import prob.qmms_service.models.QueryAttributes;
import prob.qmms_service.pojos.QueryAttributeInfo;
import prob.qmms_service.pojos.QueryInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ConvertorUtil {

    public static QueryInfo modelToPojoConvertor(Query query){
        QueryInfo queryInfo = new QueryInfo();
        queryInfo.setQueryId(query.getQueryId());
        queryInfo.setQuery(query.getQuery());
        queryInfo.setFreq(query.getFreq());
        queryInfo.setInsDate(query.getInsDate());
        queryInfo.setOptyVer(query.getOptyVer());
        queryInfo.setStatus(query.getStatus());
        queryInfo.setUpdDate(query.getUpdDate());

        Collection<QueryAttributeInfo> attInfos = queryInfo.getAttributes();
        query.getAttributes().stream().map(ConvertorUtil::queryAttributeModelToPojoConvertor).forEach(attInfos::add);
        return queryInfo;
    }

    public static QueryAttributeInfo queryAttributeModelToPojoConvertor(QueryAttributes att){
        QueryAttributeInfo attInfo = new QueryAttributeInfo();
        attInfo.setQueryAttribute(att.getQueryAttribute());
        attInfo.setAttributeDatatype(att.getAttributeDatatype());
        attInfo.setColumnNumber(att.getColumnNumber());
        return attInfo;
    }

    public static Query pojoToModelConvertor(QueryInfo queryInfo , Query query){
        query.setQueryId(queryInfo.getQueryId());
        query.setQuery(queryInfo.getQuery());
        query.setFreq(queryInfo.getFreq());
        query.setOptyVer(queryInfo.getOptyVer());
        query.setStatus(queryInfo.getStatus());
        query.setUpdDate(new Date(System.currentTimeMillis()));

        Collection<QueryAttributes> atts = new ArrayList<>();
        queryInfo.getAttributes().stream().map(ConvertorUtil::queryAttributePojoToModelConvertor).forEach(att -> {
            att.setQuery(query);
            atts.add(att);
        });
        return query;
    }

    public static QueryAttributes queryAttributePojoToModelConvertor(QueryAttributeInfo attInfo){
        QueryAttributes att = new QueryAttributes();
        att.setQueryAttribute(attInfo.getQueryAttribute());
        att.setAttributeDatatype(attInfo.getAttributeDatatype());
        att.setColumnNumber(attInfo.getColumnNumber());
        return att;
    }


}
