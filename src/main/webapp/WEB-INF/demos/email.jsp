<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${success}">
    <p>Email sent</p>
</c:if>
<form action="${appURL}/email" method="post">
    <!-- Email Address -->
    <label for="email">Email Address:</label>
    <input type="email" id="email" name="email" required>
    <br>

    <!-- Subject -->
    <label for="subject">Subject:</label>
    <input type="text" id="subject" name="subject" required>
    <br>

    <!-- Message -->
    <label for="message">Message:</label>
    <textarea id="message" name="message" rows="4" required></textarea>
    <br>

    <!-- Submit Button -->
    <input type="submit" value="Submit">
</form>

</body>
</html>
