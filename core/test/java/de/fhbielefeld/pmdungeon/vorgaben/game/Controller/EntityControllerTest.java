package de.fhbielefeld.pmdungeon.vorgaben.game.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import de.fhbielefeld.pmdungeon.vorgaben.graphic.Animation;
import de.fhbielefeld.pmdungeon.vorgaben.tools.Point;


import de.fhbielefeld.pmdungeon.vorgaben.dungeonCreator.DungeonWorld;
import de.fhbielefeld.pmdungeon.vorgaben.interfaces.IAnimatable;
import de.fhbielefeld.pmdungeon.vorgaben.interfaces.IEntity;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class EntityControllerTest {

public abstract class Character implements IEntity, IAnimatable {

    protected Point position;

    protected DungeonWorld level;

    protected float movementSpeed;

    protected Animation currentAnimation;

    protected int maxLifepoints;

    protected int currentLifepoints;

    protected int dmg;


    public Character(float movementspeed, int maxLifepoints, int dmg) {
        this.movementSpeed = movementspeed;
        this.maxLifepoints = maxLifepoints;
        this.currentLifepoints = maxLifepoints;
        this.dmg = dmg;
    }

    protected abstract Point move();

    public void updateLevel(DungeonWorld level) {
        this.level = level;
        this.updatePosition();
    }

    public void updatePosition() {
        this.position = level.getRandomPointInDungeon();
    }

    public int getCurrentLifepoints() {
        return this.currentLifepoints;
    }

    public int getDmg() {
        return this.dmg;
    }

    public void takeDmg(int dmg) {
        this.currentLifepoints -= dmg;

    }

    public void heal(int healValue) {
        this.currentLifepoints = Math.min(this.maxLifepoints, this.currentLifepoints + healValue);
    }

    @Override
    public void update() {
    }

    @Override
    public Animation getActiveAnimation() {
        return this.currentAnimation;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public boolean deleteable() {
        return this.currentLifepoints <= 0;
    }
}

    public class MyHero extends Character {
    
        private Animation idleRight;
        private Animation idleLeft;
        private Animation runRight;
        private Animation runLeft;
        private Animation nextIdleAnimation;
        private Animation nextRunAnimation;
    
        public MyHero(float movementspeed, int maxLifepoints, int dmg) {
            super(movementspeed, maxLifepoints, dmg);
            this.setupAnimations();
            this.currentAnimation = this.idleRight;
            this.nextIdleAnimation = this.currentAnimation;
            this.nextRunAnimation = this.runRight;
        }
    
        private void setupAnimations() {}
    
        @Override
        public void takeDmg(int dmg) {
            this.currentLifepoints -= dmg;
            System.out.println("AUA! " + this.currentLifepoints + " HP left");
        }
    
        @Override
        public Point move() {
            Point newPosition = new Point(this.position);
            return this.position;
        }
    
    
    }

    public class MyHero2 extends Character {
    
        private Animation idleRight;
        private Animation idleLeft;
        private Animation runRight;
        private Animation runLeft;
        private Animation nextIdleAnimation;
        private Animation nextRunAnimation;
    
        public MyHero2(float movementspeed, int maxLifepoints, int dmg) {
            super(movementspeed, maxLifepoints, dmg);
            this.setupAnimations();
            this.currentAnimation = this.idleRight;
            this.nextIdleAnimation = this.currentAnimation;
            this.nextRunAnimation = this.runRight;
        }
    
        private void setupAnimations() {}
    
        @Override
        public void takeDmg(int dmg) {}
    
        @Override
        public Point move() {
            Point newPosition = new Point(this.position);
            return this.position;
        }
    
    
    }
    EntityController ec;

    @BeforeEach
    public void init() {
        ec = new EntityController();
    }

    @Test
    public void addEntityXEntitys() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr2 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr3 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr4 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());
        
        ec.addEntity(cr1);
        ec.addEntity(cr2);
        ec.addEntity(cr3);
        ec.addEntity(cr4);
        
        assertEquals(4, ec.getList().size());

    }

    @Test
    public void addEntityOneEntityMoreOften() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(ec.getList().size(), 0);
        
        ec.addEntity(cr1);
        ec.addEntity(cr1);
        ec.addEntity(cr1);

        assertEquals(1,ec.getList().size());

    }

    @Test
    public void addEntityNull() {

        assertEquals(0,ec.getList().size());
        
        ec.addEntity(null);

        //assertThrows(AssertionFailedError.class,() -> assertEquals(0,ec.getList().size()));
        assertEquals(0,ec.getList().size());
    }

    @Test
    public void removeEntityOne() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());

        ec.addEntity(cr1);

        ec.removeEntity(cr1);

        assertEquals(0,ec.getList().size());

    }

    @Test
    public void removeEntityXTimes() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr2 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr3 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr4 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());

        ec.addEntity(cr1);
        ec.addEntity(cr2);
        ec.addEntity(cr3);
        ec.addEntity(cr4);

        ec.removeEntity(cr1);
        ec.removeEntity(cr2);
        ec.removeEntity(cr3);
        ec.removeEntity(cr4);

        assertEquals(0,ec.getList().size());

    }

    @Test
    public void removeEntityOneMoreOften() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());

        ec.addEntity(cr1);

        ec.removeEntity(cr1);
        ec.removeEntity(cr1);
        ec.removeEntity(cr1);
        ec.removeEntity(cr1);

        assertEquals(0,ec.getList().size());

    }

    @Test
    public void removeEntityNull() {

        assertEquals(0,ec.getList().size());

        ec.removeEntity(null);

        assertEquals(0,ec.getList().size());

    }


    @Test
    public void removeAllOne() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());

        ec.addEntity(cr1);

        ec.removeAll();

        assertEquals(0,ec.getList().size());
    }

    @Test
    public void removeAllXEntitys() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr2 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr3 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr4 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());

        ec.addEntity(cr1);
        ec.addEntity(cr2);
        ec.addEntity(cr3);
        ec.addEntity(cr4);

        ec.removeAll();

        assertEquals(0,ec.getList().size());
    }

    @Test
    public void removeAllNothing() {

        assertEquals(0,ec.getList().size());

        ec.removeAll();

        assertEquals(0,ec.getList().size());
    }

    @Test
    public void removeAllFromClassY() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr2 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr3 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero cr4 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());

        ec.addEntity(cr1);
        ec.addEntity(cr2);
        ec.addEntity(cr3);
        ec.addEntity(cr4);

        ec.removeAllFrom(cr1.getClass());

        assertEquals(0,ec.getList().size());
    }

    @Test
    public void removeAllFromClassYAddXAndY() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz2 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz3 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz4 = new MyHero(movementspeed, maxLifepoints, dmg);

        MyHero2 cry1 = new MyHero2(movementspeed, maxLifepoints, dmg);
        MyHero2 cry2 = new MyHero2(movementspeed, maxLifepoints, dmg);
        MyHero2 cry3 = new MyHero2(movementspeed, maxLifepoints, dmg);
        MyHero2 cry4 = new MyHero2(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());

        ec.addEntity(crz1);
        ec.addEntity(crz2);
        ec.addEntity(crz3);
        ec.addEntity(crz4);

        ec.addEntity(cry1);
        ec.addEntity(cry2);
        ec.addEntity(cry3);
        ec.addEntity(cry4);

        ec.removeAllFrom(crz1.getClass());

        assertEquals(4,ec.getList().size());
    }

    @Test
    public void removeAllFromNull() {

        assertEquals(0,ec.getList().size());

        ec.removeAllFrom(null);

        assertEquals(0,ec.getList().size());
    }

    @Test
    public void removeAllFromNullAddXAndY() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz2 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz3 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz4 = new MyHero(movementspeed, maxLifepoints, dmg);

        MyHero2 cry1 = new MyHero2(movementspeed, maxLifepoints, dmg);
        MyHero2 cry2 = new MyHero2(movementspeed, maxLifepoints, dmg);
        MyHero2 cry3 = new MyHero2(movementspeed, maxLifepoints, dmg);
        MyHero2 cry4 = new MyHero2(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());

        ec.addEntity(crz1);
        ec.addEntity(crz2);
        ec.addEntity(crz3);
        ec.addEntity(crz4);

        ec.addEntity(cry1);
        ec.addEntity(cry2);
        ec.addEntity(cry3);
        ec.addEntity(cry4);

        assertThrows(NullPointerException.class, () -> ec.removeAllFrom(null));

        assertEquals(8,ec.getList().size());
    }

    @Test
    public void updateXNichtDeleteable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz2 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz3 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz4 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());

        ec.addEntity(crz1);
        ec.addEntity(crz2);
        ec.addEntity(crz3);
        ec.addEntity(crz4);

        ec.update();

        assertEquals(4,ec.getList().size());

    }

    @Test
    public void updateXDeleteable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz2 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz3 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz4 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());
        //make deleatable
        crz1.takeDmg(20);
        crz2.takeDmg(20);
        crz3.takeDmg(20);
        crz4.takeDmg(20);

        ec.addEntity(crz1);
        ec.addEntity(crz2);
        ec.addEntity(crz3);
        ec.addEntity(crz4);

        ec.update();

        assertEquals(0,ec.getList().size());

    }

    @Test
    public void updateOneNichtDeleteable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());
        
        ec.addEntity(crz1);

        ec.update();

        assertEquals(1,ec.getList().size());

    }

    @Test
    public void updateOneDeleteable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());
        //make deleatable
        crz1.takeDmg(20);

        ec.addEntity(crz1);

        ec.update();

        assertEquals(0,ec.getList().size());;

    }

    @Test
    public void updateOneDeleteableToNichtDeleatable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());
        //make deleatable
        crz1.takeDmg(20);

        ec.addEntity(crz1);

        crz1.heal(20);

        ec.update();

        assertEquals(1,ec.getList().size());

    }

    @Test
    public void updateOneNichtDeleteableToDeleatable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());
        
        ec.addEntity(crz1);
        //make deleatable
        crz1.takeDmg(20);

        ec.update();

        assertEquals(0,ec.getList().size());

    }

    @Test
    public void updateXEntityFromDeleteableToNichtDeleatable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz2 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz3 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz4 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());
        //make deleatable
        crz1.takeDmg(20);
        crz2.takeDmg(20);
        crz3.takeDmg(20);
        crz4.takeDmg(20);

        ec.addEntity(crz1);
        ec.addEntity(crz2);
        ec.addEntity(crz3);
        ec.addEntity(crz4);

        crz1.heal(20);
        crz2.heal(20);
        crz3.heal(20);
        crz4.heal(20);

        ec.update();

        assertEquals(4,ec.getList().size());

    }

    @Test
    public void updateXEntityFromNichtDeleteableToDeleatable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz2 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz3 = new MyHero(movementspeed, maxLifepoints, dmg);
        MyHero crz4 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(0,ec.getList().size());

        ec.addEntity(crz1);
        ec.addEntity(crz2);
        ec.addEntity(crz3);
        ec.addEntity(crz4);

        //make deleatable
        crz1.takeDmg(20);
        crz2.takeDmg(20);
        crz3.takeDmg(20);
        crz4.takeDmg(20);

        ec.update();

        assertEquals(0,ec.getList().size());
    }
}