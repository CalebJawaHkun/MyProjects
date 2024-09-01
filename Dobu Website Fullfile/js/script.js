let menu = document.querySelector('#menubtn');
let navbar = document.querySelector('.navbar');

menu.onclick = () =>{
	menu.classList.toggle('fa-times');
	navbar.classList.toggle('active');

}

 var swiper = new Swiper(".mySwiper", {
      slidesPerView: 1,
      spaceBetween: 30,
      loop: true,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
    });


function authenticate(event) {
  event.preventDefault(); // Prevent form submission
            
  var username = document.getElementById("username").value;
  var password = document.getElementById("password").value;
  var errorMessage = document.getElementById("error-message");
            
  if (username == "admin" && password == "1234") {
     window.location.href = "adminstration.html"; // Redirect to the admin page
    } else {
      errorMessage.innerHTML = "Invalid username or password.";
    }
}