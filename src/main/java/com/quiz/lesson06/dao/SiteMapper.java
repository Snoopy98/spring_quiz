package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Site;

@Repository
public interface SiteMapper {

	public List<Site> selectSiteList(Site site);
	
	public void insertSite(
			@Param("name")String domain,
			@Param("url") String url);
}
