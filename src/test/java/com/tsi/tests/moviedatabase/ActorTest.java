package com.tsi.tests.moviedatabase;
import com.TSI.MovieDatabase.ActorRepository;
import com.TSI.MovieDatabase.Actor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Component
public class ActorTest {
    @Autowired
    private ActorRepository actorRepository;

    Optional<Actor> testActor = actorRepository.findById(1);

    @Test
    @Autowired
    public void isTheIdCorrect(){
    //Actor 201 is called Wawrence Lhite


        assertEquals("Wawrence Lhite",testActor.get().getFirstName() + " " + testActor.get().getLastName(),"The actor's name is incorrect");

    }
}
