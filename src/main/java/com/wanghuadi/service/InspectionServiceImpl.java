package com.wanghuadi.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wanghuadi.beans.Inspection;
import com.wanghuadi.mapper.InspectionMapper;

@Service
public class InspectionServiceImpl implements InspectionService{
	
	@Resource
	private InspectionMapper inspectionMapper;

	public List<Inspection> queryAll(Map<String, Object> map) {
		return inspectionMapper.queryAll(map);
	}

	public Inspection queryById(Integer id) {
		return inspectionMapper.queryById(id);
	}

	public void updateStatus(Map<String, Object> map) {
		inspectionMapper.updateStatus(map);
	}

}
