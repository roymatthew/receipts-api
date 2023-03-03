package edu.receitps.api.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
public class GeomertrcShapesTest {

    @Test
    public void testArea() {
        GeometricShape rectangle = (dim1, dim2) -> dim1 * dim2;
        double area = rectangle.evaluateArea(1,2);
        assertThat(area == 2);

        GeometricShape triangle = (b, h) -> .5 * b * h;
        double areaOfTriangle = triangle.evaluateArea(6,2);
        assertThat(areaOfTriangle == 6);
    }
}
