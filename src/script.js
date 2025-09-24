
const name = "DANILA";

setInterval(() => {
    const randomIndex = Math.floor(Math.random() * name.length);
    const letter = name[randomIndex];
    console.log(letter);
}, 2000);
