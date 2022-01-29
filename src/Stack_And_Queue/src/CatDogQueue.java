package Stack_And_Queue.src;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {

    private Queue<PetEnterQueue> DogQ;
    private Queue<PetEnterQueue> CatQ;
    private long count;

    public CatDogQueue() {
        //多态的使用
        this.CatQ = new LinkedList<PetEnterQueue>();
        this.DogQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    //添加宠物，同时实现DogQ 和 CatQ 队列的添加
    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            //将dog 添加到队列中同时实现对应count的++
            this.DogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getPetType().equals("cat")) {
            //同上
            this.CatQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("err,not dog or cat!");
        }
    }

    public Pet pollAll() {
        if (!this.CatQ.isEmpty() && !this.DogQ.isEmpty()) {
            if (this.DogQ.peek().getCount() > this.CatQ.peek().getCount()) {
                return this.DogQ.poll().getPet();
            } else {
                return this.CatQ.poll().getPet();
            }
        } else if (!this.DogQ.isEmpty()) {
            return this.DogQ.poll().getPet();
        } else if (!this.CatQ.isEmpty()) {
            return this.CatQ.poll().getPet();
        } else {
            throw new RuntimeException("err,queue is empty!");
        }
    }

    public Dog pollDog() {
        if (!this.DogQ.isEmpty()) {
            //返回的是要给pet 要进行强转
            return (Dog) this.DogQ.poll().getPet();
        } else {
            throw new RuntimeException("err,queue is empty!");
        }
    }

    public Cat pollCat() {
        if (!this.CatQ.isEmpty()) {
            //返回的是要给pet 要进行强转
            return (Cat) this.CatQ.poll().getPet();
        } else {
            throw new RuntimeException("err,queue is empty!");
        }
    }

    public boolean isEmpty() {
        return this.DogQ.isEmpty() && this.CatQ.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.DogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.CatQ.isEmpty();
    }


}

//通过这个类实现，对要求的类进行计数
class PetEnterQueue {

    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getCount() {
        return this.count;
    }

    public String getPetType() {
        return this.pet.getPetType();
    }

}


//猫和狗的类
class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}