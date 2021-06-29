package de.fhbielefeld.pmdungeon.vorgaben.game.Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import de.fhbielefeld.pmdungeon.vorgaben.graphic.Animation;
import de.fhbielefeld.pmdungeon.vorgaben.tools.Point;

import java.util.ArrayList;
import java.util.List;

class EntityControllerTest {

    package mystuff;

import de.fhbielefeld.pmdungeon.vorgaben.dungeonCreator.DungeonWorld;
import de.fhbielefeld.pmdungeon.vorgaben.graphic.Animation;
import de.fhbielefeld.pmdungeon.vorgaben.interfaces.IAnimatable;
import de.fhbielefeld.pmdungeon.vorgaben.interfaces.IEntity;
import de.fhbielefeld.pmdungeon.vorgaben.tools.Point;

/**
 * Base class for all characters
 */
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
        this.position = this.move();
        this.draw();
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
        public void takeDmg(int dmg) {}
    
        @Override
        public Point move() {
            Point newPosition = new Point(this.position);
            else return this.position;
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
            else return this.position;
        }
    
    
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

        assertEquals(getList(), 0);
        
        addEntity(cr1);
        addEntity(cr2);
        addEntity(cr3);
        addEntity(cr4);
        
        assertEquals(getList(), 4);

    }

    @Test
    public void addEntityOneEntityMoreOften() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(getList(), 0);
        
        addEntity(cr1);
        addEntity(cr1);
        addEntity(cr1);
        
        assertEquals(getList(), 1);

    }

    @Test
    public void addEntityOneEntityMoreOften() {

        assertEquals(getList(), 0);
        
        addEntity(null);
        
        assertEquals(getList(), 0);

    }

    @Test
    public void removeEntityOne() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(getList(), 0);

        addEntity(cr1);

        removeEntity(cr1);

        assertEquals(getList(), 0);

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

        assertEquals(getList(), 0);

        addEntity(cr1);
        addEntity(cr2);
        addEntity(cr3);
        addEntity(cr4);

        removeEntity(cr1);
        removeEntity(cr2);
        removeEntity(cr3);
        removeEntity(cr4);

        assertEquals(getList(), 0);

    }

    @Test
    public void removeEntityOneMoreOften() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(getList(), 0);

        addEntity(cr1);

        removeEntity(cr1);
        removeEntity(cr1);
        removeEntity(cr1);
        removeEntity(cr1);

        assertEquals(getList(), 0);

    }

    @Test
    public void removeEntityNull() {

        assertEquals(getList(), 0);

        removeEntity(null);

        assertEquals(getList(), 0);

    }


    @Test
    public void removeAllOne() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero cr1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(getList(), 0);

        addEntity(cr1);

        removeAll();

        assertEquals(getList(), 0);
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

        assertEquals(getList(), 0);

        addEntity(cr1);
        addEntity(cr2);
        addEntity(cr3);
        addEntity(cr4);

        removeAll();

        assertEquals(getList(), 0);
    }

    @Test
    public void removeAllXEntitys() {

        assertEquals(getList(), 0);

        removeAll();

        assertEquals(getList(), 0);
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

        assertEquals(getList(), 0);

        addEntity(cr1);
        addEntity(cr2);
        addEntity(cr3);
        addEntity(cr4);

        removeAllFrom(MyHero);

        assertEquals(getList(), 0);  
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

        assertEquals(getList(), 0);

        addEntity(crz1);
        addEntity(crz2);
        addEntity(crz3);
        addEntity(crz4);

        addEntity(cry1);
        addEntity(cry2);
        addEntity(cry3);
        addEntity(cry4);

        removeAllFrom(MyHero);

        assertEquals(getList(), 4);  
    }

    @Test
    public void removeAllFromNull() {

        assertEquals(getList(), 0);

        removeAllFrom(null);

        assertEquals(getList(), 0);  
    }

    @Test
    public void removeAllFromNullAddXAndY(Class<?> c) {

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

        assertEquals(getList(), 0);

        addEntity(crz1);
        addEntity(crz2);
        addEntity(crz3);
        addEntity(crz4);

        addEntity(cry1);
        addEntity(cry2);
        addEntity(cry3);
        addEntity(cry4);

        removeAllFrom(null);

        assertEquals(getList(), 8);  
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

        assertEquals(getList(), 0);

        addEntity(crz1);
        addEntity(crz2);
        addEntity(crz3);
        addEntity(crz4);

        update();

        assertEquals(getList(), 4);

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

        assertEquals(getList(), 0);
        //make deleatable
        crz1.takeDmg(20);
        crz2.takeDmg(20);
        crz3.takeDmg(20);
        crz4.takeDmg(20);

        addEntity(crz1);
        addEntity(crz2);
        addEntity(crz3);
        addEntity(crz4);

        update();

        assertEquals(getList(), 0);

    }

    @Test
    public void updateOneNichtDeleteable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(getList(), 0);
        
        addEntity(crz1);

        update();

        assertEquals(getList(), 1);

    }

    @Test
    public void updateOneDeleteable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(getList(), 0);
        //make deleatable
        crz1.takeDmg(20);

        addEntity(crz1);

        update();

        assertEquals(getList(), 0);

    }

    @Test
    public void updateOneDeleteableToNichtDeleatable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(getList(), 0);
        //make deleatable
        crz1.takeDmg(20);

        addEntity(crz1);

        crz1.heal(20);

        update();

        assertEquals(getList(), 1);

    }

    @Test
    public void updateOneNichtDeleteableToDeleatable() {

        float movementspeed = 10;
        int maxLifepoints = 20;
        int dmg= 10;

        MyHero crz1 = new MyHero(movementspeed, maxLifepoints, dmg);

        assertEquals(getList(), 0);
        
        addEntity(crz1);
        //make deleatable
        crz1.takeDmg(20);

        update();

        assertEquals(getList(), 0);

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

        assertEquals(getList(), 0);
        //make deleatable
        crz1.takeDmg(20);
        crz2.takeDmg(20);
        crz3.takeDmg(20);
        crz4.takeDmg(20);

        addEntity(crz1);
        addEntity(crz2);
        addEntity(crz3);
        addEntity(crz4);

        crz1.heal(20);
        crz2.heal(20);
        crz3.heal(20);
        crz4.heal(20);

        update();

        assertEquals(getList(), 4);

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

        assertEquals(getList(), 0);

        addEntity(crz1);
        addEntity(crz2);
        addEntity(crz3);
        addEntity(crz4);

        //make deleatable
        crz1.takeDmg(20);
        crz2.takeDmg(20);
        crz3.takeDmg(20);
        crz4.takeDmg(20);

        update();

        assertEquals(getList(), 4);
    }
}