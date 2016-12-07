package com.javaweb.controller;

import com.javaweb.model.Model;
import com.javaweb.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Testing {@link Controller}
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class ControllerTest {
    private Model model;
    private View view;
    private Controller controller;

    @Before
    public void setUp() throws Exception {
        model = mock(Model.class);
        view = mock(View.class);
        controller = new Controller(model, view);
    }

    @Test
    public void getProperty() {
        String configPath =
                "D:/Studying/4Course/JavaTraining/ProjectsCode/" +
                        "Project2TextParser/src/test/java/com/javaweb/" +
                        "configuration/config.properties";

        assertEquals("small_text.txt",
                controller.getProperty(configPath, "file.name"));
    }

    @Test
    public void run() throws Exception {
        when(model.createDOM()).thenReturn(true);
        when(model.getInputFileName()).thenReturn("some_file");
        controller.run();
        verify(model).getText();
        verify(view).printlnMessage(String.format(
                View.TEXT_PARSED,
                model.getInputFileName()));
        verify(model).sortWordsByFirstConsonant();

    }
}