
document.addEventListener("DOMContentLoaded", function () {

  const form = document.getElementById("contactForm");


  form.addEventListener("submit", function (event) {
    event.preventDefault();


    const nameInput = form.querySelector('input[name="uname"]');
    const emailInput = form.querySelector('input[name="uemail"]');
    const questionTextArea = form.querySelector('textarea[name="question"]');
    

    let isFormValid = true;


    if (nameInput.value.trim() === "") {
      isFormValid = false;
      alert("Please enter your name.");
      nameInput.focus();
    }


    if (!isValidEmail(emailInput.value.trim())) {
      isFormValid = false;
      alert("Please enter a valid email address.");
      emailInput.focus();
    }


    if (questionTextArea.value.trim() === "") {
      isFormValid = false;
      alert("Please type your message.");
      questionTextArea.focus();
    }


    if (isFormValid) {
      form.submit();
    }
  });

  function isValidEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  }
});
