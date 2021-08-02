package JavaOOP.UnitTesting.Lab.java.rpg_lab;

public interface Target {
    public int getHealth();

    public void takeAttack(int attackPoints);

    public int giveExperience();

    public boolean isDead();

    Weapon getLoot();
}
