// Classic string
let name = "Diego";
let lastName = "Tamayo";
let profession = "Ingeniero en Sistemas";

// Template
let template = `
    Mi nombre es ${name} ${lastName}
    soy ${profession}
`;
console.log(template);

let data = `
<div class="ficha">
    <h2>${name} ${lastName}</h2>
    <h3>${profession}</h3>
    <p>Forma parte del equipo de programación</p>
</div>
`;

let box = document.createElement("section");
box.innerHTML = data;

document.addEventListener(
  "DOMContentLoaded",
  () => {
    document.body.appendChild(box);
  },
  false
);
