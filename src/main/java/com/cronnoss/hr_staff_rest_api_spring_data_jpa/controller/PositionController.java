package com.cronnoss.hr_staff_rest_api_spring_data_jpa.controller;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Position;
import com.cronnoss.hr_staff_rest_api_spring_data_jpa.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/positions")
    public List<Position> showAllPositions() {
        List<Position> allPositions = positionService.getAllPositions();
        return allPositions;
    }

    @GetMapping("positions/{posid}")
    public Position getPosition(@PathVariable int posid) {
        Position position = positionService.getPosition(posid);
        return position;
    }

    @PostMapping("/positions")
    public Position addNewPosition(@RequestBody Position position) {
        positionService.savePosition(position);
        return position;
    }

    @PutMapping("/positions")
    public Position updatePosition(@RequestBody Position position) {
        positionService.savePosition(position);
        return position;
    }

    @DeleteMapping("/positions/{posid}")
    public String deletePosition(@PathVariable int posid) {
        positionService.deletePosition(posid);
        return "Position with ID = " + posid + " was deleted";
    }

    @GetMapping("/positions/positionName/{positionName}")
    public List<Position> showAllPositionsByPositionName(@PathVariable String positionName) {
        List<Position> positions = positionService.findPositionsByPositionName(positionName);
        return positions;
    }
}