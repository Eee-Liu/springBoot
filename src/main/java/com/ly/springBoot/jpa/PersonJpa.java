package com.ly.springBoot.jpa;

import com.ly.springBoot.domain.PersonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/5/15 11:28
 */
public interface PersonJpa extends JpaRepository<PersonDO,Long>,JpaSpecificationExecutor<PersonDO> {
}
