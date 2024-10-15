package com.dut.doctorcare.dao.impl;

import com.dut.doctorcare.dao.AbstractSoftDeleteHibernateDao;
import com.dut.doctorcare.dao.iface.ReviewDao;
import com.dut.doctorcare.model.Review;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateReviewDao extends AbstractSoftDeleteHibernateDao<Review> implements ReviewDao {

    public HibernateReviewDao() {
        super(Review.class);
    }

    // Implement additional Review-specific methods here if needed

}
