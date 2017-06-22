package com.daydic.domain.article;

import com.daydic.domain.common.DayDicRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kusob on 2017. 5. 12..
 */
@Repository
public interface ArticleRepository extends DayDicRepository<Article, Long>{
}

