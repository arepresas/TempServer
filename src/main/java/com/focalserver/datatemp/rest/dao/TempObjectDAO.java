package com.focalserver.datatemp.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.focalserver.datatemp.rest.models.TempObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempObjectDAO extends JpaRepository<TempObject, Long> {

    public List<TempObject> findByLocalDateTimeContainingOrderByDataIdDesc(String date);



}
