package com.metinemre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyGenericRepo<T,ID> extends JpaRepository<T,ID> {

}
