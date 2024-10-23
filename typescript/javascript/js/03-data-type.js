// String
let name = "Diego Tamayo";

// Number
let number = 14;
let decimal = 3.1416;

// Boolean
let booleanName = true;
let numberBooleanName = Boolean(0); // 1 = true, 0 = false

console.log(
  typeof name,
  typeof number,
  typeof decimal,
  typeof booleanName,
  typeof numberBooleanName
);

// Array
let countries = ["España", "Mexico", "Colombia", "Argentina"];
console.log(typeof countries);

// NULL
let empty = null;
console.log(typeof empty);

// Undefined
let unDefined = undefined;
console.log(typeof unDefined);

// JSON
let movie = {
  title: "SPACE JAM",
  genere: "ANIMATION",
  year: 2021,
  director: "TARANTINO",

  view: function () {
    return `
            *** LA PELÍCULA DE LA SEMANA ***
            ==> ${this.title} - ${this.genere}
        `;
  },
};
console.log(movie);
console.log(movie.view());

movie.country = "EEUU";
movie["duration"] = "h2 15m";
console.log(movie);

delete movie.genere;
delete movie["director"];
console.log(movie);

console.log("title" in movie);
console.log("genere" in movie);

for (let attribute in movie) {
  let data = movie[attribute];
  if (data !== null && typeof data !== "function")
    console.log(attribute + "==>" + data);
}

// Symbol
let animal = Symbol("Tiger")
let animal2 = Symbol("Tiger")

console.log(animal)
console.log(animal2)
console.log(animal == animal2)
