package by.omeganessy.shapetask.comparator;

import by.omeganessy.shapetask.entity.Tetrahedron;
import java.util.Comparator;

public class TetrahedronIdComparator implements Comparator<Tetrahedron>
    {
        @Override
        public int compare(Tetrahedron firstShape, Tetrahedron secondShape) {
            return Long.compare(firstShape.getId(), secondShape.getId());
        }
}
