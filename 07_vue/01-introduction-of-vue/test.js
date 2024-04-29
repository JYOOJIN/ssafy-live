const user = {
  id: "ssafy",
  name: "정유진",
  age: 30,
  classNo: 10,
  info: function () {
    return this.name + ", " + this.age;
  },
};

const user2 = {
  id: "ssafy",
  name: "정유진",
  age: 30,
  classNo: 10,
  info() {
    //Consice method
    return this.name + ", " + this.age;
  },
};

//es5
// const user3 = {
//     useId: userId,
//     name: name,
//     age:age
// };

//es6: Property Shorthand
const user3 = {
  userId,
  name,
  age,
};

//let id = user.id;
//let name = user.name;
//let age = user.age;

//구조 분해 할당
let { id, name, age, classNo } = user;

console.log(id + "," + "," + age + ", " + classNo);
