package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Room;
import com.klef.soa.service.RoomService;

@RestController
@RequestMapping("/Room")
public class RoomController {
	@Autowired
	private RoomService service;
	
	@GetMapping("/")
	public String demo()
	{
		return "Spring Boot Project";
	}
	
	@PostMapping("/add")
	public ResponseEntity<Room> addRoom(@RequestBody Room r)
	{
		Room room = service.addRoom(r);
		return ResponseEntity.status(201).body(room);
	}

	@GetMapping("/displayall")
	public ResponseEntity<List<Room>> displayAllRooms()
	{
		List<Room> rooms = service.displayAllRooms();
		return ResponseEntity.status(200).body(rooms);
	}

	@GetMapping("/display/{id}")
	public ResponseEntity<?> displayById(@PathVariable Long id)
	{
		Room room = service.displayById(id);

		if (room != null)
		{
			return ResponseEntity.status(200).body(room);
		}
		else
		{
			return ResponseEntity.status(404).body("Room ID Not Found");
		}
	}

	
	@PutMapping("/update")
	public ResponseEntity<?> updateHostel(@RequestBody Room room)
	{
		Room r = service.updateRoom(room);

		if (r != null)
		{
			return ResponseEntity.ok(r);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room ID not found");
		}
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRoomById(@PathVariable Long id)
	{
		String message = service.deleteRoomById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/displaybytype/{type}")
	public ResponseEntity<List<Room>> displayByType(@PathVariable String type)
	{
		List<Room> rooms = service.findByType(type);
		return ResponseEntity.status(200).body(rooms);
	}
	
	@GetMapping("/displaybyname/{name}")
	public ResponseEntity<List<Room>> displayByName(@PathVariable String name)
	{
		List<Room> rooms = service.findByName(name);
		return ResponseEntity.status(200).body(rooms);
	}
}