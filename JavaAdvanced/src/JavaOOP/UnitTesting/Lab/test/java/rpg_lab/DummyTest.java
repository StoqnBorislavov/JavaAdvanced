package JavaOOP.UnitTesting.Lab.test.java.rpg_lab;

import JavaOOP.UnitTesting.Lab.java.rpg_lab.Dummy;
import org.junit.Before;
import org.junit.Test;

import static kotlin.test.AssertionsKt.assertEquals;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DummyTest {
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 100;
    private static final int ATTACK_POINTS = 10;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.deadDummy = new Dummy(0, DUMMY_EXPERIENCE);
    }

    @Test
    public void testDummyLosesHealthWhenAttacked() {
        dummy.takeAttack(ATTACK_POINTS);
        assertEquals(DUMMY_HEALTH-ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyCanNotBeAttacked() {
        deadDummy.takeAttack(10);
    }

    @Test
    public void testDeadDummyGivesExperience() {
        assertEquals(100, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyShouldNotGiveExperience() {
        dummy.giveExperience();
    }

}