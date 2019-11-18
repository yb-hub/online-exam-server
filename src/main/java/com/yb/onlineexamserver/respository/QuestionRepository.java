package com.yb.onlineexamserver.respository;

import com.yb.onlineexamserver.mbg.model.Question;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Auther: Yang
 * @Date: 2019/11/18 11:14
 * @Description:
 */
public interface QuestionRepository extends ElasticsearchRepository<Question,String> {
}
