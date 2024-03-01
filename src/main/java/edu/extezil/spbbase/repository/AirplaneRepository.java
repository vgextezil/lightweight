package edu.extezil.spbbase.repository;

import edu.extezil.spbbase.model.Airplane;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends MongoRepository<Airplane, String> {

}
