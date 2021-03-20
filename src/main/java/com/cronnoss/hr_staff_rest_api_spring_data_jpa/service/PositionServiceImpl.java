package com.cronnoss.hr_staff_rest_api_spring_data_jpa.service;

import com.cronnoss.hr_staff_rest_api_spring_data_jpa.dao.DepartmentRepository;
import com.cronnoss.hr_staff_rest_api_spring_data_jpa.dao.PositionRepository;
import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Department;
import com.cronnoss.hr_staff_rest_api_spring_data_jpa.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public void savePosition(Position position) {
        Department dept = departmentRepository.findById(position.getDepartment().getDepid()).orElse(null);
        if (null == dept) {
            dept = new Department();
        }
        dept.setDepartmentName(position.getDepartment().getDepartmentName());
        dept.addPositionToDepartment(position);
//        position.setDepartment(dept);
        positionRepository.save(position);
    }

    @Override
    public Position getPosition(int posid) {
        Position position = null;
        Optional<Position> optional = positionRepository.findById(posid);
        if (optional.isPresent()) {
            position = optional.get();
        }
        return position;
    }

    @Override
    public void deletePosition(int posid) {
        positionRepository.deleteById(posid);
    }

    @Override
    public List<Position> findPositionsByPositionName(String positionName) {
        List<Position> positions = positionRepository.findPositionsByPositionName(positionName);
        return positions;
    }
}