package com.sbms.test.pages;

import com.sbms.test.model.Message;
import com.sbms.test.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HomePage extends Page {
    public static void navigate(String uriBase) {
        DriverFactory.getInstance().getDriver().navigate().to(String.format("%s%s", uriBase, "/"));
    }

    public String getPersonalizedMessage() {
        return driver().findElement(By.className("alert-primary")).findElement(By.tagName("span")).getText();
    }

    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<>();
        List<WebElement> rows = driver().findElement(By.tagName("table")).findElements(By.tagName("tr"));
        // skip the first row, which contains fields for entering a new message
        for (int index = 1; index < rows.size(); index ++) {
            WebElement row = rows.get(index);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            messages.add(new Message(cells.get(0).getText(), cells.get(1).getText()));
        }
        return messages;
    }
}
