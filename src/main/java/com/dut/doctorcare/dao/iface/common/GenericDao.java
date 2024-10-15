package com.dut.doctorcare.dao.iface.common;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface GenericDao<T>{
    Optional<T> findById(UUID id); //throws EntityOperationException;

    List<T> findAll(Map<String, Object> filterParams); //throws EntityOperationException;

    T save(T entity); //throws EntityOperationException;

    T update(T entity); //throws EntityOperationException;

    void delete(T entity); //throws EntityOperationException;
}