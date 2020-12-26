function addFavourite(id) {
    let favourite = document.getElementById(id);
    //if red make it gray
    if (favourite.style.color == "rgb(251, 57, 88)") {
        $(favourite).removeClass("heart-animation")
        favourite.style.transition = "color 0.3s";

        favourite.style.color = "rgb(134, 129, 129)";
        return;
    }
    //if gray make it red
    if (favourite.style.color == "rgb(134, 129, 129)" || favourite.style.color == "") {
        $(favourite).addClass("heart-animation");
        favourite.style.transition = "color 0.3s";

        favourite.style.color = "rgb(251, 57, 88)";
        return;
    }
}