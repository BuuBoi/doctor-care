package com.dut.doctorcare.dao.iface;

import com.dut.doctorcare.dao.iface.common.GenericDao;
import com.dut.doctorcare.dao.iface.common.SoftDeleteDao;
import com.dut.doctorcare.model.Address;

public interface AddressDao extends GenericDao<Address>, SoftDeleteDao<Address> {
    // Implement additional Address-specific methods here if needed
}
