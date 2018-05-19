package com.ly.springBoot.jpa;

import com.ly.springBoot.domain.SystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: LiuYi
 * @Description: 因为SpringBoot以及SpringDataJPA会为我们全部搞定，SpringDataJPA内部使用了类代理的方式让继承了它接口的子接口都以spring管理的Bean的形式存在，也就是说我们可以直接使用@Autowired注解在spring管理bean使用
 * @Date: Created in 2018/5/9 15:38
 */
public interface SystemJpa extends JpaRepository<SystemEntity, Long> ,JpaSpecificationExecutor<SystemEntity> {
    @Query(value = "select * from system  where system_code = ?1",nativeQuery = true)
    SystemEntity queryByCode(String code);
}
