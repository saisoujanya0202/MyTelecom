package com.mytelecom.repository;

import com.mytelecom.repository.entity.MyTelecomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyTelecomUser, String> {

}
