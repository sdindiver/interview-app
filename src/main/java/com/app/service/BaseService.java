package com.app.service;

import java.util.List;

import javax.persistence.EntityManager;

public class BaseService {

	protected EntityManager em;

	protected void getVoilation(List<?> $data,List<?> $rules,List<?> $options){
		/**
	     * Validate data and get violations (if any)
	     *
	     * @param array $data which contains data to validate
	     * @param array $rules Specifies which keys in data and how to validate. All keys will be validated by default.
	     * @param array $options Additional options to use during validation
	     * @return ConstraintViolationListInterface
	     */
	}
	
}
