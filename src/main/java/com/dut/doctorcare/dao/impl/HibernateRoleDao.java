package com.dut.doctorcare.dao.impl;

import com.dut.doctorcare.dao.AbstractSoftDeleteHibernateDao;
import com.dut.doctorcare.dao.iface.RoleDao;
import com.dut.doctorcare.model.Role;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateRoleDao extends AbstractSoftDeleteHibernateDao<Role> implements RoleDao {

    public HibernateRoleDao() {
        super(Role.class);
    }

    // Implement additional Role-specific methods here if needed

    @Override
    public Role findRole(Role.RoleName roleName) {
        return getCurrentSession().createQuery("from Role where roleName = :roleName", Role.class)
                .setParameter("roleName", roleName)
                .uniqueResult();
    }

    @Override
    public Role createRole(Role.RoleName roleName) {
        // Tìm role dựa trên roleName
        String hql = "FROM Role WHERE roleName = :roleName";
        Query<Role> query = getCurrentSession().createQuery(hql, Role.class);
        query.setParameter("roleName", roleName);
        Role existingRole = query.uniqueResult();

        // Nếu role đã tồn tại, trả về role đó
        if (existingRole != null) {
            return existingRole;
        }

        // Nếu role chưa tồn tại, thêm mới role
        Role newRole = new Role();
        newRole.setRoleName(roleName);
        getCurrentSession().save(newRole); // Lưu vào database
        return newRole; // Trả về role mới tạo
    }
}
