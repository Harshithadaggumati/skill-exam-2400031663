package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Room;
import com.klef.soa.repository.RoomRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoomRepositoryTest {

    @Autowired
    private RoomRepository repository;

    @Test
    void testFindAllRooms() {
        List<Room> rooms = repository.findAll();
        assertNotNull(rooms);
        System.out.println("Total Rooms: " + rooms.size());
    }

    @Test
    void testFindRoomById() {
        Optional<Room> room = repository.findById(1L);
        assertTrue(room.isPresent());
        assertEquals(1L, room.get().getId());
        System.out.println("Room Name: " + room.get().getName());
    }

    @Test
    void testFindRoomByInvalidId() {
        Optional<Room> room = repository.findById(9999L);
        assertFalse(room.isPresent());
    }

    @Test
    void testFindRoomByName() {
        List<Room> rooms = repository.findByName("Deluxe");
        assertNotNull(rooms);
        for (Room room : rooms) {
            assertEquals("Deluxe", room.getName());
        }
    }

    @Test
    void testFindRoomByType() {
        List<Room> rooms = repository.findByType("AC");
        assertNotNull(rooms);
        for (Room room : rooms) {
            assertEquals("AC", room.getType());
        }
    }

    @Test
    void testRoomCount() {
        long count = repository.count();
        assertTrue(count >= 0);
        System.out.println("Total Rooms in Database: " + count);
    }

    @Test
    void testRoomDetails() {
        Optional<Room> room = repository.findById(1L);
        assertTrue(room.isPresent());

        Room foundRoom = room.get();

        assertNotNull(foundRoom.getName());
        assertNotNull(foundRoom.getType());
        assertNotNull(foundRoom.getLocation());

        System.out.println("Name: " + foundRoom.getName());
        System.out.println("Type: " + foundRoom.getType());
        System.out.println("Location: " + foundRoom.getLocation());
    }
}


