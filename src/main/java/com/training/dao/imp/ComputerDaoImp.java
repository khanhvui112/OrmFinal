package com.training.dao.imp;

import com.training.dao.ComputerDao;
import com.training.entities.Computer;
import com.training.entities.Manufacture;
import com.training.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: VuiSK
 * @created: 08/11/2021-2:28 PM
 * @mailto: sanvankhanh@gmail.com
 */

public class ComputerDaoImp implements ComputerDao {
    @Override
    public List<Computer> findByManufacture(String manufacturerName, Integer status) {
        List<Computer> computerList;
        try(Session session = HibernateUtils.getSession()) {
            //           create criteriaBuilder
            CriteriaBuilder criteria = session.getCriteriaBuilder();
            CriteriaQuery<Computer> query = criteria.createQuery(Computer.class);
            Root<Computer> root = query.from(Computer.class);
            Join<Computer, Manufacture> join = root.join("manufacture", JoinType.INNER);

            Predicate predicate1 = criteria.equal(join.get("fullName"), manufacturerName);
            Predicate predicate2 = criteria.equal(root.get("produceStatus"), status);

//           create query
            query.select(root).where(predicate1, predicate2);

//           exeQuery
            Query candidateQuery = session.createQuery(query);

//           get List candidate database response
            computerList = candidateQuery.getResultList();

//           return list candidates
            return (!computerList.isEmpty() ? computerList : null);
        }
    }

    @Override
    public List<Computer> findByStatus(Integer status, LocalDate date) {
        List<Computer> computerList;
        try(Session session = HibernateUtils.getSession()) {
            //           create criteriaBuilder
            CriteriaBuilder criteria = session.getCriteriaBuilder();
            CriteriaQuery<Computer> query = criteria.createQuery(Computer.class);
            Root<Computer> root = query.from(Computer.class);

            Predicate predicate1 = criteria.equal(root.get("registrationDate"), date);
            Predicate predicate2 = criteria.equal(root.get("produceStatus"), status);

//           create query
            query.select(root).where(predicate1, predicate2);

//           exeQuery
            Query candidateQuery = session.createQuery(query);

//           get List candidate database response
            computerList = candidateQuery.getResultList();

//           return list candidates
            return (!computerList.isEmpty() ? computerList : null);
        }
    }
}
