package es.uniovi.asw.dbmanagement.business.impl;

import es.uniovi.asw.dbmanagement.business.exception.BusinessException;

public interface Command<T> {
    T execute() throws BusinessException;
}
