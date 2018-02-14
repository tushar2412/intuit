package com.intuit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.intuit.model.Referrer;
import com.intuit.model.ReferrerCount;

@Repository
public interface ReferrerDao extends CrudRepository<Referrer, Long>
{
	Iterable<Referrer> findAllByOrderByTimestampDesc();
	
	@Query(value = "select new com.intuit.model.ReferrerCount(v.domain, count(v)) from Referrer v group by v.domain ORDER by count(v) DESC")
	List<ReferrerCount> findReferrerCount();
}
