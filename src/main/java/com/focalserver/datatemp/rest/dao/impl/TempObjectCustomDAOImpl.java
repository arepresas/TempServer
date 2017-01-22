package com.focalserver.datatemp.rest.dao.impl;

import com.focalserver.datatemp.rest.dao.TempObjectCustomDAO;
import com.focalserver.datatemp.rest.models.QTempObject;
import com.focalserver.datatemp.rest.models.TempObject;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by arepresas on 8/01/17.
 */
public abstract class TempObjectCustomDAOImpl implements TempObjectCustomDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TempObject> localDateTime(String date) {

        QTempObject tempObject = QTempObject.tempObject;
        JPAQuery<?> query = new JPAQuery<Void>(entityManager);
        JPAQuery<TempObject> tempObjects = query.select(tempObject)
                .from(tempObject)
                .where(tempObject.localDateTime.contains(date))
                .fetchAll();

        return null;
    }
}
