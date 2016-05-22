package de.invidit.design.structural.flyweight;

import de.invidit.design.structural.flyweight.factory.PositionedImageFactory;
import de.invidit.design.structural.flyweight.model.ImagePosition;
import de.invidit.design.structural.flyweight.model.PositionedImage;
import de.invidit.design.structural.flyweight.report.MemoryUsageReporter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Weber
 * @since 21.05.2016
 */
public class MainWithNonFlyweight {
    public static void main(String...args) {
        MemoryUsageReporter memoryUsageReporter = new MemoryUsageReporter();
        memoryUsageReporter.ReportTo(System.out::println);

        List<PositionedImage> positionedImages = new ArrayList<>();
        PositionedImageFactory positionedImageFactory = new PositionedImageFactory();

        System.out.println("Loading 100 images.");
        for (int i = 0; i < 100; i++) {
            ImagePosition imagePosition = ImagePosition.builder()
                    .positionX(i)
                    .positionY(i)
                    .build();
            PositionedImage positionedImage = positionedImageFactory.createPositionedImage("images/Fliege.jpg", imagePosition);
            positionedImage.print();
            positionedImages.add(positionedImage);
        }
        memoryUsageReporter.ReportTo(System.out::println);
    }
}
