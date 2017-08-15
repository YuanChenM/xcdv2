package com.bms.slim.bean;

import com.framework.base.rest.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>更新SQL中parameterType对应的参数类型。</p>
 */
public class UpdateEntity<E extends BaseEntity, T extends BaseTarget> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** 更新实体*/
	private E entity;
	
	/** 更新实体集合*/
	private List<E> entities;
	
	/** 更新字段对象 */
	private T target;

	/** <字段名, 是否更新(true：更新，false：不更新)> */
	private Map<String, Boolean> targetMap;

	public E getEntity() {
		return entity;
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}

	public List<E> getEntities() {
		return entities;
	}

	public void setEntities(List<E> entities) {
		this.entities = entities;
	}

	public T getTarget() {
		return target;
	}

	public void setTarget(T target) {
		this.target = target;
	}

	public Map<String, Boolean> getTargetMap() {
		return targetMap;
	}

	public void setTargetMap(Map<String, Boolean> targetMap) {
		this.targetMap = targetMap;
	}
}
