package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
	List<Room> findByName(String name);
	List<Room> findByType(String type);
}