package org.launchcode.Ch15Lecture.data;

import org.launchcode.Ch15Lecture.models.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends CrudRepository<Color, Integer> {
}
