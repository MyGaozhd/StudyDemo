package com.gaozhd.suanfa.views.stack;

import android.util.Log;

import com.gaozhd.gkit.common.util.LogUtil;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.LinkedList;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: Stack1
 * @Description: ${todo}
 * @Date: 2017/8/3 0003 16:58
 */
public class Stack1 {

    public Stack1() {
        PetQueue queue = new PetQueue();
        queue.add(new Dog());
        queue.add(new Dog());
        queue.add(new Dog());
        queue.add(new Cat());
        queue.add(new Dog());
        queue.add(new Dog());

        LogUtil.logJson(queue);
        LogUtil.log("------------------------------------------");
        LogUtil.logJson(queue.pollCat());
        LogUtil.log("------------------------------------------");
        LogUtil.logJson(queue.pollDog());
        LogUtil.log("------------------------------------------");
        queue.pollAll();
        LogUtil.log("------------------------------------------");
        LogUtil.logJson(queue);
    }

    class PetQueue {
        private LinkedList<PetQueueItem> dogs = new LinkedList<>();
        private LinkedList<PetQueueItem> cats = new LinkedList<>();

        public LinkedList<PetQueueItem> getDogs() {
            return dogs;
        }

        public void setDogs(LinkedList<PetQueueItem> dogs) {
            this.dogs = dogs;
        }

        public LinkedList<PetQueueItem> getCats() {
            return cats;
        }

        public void setCats(LinkedList<PetQueueItem> cats) {
            this.cats = cats;
        }

        public void add(Pet pet) {
            if (Pet.CAT.equals(pet.getType())) {
                addCat(pet);
            } else if (Pet.DOG.equals(pet.getType())) {
                addDog(pet);
            } else {
                throw new RuntimeException(" must be cat or dog");
            }
        }

        private void addCat(Pet pet) {
            cats.add(new PetQueueItem(pet, count() + 1));
        }

        private void addDog(Pet pet) {
            dogs.add(new PetQueueItem(pet, count() + 1));
        }

        private int count() {
            return dogs.size() + cats.size();
        }

        private boolean isEmpty() {
            return cats.isEmpty() && dogs.isEmpty();
        }

        public void pollAll() {
            while (!isEmpty()) {
                poll();
                LogUtil.logJson(this);
            }
        }

        public Pet poll() {
            if (isEmpty()) {
                return null;
            }

            if (!dogs.isEmpty() && !cats.isEmpty()) {
                return dogs.getFirst().getCount() > cats.getFirst().getCount() ? cats.poll().getPet() : dogs.poll().getPet();
            } else if (!dogs.isEmpty() && cats.isEmpty()) {
                return dogs.poll().getPet();
            } else if (dogs.isEmpty() && !cats.isEmpty()) {
                return cats.poll().getPet();
            } else {
                return null;
            }
        }

        public Pet pollDog() {
            if (!dogs.isEmpty()) {
                return dogs.poll().getPet();
            } else {
                throw new RuntimeException(" dogs is empty");
            }

        }

        public Pet pollCat() {
            if (!cats.isEmpty()) {
                return cats.poll().getPet();
            } else {
                throw new RuntimeException(" cats is empty");
            }
        }
    }

    class PetQueueItem {
        private Pet pet;
        private int count;

        public PetQueueItem(Pet pet, int count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public void setPet(Pet pet) {
            this.pet = pet;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "type:" + pet.getType() + "  count:" + getCount();
        }
    }

    class Dog extends Pet {
        public Dog() {
            super(DOG);
        }
    }

    class Cat extends Pet {
        public Cat() {
            super(CAT);
        }
    }

    class Pet {
        public static final String DOG = "dog";
        public static final String CAT = "cat";
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
