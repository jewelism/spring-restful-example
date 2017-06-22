package com.daydic.domain.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by megap on 2017-05-13.
 */
@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

}
