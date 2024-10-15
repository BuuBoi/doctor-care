package com.dut.doctorcare.dao.iface.common;

import com.dut.doctorcare.exception.EntityOperationException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface SoftDeleteDao<T> {
    void softDelete(UUID id) throws EntityOperationException;

    void restoreFromSoftDelete(UUID id) throws EntityOperationException;

    Optional<T> findByIdIncludingDeleted(UUID id) throws EntityOperationException;

    List<T> findAllIncludingDeleted(Map<String, Object> filterParams) throws EntityOperationException;
}