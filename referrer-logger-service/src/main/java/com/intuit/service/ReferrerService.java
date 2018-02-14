package com.intuit.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.dao.ReferrerDao;
import com.intuit.model.Referrer;
import com.intuit.model.ReferrerCount;

@Service
@Transactional
public class ReferrerService {

	@Autowired
	ReferrerDao dao;

	public void save(String url) throws URISyntaxException {
		Referrer referrer = new Referrer();
		referrer.setDomain(getDomainName(url));
		referrer.setTimestamp((System.currentTimeMillis()));
		dao.save(referrer);
	}

	private String getDomainName(String url) throws URISyntaxException {
		URI uri = new URI(url);
		String domain = uri.getHost();
		domain = domain.startsWith("www.") ? domain.substring(4) : domain;
		return domain + uri.getPort();
	}

	public List<ReferrerCount> findTop3Referrars() {
		return top3(dao.findReferrerCount());
	}

	private List<ReferrerCount> top3(List<ReferrerCount> list) {

		if (list.size() <= 3) {
			return list;
		}

		List<ReferrerCount> top3Referrer = new ArrayList<ReferrerCount>();
		for (int i = 0; i < 3; i++) {
			top3Referrer.add(list.get(i));
		}
		return top3Referrer;
	}

}
