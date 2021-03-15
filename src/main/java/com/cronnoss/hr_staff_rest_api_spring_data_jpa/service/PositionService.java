package com.cronnoss.hr_staff_rest_api_spring_data_jpa.service;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Position;

import java.util.List;

public interface PositionService {
    public List<Position> getAllPositions();

    public void savePosition(Position position);

    public Position getPosition(int posid);

    public void deletePosition(int posid);

    public List<Position> findPositionsByPositionName(String positionName);
}