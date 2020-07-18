package prob.qmms_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import prob.qmms_service.dao.QueryMetricsDao;
import prob.qmms_service.models.Query;
import prob.qmms_service.models.QueryAttributes;
import prob.qmms_service.pojos.QueryInfo;
import prob.qmms_service.utils.ConvertorUtil;

import java.util.*;

@CrossOrigin
@Component
@ResponseBody
@RequestMapping("/queries")
public class QueryController {

    @Autowired
    QueryMetricsDao queryDao;



   @GetMapping("/{query_id}")
    public QueryInfo getQueryById(@PathVariable String query_id){
           // return new ResponseEntity<QueryInfo>(ConvertorUtil.modelToPojoConvertor(queryDao.getQueryById(query_id)), HttpStatus.OK);
       return ConvertorUtil.modelToPojoConvertor(queryDao.getQueryById(query_id));
   }

   @GetMapping("/ids")
   public ResponseEntity<Collection<String>> getAllQueryIds(){
       return new ResponseEntity<Collection<String>>(queryDao.getAllQueryIds(),HttpStatus.OK);
   }

    @GetMapping("/")
    public ResponseEntity<Collection<QueryInfo>> getAllQueries(){
       Collection<Query> queries = queryDao.getAllQueries();
       Collection<QueryInfo> queryInfos=new ArrayList<>();
       for(Query query : queries){
           queryInfos.add(ConvertorUtil.modelToPojoConvertor(query));
       }
        return new ResponseEntity<Collection<QueryInfo>>(queryInfos,HttpStatus.OK);
    }



    @DeleteMapping("/{query_id}")
    @Transactional
   public ResponseEntity<?> deleteQuery(@PathVariable String query_id){
        queryDao.deleteQuery(query_id);
        return ResponseEntity.status(HttpStatus.OK).build();
   }


    @PostMapping("/")
    @Transactional
    public ResponseEntity<?> registerQuery(@RequestBody QueryInfo queryInfo){
       queryDao.registerQuery(ConvertorUtil.pojoToModelConvertor(queryInfo,new Query()));
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{query_id}")
    @Transactional
    public ResponseEntity<?> updateQuery(@RequestBody QueryInfo queryInfo , @PathVariable String query_id){
        Query query = ConvertorUtil.pojoToModelConvertor(queryInfo,queryDao.getQueryById(query_id));
        queryDao.updateQuery(query);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{queryId}/sqs")
    public ResponseEntity<Map<String,Map<String,String>>> getSQS(@PathVariable String queryId){
        Collection<QueryAttributes> attributes = queryDao.getAttributes(queryId);
        Map<String,Map<String,String>> outerMap = new HashMap<>();

        Map<String,String> envUuidInnerMap = new HashMap<>();
        envUuidInnerMap.put("mapped-name","env-uuid");
        outerMap.put("ENV_UUID",envUuidInnerMap);

        Map<String,String> envIdInnerMap = new HashMap<>();
        envIdInnerMap.put("mapped-name","env-id");
        outerMap.put("ENV_ID",envIdInnerMap);

        attributes.forEach((att)->{
            Map<String,String> innerMap = new HashMap<>();
            innerMap.put("mapped-name",att.getQueryAttribute().toUpperCase());
            outerMap.put(att.getQueryAttribute().toUpperCase(),innerMap);
        });

        Map<String,String> eventTimeInnerMap = new HashMap<>();
        eventTimeInnerMap.put("mapped-name","event-time");
        outerMap.put("EVENT_TIME",eventTimeInnerMap);

        return new ResponseEntity<Map<String,Map<String,String>>>(outerMap,HttpStatus.OK);

    }




}
