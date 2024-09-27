package com.ling.mapper;

import java.util.List;

import com.ling.entity.Storey;

public interface StoreyMapper {

	public int create(Storey storey);

	public int delete(Integer id);

	public int update(Storey storey);

	public int updateSelective(Storey storey);

	public List<Storey> query(Storey storey);

	public Storey detail(Integer id);

	public int count(Storey storey);

}
