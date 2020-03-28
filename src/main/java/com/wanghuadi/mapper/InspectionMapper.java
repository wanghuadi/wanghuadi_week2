package com.wanghuadi.mapper;

import java.util.List;
import java.util.Map;

import com.wanghuadi.beans.Inspection;

public interface InspectionMapper {
	public void insert(Inspection inspection);
	
	public List<Inspection> queryAll(Map<String,Object> map);

	public Inspection queryById(Integer id);

	public void updateStatus(Map<String, Object> map);
}
