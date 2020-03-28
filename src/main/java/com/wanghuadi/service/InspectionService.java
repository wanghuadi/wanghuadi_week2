package com.wanghuadi.service;

import java.util.List;
import java.util.Map;

import com.wanghuadi.beans.Inspection;

public interface InspectionService {
	public List<Inspection> queryAll(Map<String,Object> map);

	public Inspection queryById(Integer id);

	public void updateStatus(Map<String, Object> map);
}
