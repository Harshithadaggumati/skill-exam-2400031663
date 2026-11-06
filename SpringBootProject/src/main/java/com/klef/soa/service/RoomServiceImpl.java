package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Room;
import com.klef.soa.repository.RoomRepository;

@Service
public class RoomServiceImpl  implements RoomService{
	@Autowired
	private RoomRepository repo;

	@Override
	public Room addRoom(Room r) {
		// TODO Auto-generated method stub
		return repo.save(r);
	}

	@Override
	public Room updateRoom(Room r) {
		// TODO Auto-generated method stub
		Optional<Room> optional = repo.findById(r.getId());
		if(optional.isPresent())
		{
			Room room = optional.get();
			
			room.setName(r.getName());
			room.setType(r.getType());
			room.setStatus(r.getStatus());
			
			return repo.save(room);
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public String deleteRoomById(Long id) {
		// TODO Auto-generated method stub
		boolean flag = repo.existsById(id);
		if(flag)
		{
			repo.deleteById(id);
			return "Room deleted successfully";
			
		}
		else
		{
			return "Room ID not found";
		}
	}


	@Override
	public List<Room> displayAllRooms() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	@Override
	public Room displayById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Room> findByType(String type) {
		// TODO Auto-generated method stub
		return repo.findByType(type);
	}

	@Override
	public List<Room> findByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

}
