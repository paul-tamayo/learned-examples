let names = ["Juan", "Manuel", "Pedro", "Carlos"];

// For of
for (let name of names) {
  console.log(name);
}

// For in
for (let index in names) {
  console.log(index);
}

// FOR in JSON
let movie = { key1: "value1", key2: "value2", key3: "value3" };
for (let key in movie) {
  console.log(key);
}

// FOR EACH
names.forEach((element) => console.log(element));
names.forEach((element, index, array) => console.log(element, index, array));

// ITERABLE
const iterable = names[Symbol.iterator]();
console.log(typeof iterable, iterable);
console.log(iterable.next());

movie[Symbol.iterator] = function () {
  let index = 0;
  let elements = Object.values(this);

  return {
    next() {
      let item = elements[index];
      if (index >= elements.length) {
        return {
          done: true,
          value: undefined,
        };
      }
      return { done: false, value: elements[index++] };
    },
  };
};

for (let attribute of movie) {
  console.log(attribute);
}
