package org.launchcode.Ch15Lecture.data;

import org.launchcode.Ch15Lecture.models.Dinosaur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinosaurRepository extends CrudRepository<Dinosaur, Integer> {
}
