package com.TSI.MovieDatabase;


import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorTest {

  @Test
  void actorIdTest(){
      Actor testActor1 = new Actor();
      testActor1.setActorId(1);
      assertEquals(1,testActor1.getActorId());
  }
    @Test
    void actorFirstNameTest(){
        Actor testActor1 = new Actor();
        testActor1.setFirstName("John");
        assertEquals("John",testActor1.getFirstName());
    }
    @Test
    void actorLastNameTest(){
        Actor testActor1 = new Actor();
        testActor1.setLastName("Doe");
        assertEquals("Doe",testActor1.getLastName());
    }


}
