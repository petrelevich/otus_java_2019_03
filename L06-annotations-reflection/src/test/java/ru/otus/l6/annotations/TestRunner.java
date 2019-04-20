package ru.otus.l6.annotations;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class TestRunner {
    public static void main(String[] args) {
        run(AnnotationsTest.class);
    }

    private static void run(Class<?> testClass) {
        // JUnit 5
        final LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectClass(testClass)
                )
                .build();

        final Launcher launcher = LauncherFactory.create();
        launcher.execute(request);

//        JUnit 4
//        JUnitCore junit = new JUnitCore();
//        junit.run(testClass.class);
    }
}
