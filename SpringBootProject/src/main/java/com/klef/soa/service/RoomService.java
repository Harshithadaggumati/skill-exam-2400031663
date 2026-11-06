package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Room;

public interface RoomService {
	Room addRoom(Room r);
	Room updateRoom(Room r);
	String deleteRoomById(Long id);
	Room displayById(Long id);
	List<Room> displayAllRooms();
	List<Room> findByType(String type);
	List<Room> findByName(String name);

}
