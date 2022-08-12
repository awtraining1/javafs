class Patient{

    constructor(name,age,ailment){
        this.name=name;
        this.age=age;
        this.ailment=ailment;
    }

    walk(){
        document.write(`<br/> I am ${this.name}, walking at the moment `);
    };

    talk = function(){
        document.write(`<br/> I am ${this.name}, talking at the moment `);
    }
};



class Doctor{

};


class Fruit{
    constructor(name,color,price){
        this.name=name;
        this.color=color;
        this.price=price;
    }
};


function Employee(name, age, hobs){
    this.name= name;
    this.age=age;
    this.hobbies=hobs;
 }

 class Farmer{

    constructor(name,age,phone){
        this.name=name;
        this.age=age;
        this.phone=phone;
    }

};