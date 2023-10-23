// Wait for the DOM to be ready
document.addEventListener("DOMContentLoaded", function () {
  // Get a reference to the form
  const form = document.getElementById("contactForm");

  // Attach a submit event listener to the form
  form.addEventListener("submit", function (event) {
    // Prevent the default form submission
    event.preventDefault();

    // Perform your validation here
    const nameInput = form.querySelector('input[name="uname"]');
    const emailInput = form.querySelector('input[name="uemail"]');
    const questionTextArea = form.querySelector('textarea[name="question"]');
    
    // Initialize a flag to check if the form is valid
    let isFormValid = true;

    // Validation for the name input (not empty)
    if (nameInput.value.trim() === "") {
      isFormValid = false;
      alert("Please enter your name.");
      nameInput.focus();
    }

    // Validation for the email input (valid email format)
    if (!isValidEmail(emailInput.value.trim())) {
      isFormValid = false;
      alert("Please enter a valid email address.");
      emailInput.focus();
    }

    // Validation for the question textarea (not empty)
    if (questionTextArea.value.trim() === "") {
      isFormValid = false;
      alert("Please type your message.");
      questionTextArea.focus();
    }

    // If the form is valid, you can submit it
    if (isFormValid) {
      form.submit();
    }
  });

  // Function to validate email format using a regular expression
  function isValidEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  }
});
