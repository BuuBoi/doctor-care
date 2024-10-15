package com.dut.doctorcare.dao.impl;

import com.dut.doctorcare.dao.AbstractSoftDeleteHibernateDao;
import com.dut.doctorcare.dao.iface.AddressDao;
import com.dut.doctorcare.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateAddressDao extends AbstractSoftDeleteHibernateDao<Address> implements AddressDao {

    public HibernateAddressDao() {
        super(Address.class);
    }

    // Implement additional Address-specific methods here if needed
}