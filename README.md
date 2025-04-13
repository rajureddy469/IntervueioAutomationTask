<!-- <<<<<<< HEAD -->
# IntervueAutomationTask
============================<br>
This Java Selenium automation script logs into [Intervue.io](https://www.intervue.io), performs a search, and logs out. 
It is built using Maven and uses WebDriverManager to manage the ChromeDriver automatically.

---

## 📁 Project Structure
<pre> ```
IntervueLoginAutomation/  │ 
├── src/main/java 
│── src/test/java/ 
│    └── IntervueTask/ 
│       └── CompletFlow.java 
├── src/
├── MavenDependencies/ 
├── pom.xml
``` </pre>


---

## 🔧 Prerequisites

Before you begin, ensure you have the following installed:

- Java 17 or higher  
- Maven  
- Google Chrome browser  
- Any Java IDE (Eclipse, IntelliJ IDEA, or VS Code)

> ✅ No need to manually download ChromeDriver. It's automatically managed by WebDriverManager.

---

## ⚙️ Maven Dependencies

All dependencies are added in your `pom.xml` file. Here are the key ones:

```xml
<dependencies>
    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.15.0</version>
    </dependency>

    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.5.3</version>
    </dependency>
</dependencies>
```


## ▶️ How to Run the Test
1. Clone or download this repository.
2. Open the project in your preferred Java IDE.
3. Run the following command to download dependencies:
<pre>  bash mvn clean install  </pre>
4. Navigate to src/test/java/IntervueTask/CompletFlow.java
5. Run the CompletFlow file as a Java application.


## 🔄 Script Flow Breakdown
Here's what the script does, step-by-step:

1. Launches the browser and opens https://www.intervue.io
2. Clicks the Login button, which opens in a new tab
3. Switches to the new tab using getWindowHandles()
4. Clicks Login with Email, enters:
``` Email: neha@intervue.io
Password: Ps@neha@123 
```
5. Waits for dashboard to load
6. Locates and clicks the search bar
7. Switches to the active popup, types "Hello", and clicks a suggestion
8. Opens profile dropdown and clicks Logout
9. Closes the browser after execution

## 📝 Notes
* The script uses both Thread.sleep() and WebDriverWait for waits.
* Adjust wait durations if facing page load delays.




