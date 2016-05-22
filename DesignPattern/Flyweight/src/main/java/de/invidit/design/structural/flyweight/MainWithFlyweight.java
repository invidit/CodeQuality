package de.invidit.design.structural.flyweight;

import de.invidit.design.structural.flyweight.factory.PositionedFlyweightImageFactory;
import de.invidit.design.structural.flyweight.model.ImagePosition;
import de.invidit.design.structural.flyweight.model.PositionedFlyweightImage;
import de.invidit.design.structural.flyweight.report.MemoryUsageReporter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Weber
 * @since 21.05.2016
 */
public class MainWithFlyweight {
    public static void main(String...args) {
        MemoryUsageReporter memoryUsageReporter = new MemoryUsageReporter();
        memoryUsageReporter.ReportTo(System.out::println);

        List<PositionedFlyweightImage> positionedFlyweightImages = new ArrayList<>();
        PositionedFlyweightImageFactory positionedFlyweightImageFactory = new PositionedFlyweightImageFactory();

        System.out.println("Loading 100 images.");
        for (int i = 0; i < 100; i++) {
            PositionedFlyweightImage positionedFlyweightImage = positionedFlyweightImageFactory.createPositionedFlyweightImage("images/Fliege.jpg");
            ImagePosition imagePosition = ImagePosition.builder()
                    .positionX(i)
                    .positionY(i)
                    .build();
            positionedFlyweightImage.print(imagePosition);
            positionedFlyweightImages.add(positionedFlyweightImage);
        }

        memoryUsageReporter.ReportTo(System.out::println);
    }
}