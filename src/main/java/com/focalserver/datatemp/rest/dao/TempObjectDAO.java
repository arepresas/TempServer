package com.focalserver.datatemp.rest.dao;

import com.focalserver.datatemp.rest.models.TempObject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempObjectDAO extends JpaRepository<TempObject, Long> {

    public List<TempObject> findByLocalDateTimeContainingOrderByDataIdDesc(String date);

}
